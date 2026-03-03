package org.bedu.primerproyecto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class PruebaController {


     // URL: http://localhost:8080/hello
    @RequestMapping("hello")
    public String helloWorld() {
        return "hello world jose julio";
    }
    @RequestMapping("mundo")
    public String  goodByeWorld() {
        return "Goodbye World";
    }

    public String nombre(){
        return "Julius";
    }



}
