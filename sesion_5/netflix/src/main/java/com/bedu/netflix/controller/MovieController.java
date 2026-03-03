package com.bedu.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bedu.netflix.model.Movie;
import com.bedu.netflix.service.MovieService;

/*
 * Los controladores solo deben de encargarse de obtener
 * o leer la informacion y regresar la informaciona traves del protocolo HTTP
 * 
 * Spring hace IoC (Inversion of Control)Es un mecanismo de Spring para crear 
 * automicamente las instancias/objetos de sus componentes
 * ---------------------------------------------
 * 
 * 
 * API => es un software para comunicar otro software 
 * 
 * API REST=>Son  APIs aplicando las buenas practicas 
 * 
 * 1. No hay , no existe  un estado , es decir, la peticion contiene toda 
 * la informacion  necesaria para funcionar 
 * 
 * 2. Transmitir XML o JSON (ya nadie usa XML)
 * 
 * 3. Al nombrar endpoint no usar verbos , voy a utulizar los sustantivos (en plural)
 * 
 * 4. utilizar los verbos /metodos de HTTP correctamente 
 *  a. GET --Leer informacion
 *  b. POST--Crear informacion 
 *  c. PUT--Actualizar informacion de manera parcial
 *  e. DELETE--Eliminar informacion
 *  
 * Nota: PATCH tecnicamente se usa para actualizar la informacion 
 * (lo mismo que put )pero PUT originalmente era para reemplazar toda la informacion 
 * 
 * Lo que se hizo fue dejar de usa PATCH y usar PUT como si fuera PATCH
 * 
 * GET/movies ->Obtner las peliculas
 * POST/movies->Crear una pelicula
 * 
 * Nota:@RequestMapping por defecto es GET
 * 
 * 5. Reflejar la jerarquia de los datos  en las URLs
 * 
 * GET/escuelas->Obtener las escuelas
 * GET/ alumnos->Obtener los alumnos
 * 
 * GET/escuelas/100/alumnos->Obtener los alumnos de la escuela 100
 * 
 * GET/escuelas/100/alumnos/20/calificaciones->De la escuela 100, del alumno 20, obtner sus calificaciones
 */
@RestController
public class MovieController {

    @Autowired // Genera una instancia de sin que yo lo pida (inyecta un componente)
    private MovieService service;

    // Obtener todas las peliculas
    @GetMapping("movies")
    public List<Movie> getMovies() {
        return service.getMovies();
    }

    // Obtener una pelicula
    @GetMapping("movies/{id}")
    public Movie getMovieById(@PathVariable int id) { 
        return service.getMovieById(id);
    }

    // Crear una pelicula
    @PostMapping("movies")
    public Movie creatMovie(@RequestBody Movie movie) {
        return service.createMovie(movie);
    }

    // Eliminar una pelicula

    // Actualizar una pelicula
}
