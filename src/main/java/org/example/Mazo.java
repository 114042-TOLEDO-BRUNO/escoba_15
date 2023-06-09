package org.example;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
@Data


public class Mazo {
    private List<Carta> cartas;
    public Mazo(){
        this.cartas = new ArrayList<Carta>();
    }
    public void crearMazoCompleto(){
        //genera el mazo
        for(Palo paloCarta : Palo.values()){
            for(Valor valorCarta : Valor.values()){
                //agregar cartas al mazo
                this.cartas.add(new Carta(paloCarta, valorCarta));
            }
        }
    }
    public int valorDeCartas() {
        int totalValor=0;
        Map<Valor,Integer>valores=new HashMap<>();
        valores.put(Valor.UNO,1);
        valores.put(Valor.DOS,2);
        valores.put(Valor.TRES,3);
        valores.put(Valor.CUATRO,4);
        valores.put(Valor.CINCO,5);
        valores.put(Valor.SEIS,6);
        valores.put(Valor.SIETE,7);
        valores.put(Valor.SOTA,8);
        valores.put(Valor.CABALLERO,9);
        valores.put(Valor.REY,10);
        for(Carta carta:cartas){
            totalValor+=valores.get(carta.getValor());
        }
        return totalValor;
    }
    public void mezclarMazo(){
        Collections.shuffle(cartas);
    }
    public void borrarCarta(int indice){
        this.cartas.remove(indice);
    }
    public Carta getCarta(int indice){
        return this.cartas.get(indice);
    }
    public void agregarCarta(Carta addCarta){
        this.cartas.add(addCarta);
    }
    public String mostrar(Mazo mazo){
        this.cartas.add(mazo.getCarta(0));
        mazo.borrarCarta(0);
        return mazo.getCarta(0).toString();
    }
    public int cantidadEnMazo(){
        return cartas.size();
    }
    public void repartirCartas(List<Jugador>jugadores,int numCartas){
        int totalCartas = jugadores.size() * numCartas;

        for (int i = 0; i < totalCartas; i++) {
            Jugador jugadorActual = jugadores.get(i % jugadores.size()); // Obtener el jugador actual entrega de forma ciclica
            Carta carta = this.cartas.remove(0); // Remover la primera carta del mazo
            jugadorActual.getMazo().agregarCarta(carta); // Agregar la carta al mazo del jugador
        }
    }
    public List<Carta>getCartas(){
        return cartas;
    }


}
