package com.driver;

import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
            MovieService movieService;

@PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody()Movie movie)
{
//    movieService.addMovie(movie);
    return new ResponseEntity<>(movieService.addMovie(movie),HttpStatus.ACCEPTED);
}

@PostMapping("/movies/add-director")
public ResponseEntity<String> addDirector(@RequestBody()Director director)
{
//    movieService.addDirector(director);
    return new ResponseEntity<>(movieService.addDirector(director),HttpStatus.ACCEPTED);
}

@PutMapping("/movies/add-movie-director-pair")
public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie-name")Movie mname, @RequestParam("director-name")Director dname)
{
//    MDPair.put(mname,dname);
//    movieService.addMovieDirectorPair(mname,dname);
    return new ResponseEntity<>(movieService.addMovieDirectorPair(mname,dname),HttpStatus.ACCEPTED);
}


@GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name)
{
//    movieService.getMovieByName(name);
    return new ResponseEntity<>(movieService.getMovieByName(name),HttpStatus.ACCEPTED);
}

@GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name)
{
//    movieService.getDirectorByName(name);
    return new ResponseEntity<>(movieService.getDirectorByName(name),HttpStatus.ACCEPTED);
}

@GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable("director")Director director)
{
//    movieService.getMoviesByDirectorName(director);
    return new ResponseEntity<>(movieService.getMoviesByDirectorName(director),HttpStatus.ACCEPTED);
}

@GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies()
{
//    movieService.findAllMovies();
    return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.ACCEPTED);
}

@DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name)
{
//    movieService.deleteDirectorByName(name);
    return new ResponseEntity<>(movieService.deleteDirectorByName(name),HttpStatus.ACCEPTED);
}

@DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
{
//    movieService.deleteAllDirectors();
    return new ResponseEntity<>(movieService.deleteAllDirectors(),HttpStatus.ACCEPTED);
}
}
