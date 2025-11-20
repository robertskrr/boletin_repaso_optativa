package com.example.ej04traductorexpres;

import java.util.HashMap;
import java.util.Map;

public class Traducciones {
    private static final Map<String, String> traducciones = new HashMap<>();

    public Traducciones() {
        traducciones.put("Hola", "Hello");
        traducciones.put("Casa", "House");
        traducciones.put("Fútbol", "Football");
        traducciones.put("Sevilla", "Seville");
        traducciones.put("Programador", "Developer");
        traducciones.put("Ordenador", "Computer");
        traducciones.put("Italia", "Italy");
    }

    public static Map<String, String> getTraducciones() {
        return traducciones;
    }
}
