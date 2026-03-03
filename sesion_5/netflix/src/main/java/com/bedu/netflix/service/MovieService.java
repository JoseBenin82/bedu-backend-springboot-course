package com.bedu.netflix.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bedu.netflix.model.Movie;

/**
 * Nota: Las capas Spring las conoce como "Componentes"
 * La capa de servicio se encarga de aplicar algoritmos, validaciones,
 * logica de negocio (reglas)
 * 
 * El servicio no tiene acceso a nada de HTTP, se asume que cada metodo
 * recibe la informacion que necesita de la capa de arriba(controller)
 * 
 * 
 */

@Service // Tambien se puede usar @Component
public class MovieService {

    private int currentId = 1;
    private List<Movie> movies = new LinkedList<>();

    public MovieService() {
        List<Integer> actors1 = new LinkedList<>();
        actors1.add(1); // Leonardo Di caprio
        actors1.add(2);// kate Winslet

        Movie m1 = new Movie();
        m1.setId(currentId++);
        m1.setTitle("Titanic");
        m1.setYear(1997);
        m1.setActors(actors1);
        m1.setGenre("Romance");

        movies.add(m1);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    // Metodo par amandar atraer una pelicula
    public Movie getMovieById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    // Metodo crea peliculas y de alli se manda a llamar en el controlador
    public Movie createMovie(Movie movie) {

        movie.setId(currentId++);
        movies.add(movie);
        return movie;

    }

}
