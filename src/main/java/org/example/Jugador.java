package org.example;

import lombok.Getter;

import java.util.List;

@Getter
public class Jugador {
    private String nombre;
    private Mazo mazo;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mazo=new Mazo();
    }

    @Override
    public String toString() {
        return getNombre();
    }


}
