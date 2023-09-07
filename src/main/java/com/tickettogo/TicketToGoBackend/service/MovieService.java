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
import com.tickettogo.TicketToGoBackend.service.dto.MovieDetailsMapper;
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

    public MovieDetailsDto GetReservationDetails(Integer cinemaMovieId){
        DetailsMovAndCin cinemaMovieById = cinemaMovieRepository.findById(cinemaMovieId).orElseThrow(NoMovieException::new);
        Movie movieById = moviesRepository.findById(cinemaMovieById.getMovie_Id()).orElseThrow(NoMovieException::new);
        Cinema cinemaById = cinemaRepository.findById((cinemaMovieById.getCinema_Id())).orElseThrow(NoCinemaFound::new);
        return MovieDetailsMapper.toEntity(movieById, cinemaById, cinemaMovieById);

    }

    public DetailsMovAndCin updateScheduleDetails(Integer cinemaMovieId, String newReservedSeats) {
        DetailsMovAndCin toBeUpdatedDetails = cinemaMovieRepository.findById(cinemaMovieId).orElseThrow(NoMovieException::new);
        if(toBeUpdatedDetails.getOccupiedSeats() == null) {
            toBeUpdatedDetails.setOccupiedSeats("");
        }
        String newOccupiedSeats = toBeUpdatedDetails.getOccupiedSeats().concat(",").concat(newReservedSeats);
        if(newOccupiedSeats.charAt(0) == ',') {
            newOccupiedSeats = newOccupiedSeats.substring(1);
        }
        toBeUpdatedDetails.setOccupiedSeats(newOccupiedSeats);
        return cinemaMovieRepository.save(toBeUpdatedDetails);
    }
}
