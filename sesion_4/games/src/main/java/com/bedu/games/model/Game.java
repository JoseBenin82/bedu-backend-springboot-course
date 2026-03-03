package com.bedu.games.model;




/**
 * POJO (Plain Old Java Object)
 * Es una clase que solo tiene atributos, constructores, getters y setters
 * En resumen, no tiene metodos mas que los get y set.
 * No utuliza herencia especial , ni implementa interfaces
 */
public class Game {
    // Usaremos el Integer ya que un null no puede ser un tipo int,
    // pero si un Integer(lo ideal es construir una clase especial
    // para crear un nuevo videojuego, pero por simplicidad usaremos esta clase)
    private Integer id;
    private String title;
    private Integer year;
    private String genre;

    
    public Game(Integer id, String title, Integer year, String genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "[Titulo:" + title + " Año: " + year + " Genero: " + genre + "]";
    }

}
