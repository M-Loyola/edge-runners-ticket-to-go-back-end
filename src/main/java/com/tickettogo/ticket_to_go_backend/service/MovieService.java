package com.tickettogo.ticket_to_go_backend.service;

import com.tickettogo.ticket_to_go_backend.entity.Cinema;
import com.tickettogo.ticket_to_go_backend.entity.DetailsMovAndCin;
import com.tickettogo.ticket_to_go_backend.entity.Movie;
import com.tickettogo.ticket_to_go_backend.exception.NoCinemaFound;
import com.tickettogo.ticket_to_go_backend.exception.NoMovieException;
import com.tickettogo.ticket_to_go_backend.repository.CinemaMovieRepository;
import com.tickettogo.ticket_to_go_backend.repository.CinemaRepository;
import com.tickettogo.ticket_to_go_backend.repository.MoviesRepository;
import com.tickettogo.ticket_to_go_backend.service.dto.MovieDetailsDto;
import com.tickettogo.ticket_to_go_backend.service.mapper.MovieDetailsMapper;
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

    public MovieDetailsDto getReservationDetails(Integer movieId, Integer cinemaId) {
        DetailsMovAndCin cinemaMovieById = cinemaMovieRepository.findOneByMovieIdAndCinemaId(movieId, cinemaId).stream().findFirst().orElseThrow(NoMovieException::new);

        ///
        Movie movieById = moviesRepository.findById(cinemaMovieById.getMovieId()).orElseThrow(NoMovieException::new);
        Cinema cinemaById = cinemaRepository.findById((cinemaMovieById.getCinemaId())).orElseThrow(NoCinemaFound::new);
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
