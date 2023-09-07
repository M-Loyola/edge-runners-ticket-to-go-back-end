package com.tickettogo.TicketToGoBackend.service;

import com.tickettogo.TicketToGoBackend.entity.Cinema;
import com.tickettogo.TicketToGoBackend.entity.DetailsMovAndCin;
import com.tickettogo.TicketToGoBackend.exception.NoCinemaFound;
import com.tickettogo.TicketToGoBackend.repository.CinemaMovieRepository;
import com.tickettogo.TicketToGoBackend.repository.CinemaRepository;
import com.tickettogo.TicketToGoBackend.service.dto.MovieDetailsDto;
import com.tickettogo.TicketToGoBackend.entity.Movie;
import com.tickettogo.TicketToGoBackend.exception.NoMovieException;
import com.tickettogo.TicketToGoBackend.repository.MoviesRepository;
import com.tickettogo.TicketToGoBackend.service.mapper.MovieDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    MoviesRepository moviesRepository;

    @Autowired
    CinemaMovieRepository cinemaMovieRepository;
    @Autowired
    CinemaRepository cinemaRepository;

    public List<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }

    public List<Movie> getAllShowingMovies() {
        List<Movie> allMovies = getAllMovies();

        return allMovies.stream()
                .filter(Movie::getIsShowing)
                .collect(Collectors.toList());
    }

    public List<Movie> getAllUpComingMovies() {
        List<Movie> allMovies = getAllMovies();
        return allMovies.stream()
                .filter(movie -> !movie.getIsShowing())
                .collect(Collectors.toList());
    }

    public Movie findById(Integer id) {
        return moviesRepository.findById(id).orElseThrow(NoMovieException::new);
    }

    public MovieDetailsDto GetReservationDetails(Integer cinemaMovieId) {
        DetailsMovAndCin cinemaMovieById = cinemaMovieRepository.findById(cinemaMovieId).orElseThrow(NoMovieException::new);
        Movie movieById = moviesRepository.findById(cinemaMovieById.getMovie_Id()).orElseThrow(NoMovieException::new);
        Cinema cinemaById = cinemaRepository.findById((cinemaMovieById.getCinema_Id())).orElseThrow(NoCinemaFound::new);
        return MovieDetailsMapper.toEntity(movieById, cinemaById, cinemaMovieById);

    }

    public DetailsMovAndCin updateScheduleDetails(Integer cinemaMovieId, String newReservedSeats) {
        DetailsMovAndCin toBeUpdatedDetails = cinemaMovieRepository.findById(cinemaMovieId).orElseThrow(NoMovieException::new);
        if (occupiedSeatsIsNull(toBeUpdatedDetails.getOccupiedSeats())) {
            toBeUpdatedDetails.setOccupiedSeats("");
        }
        String newOccupiedSeats = createNewOccupiedSeatsString(toBeUpdatedDetails.getOccupiedSeats(), newReservedSeats);
        if (firstCharIsComma(newOccupiedSeats)) {
            newOccupiedSeats = newOccupiedSeats.substring(1);
        }
        toBeUpdatedDetails.setOccupiedSeats(newOccupiedSeats);
        return cinemaMovieRepository.save(toBeUpdatedDetails);
    }

    private boolean occupiedSeatsIsNull(String occupiedSeats) {
        return occupiedSeats == null;
    }

    private String createNewOccupiedSeatsString(String currentOccupiedSeats, String newOccupiedSeats) {
        return currentOccupiedSeats.concat(",").concat(newOccupiedSeats);
    }

    private boolean firstCharIsComma(String occupiedSeats) {
        return occupiedSeats.charAt(0) == ',';
    }
}
