package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static Scanner scanner=new Scanner(System.in);
    public static List<Jugador> cargarJugadores() {
        List<Jugador>jugadores=new ArrayList<>();
        for(int i=0;i<2;i++){
            System.out.println("Ingrese el nombre del jugador N°"+(i+1));
            String nombre=scanner.nextLine();
            Jugador jugador=new Jugador(nombre);
            jugadores.add(jugador);
        }
        return jugadores;
    }
    public static void main(String[] args) {
        System.out.println("Este es la ESCOBA DE 15");
        Mazo mazo=new Mazo();
        mazo.crearMazoCompleto();
        mazo.mezclarMazo();
        List<Jugador>jugadores=cargarJugadores();
        int numCartasPorJugador=3;
        mazo.repartirCartas(jugadores,numCartasPorJugador);
        for(Jugador jugador:jugadores){
            List<Carta>cartas=jugador.getMazo().getCartas();
            System.out.println("Las cartas de "+jugador.toString()+
                    " son las siguientes: ");
            for(int i=0;i<cartas.size();i++){
                System.out.print(cartas.get(i));
                if(i<cartas.size()-1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }
}