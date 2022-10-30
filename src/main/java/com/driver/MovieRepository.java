package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieRepository {

    List<Movie> movies = new ArrayList<>();

    List<Director> directors = new ArrayList<>();

    HashMap<Director,ArrayList<Movie>> md = new HashMap<>();
    ArrayList<Movie> m1;

    String addMovie(Movie movie)
    {
        movies.add(movie);
        return "Success";
    }

    String addDirector(@RequestBody()Director director)
    {
        directors.add(director);
        return "Success";
    }

    String addMovieDirectorPair(Movie mname,Director dname)
    {
        m1 = md.get(dname);
        m1.add(mname);
        md.put(dname,m1);
        return "Success";
    }

    Movie getMovieByName(String name)
    {
        for(Movie m : movies)
        {
            if(m.getName()==name)
            {
                return m;
            }
        }
        return null;
    }

    Director getDirectorByName(String name)
    {
        for(Director d : directors)
        {
            if(d.getName()==name)
            {
                return d;
            }
        }
        return null;
    }


    List<Movie> getMoviesByDirectorName(Director director)
    {
        List<Movie> res = new ArrayList<>();
        res=md.get(director);
        return res;
    }

    List<Movie> findAllMovies()
    {
        return movies;
    }

    String deleteDirectorByName(@RequestParam("name")String name)
    {
        for(Director d : directors)
        {
            if(d.getName()==name)
            {
                directors.remove(d);
            }
        }
        return "Success";
    }

    String deleteAllDirectors()
    {
        directors.clear();
        return "Success";
    }
}
