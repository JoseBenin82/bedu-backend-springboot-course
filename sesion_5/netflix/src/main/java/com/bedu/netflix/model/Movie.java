package com.bedu.netflix.model;
//POJO(Plain Old java Object): Una clase con solo atributos, getters y setters 

import java.util.List;

public class Movie {

    private int id;
    private String title; 
    private String genre; 
    private  int year; 
    private List<Integer>actors;
 /* 
    Movie(int id , String title, String genre, int year, List<Integer> actors){
        this.id=id;
        this.title=title; 
        this.genre=genre; 
        this.year=year; 
        this.actors=actors;

    }
*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Integer> getActors() {
        return actors;
    }

    public void setActors(List<Integer> actors) {
        this.actors = actors;
    }

    
    
    
}
