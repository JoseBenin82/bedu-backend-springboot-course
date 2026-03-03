
package com.bedu.games.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bedu.games.model.Game;

/**
 * Nota: Un backend es un API pero un API no siempre es un backend 
 * API: Aplication Programming Interface 
 * Es un software que permite conectar a otro software 
 * Idea:
 * Administrar informacion de videoguegos
 * -Obtener informacion de un videojuego en especifico(PathVariable)
 * -Obtener informacion de todos los videojuegos
 * -Dar de alta nuevos videojuegos (RequestBody)
 * -Editar videojuegos (PathVariable + RequestBody)
 * -Dar de baja videojuegos (Pathvariable)
 * 
 * CRUD (Create, Read, Update, Delete)
 * Un CRUD es un API/Backend que realiza dichas operaciones
 */

@RestController
public class GameController {
    private int currentId = 25;
    private List<Game> db = new LinkedList<>();

    public GameController() {
        db.add(new Game(23, "GTA V", 2013, "Accion"));
        db.add(new Game(24, "Super Mario Broos", 1985, "Plataformas"));
        db.add(new Game(25, "The King of Fighters", 1994, "Peleas"));
    }

    /**
     * Formas de pasar parametros a un API(4)
     * 1.Querystring
     * 
     * http://localhost:8080/endpoint ? parm1=valor1 & parm2=valor2...
     * 
     * 2. Pathvariable
     * 
     * http://localhost:8080/endpoint/{variable}
     * 
     * 3. RequestBody(@RequestBody)
     * 
     */
    // Obtener toda la informacion de los videojuegos
    @RequestMapping("getAllGames")

    public List<Game> getAll() {
        return db;
    }

    // Obtener informacion de un videojuego en especifico
    @RequestMapping("getGameById/{id}")

    public Game getOne(@PathVariable("id") int id) {
        for (Game game : db) {
            if (game.getId() == id) {
                return game;
            }
        }

        return null;
    }

    // Eliminar un videojuego
    @RequestMapping("deleteGame/{id}")
    public void deleteGame(@PathVariable("id") int id) {
        for (int i = 0; i < db.size(); i++) {
            Game game = db.get(i);
            if (game.getId() == id) {
                db.remove(i);
                break;
            }
        }
    }

    // Crear un videojuego
    // ++crurrentId:Incrementa en uno y luego aasigna el valor
    // currentId++: Asigna el valor actual a newGame.id y luego incrementa currentId
    @RequestMapping("createGame")
    public int create(@RequestBody Game newGame) {
        System.out.println(newGame);
        newGame.setId(++currentId);
        db.add(newGame);
        return newGame.getId();
    }

    // Actualizar un videojuego
    @RequestMapping("updateGame/{id}")
    public void update(@RequestBody Game updatedGame, @PathVariable("id") int id) {

        for (Game game : db) {
            if (game.getId() == id) {
                if (updatedGame.getTitle() != null) {
                    game.setTitle(updatedGame.getTitle());
                }

                if (updatedGame.getYear() != null) {
                    game.setYear(updatedGame.getYear());
                }

                if(updatedGame.getGenre()!=null){
                    game.setGenre(updatedGame.getGenre());
                }
                break;
            }
        }
    }

}

/**
 * for each: No nos interesa la posicion , solo el objeto
 * for(Game game:db){
 * }
 */
