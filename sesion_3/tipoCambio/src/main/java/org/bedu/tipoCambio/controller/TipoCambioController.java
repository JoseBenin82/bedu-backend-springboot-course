package org.bedu.tipoCambio.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bedu.tipoCambio.model.TipoCambio;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
USD
 MXN=18.01
 ARS=1433.88

MXN
 USD=0.056
 ARS=79.3
 
*/
@RestController
// Controller= HTTP

public class TipoCambioController {

    private List<TipoCambio> baseDatos;

    public TipoCambioController() {
        this.baseDatos = new ArrayList<>();

        HashMap<String, Double> conversionDolar = new HashMap<>();
        conversionDolar.put("MXN", 18.01);
        conversionDolar.put("ARS", 1433.88);
        this.baseDatos.add(new TipoCambio("USD", conversionDolar));

        HashMap<String, Double> conversionMexicano = new HashMap<>();
        conversionMexicano.put("USD", 0.056);
        conversionMexicano.put("ARS", 79.3);
        this.baseDatos.add(new TipoCambio("MXN", conversionMexicano));

        HashMap<String, Double> conversionArgentino = new HashMap<>();
        conversionArgentino.put("USD", 0.0007);
        conversionArgentino.put("MXN", 0.013);
        this.baseDatos.add(new TipoCambio("ARS", conversionArgentino));

    }

    // Los metodos en un contralador son endpoints
    // Endpoint= URL
    // http://localhost:8080/hello
    @RequestMapping("hello")
    public String helloWorld() {
        return "Hello World";
    }

    /**
     * en un backend existen 4 formas de pasar parametros a un endpoint
     * 1.Path Variable (RequestVariable)
     * Un pedazo de la URL es una variable.Po ejemplo:
     * /clima/puebla, /clima/cdmx, /clima/monterrey
     * tiktok.com/@pepito, tiktok.com/@jose234
     * 
     * 2.Querystring (RequestParam)
     * Son parametros que van al final de la URL, son opcionales(pero en Spring son
     * obligatorios) y son de la forma
     * llave=valor
     * Si son mas de una variable se usa el & para separarlas
     * ?variable1=valor1&variable2=valor2
     * 
     * POr ejemplo:
     * amazoon.com/productos/12345?color=rojo&talla=m
     *
     */

    // 1.Obtener todas la conversiones de una moneda en especifico
    // http://localhost:8080/conversiones/
    @RequestMapping("conversiones/{codigo}")

    public HashMap<String, Double> obtenerConversiones(@PathVariable("codigo") String codigo) {
        // Iteramos nuestra base de datos para encontrar el codigo que nos estan
        // pidiendo
        for (TipoCambio tipoCambio : baseDatos) {

            // Si el codigo que nos estan pidiendo es igual al codigo de la iteracion
            // actual, entonces regresamos las conversiones
            if (tipoCambio.getCodigo().equals(codigo.toUpperCase())) {

                // Regresamos las conversiones de ese codigo
                return tipoCambio.getConversiones();
            }
        }
        // Si no existe el tipo de cambio regresamos null
        return null;

    }

    // http://localhost:8080/conversiones/usd/convertir/mxn?cantidad=20
    @RequestMapping("conversiones/{codigo}/convertir/{destino}")

    public double convertir(
            @PathVariable("codigo") String codigo,
            @PathVariable("destino") String destino,
            @RequestParam("cantidad") int cantidad) {

        for (TipoCambio tipoCambio : baseDatos) {

            if (tipoCambio.getCodigo().equals(codigo.toUpperCase())) {
                Double valor = tipoCambio.getConversiones().get(destino.toUpperCase());

                if (valor == null) {
                    return 0;

                } else {
                    return cantidad == 0 ? valor : valor * cantidad;
                }
            }
        }
        return 0;

}
}