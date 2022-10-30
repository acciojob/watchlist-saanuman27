package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    String addMovie(@RequestBody()Movie movie)
    {
//        movieRepository.addMovie(movie);
        return movieRepository.addMovie(movie);
    }

    String addDirector(@RequestBody()Director director)
    {
//        movieRepository.addDirector(director);
        return movieRepository.addDirector(director);
    }

    String addMovieDirectorPair(Movie mname,Director dname)
    {
//        movieRepository.addMovieDirectorPair(mname,dname);
        return movieRepository.addMovieDirectorPair(mname,dname);
    }

    Movie getMovieByName(@PathVariable("name") String name)
    {
//        movieRepository.getMovieByName(name);
        return movieRepository.getMovieByName(name);
    }

    Director getDirectorByName(@PathVariable("name")String name)
    {
//        movieRepository.getDirectorByName(name);
        return movieRepository.getDirectorByName(name);
    }

    List<Movie> getMoviesByDirectorName(@PathVariable("director") Director director)
    {
//        movieRepository.getMoviesByDirectorName(director);
        return movieRepository.getMoviesByDirectorName(director);
    }

    List<Movie> findAllMovies()
    {
//        movieRepository.findAllMovies();
        return movieRepository.findAllMovies();
    }

    String deleteDirectorByName(@RequestParam("name")String name)
    {
//        movieRepository.deleteDirectorByName(name);
        return movieRepository.deleteDirectorByName(name);
    }

    String deleteAllDirectors()
    {
//        movieRepository.deleteAllDirectors();
        return movieRepository.deleteAllDirectors();
    }
}
