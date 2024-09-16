package es.aritzherrero.partidajuego;

import java.util.Random;
/**
 * La clase {@code Persona} representa a una entidad que tiene un nombre y un número
 * de vidas. Proporciona un metodo para perder vidas y determinar si la entidad ha
 * quedado sin vidas.
 *
 * <p>Esta clase puede ser utilizada como base para personajes o entidades en un juego
 * donde las vidas son un atributo importante.</p>
 *
 * @author Aritz
 * @version 1.0
 */
public class Persona {
    // Atributos de la clase
    int vidas;
    String nombre;

    /**
     * Crea una nueva instancia de {@code Persona} con el nombre y el número de vidas
     * especificados.
     *
     * @param N El nombre de la persona.
     * @param v El número inicial de vidas de la persona.
     */
    public Persona(String N, int v) {
        nombre = N;
        vidas = v;
    }

    /**
     * Reduce el número de vidas de la persona en 1.Devuelve {@code true} si la persona ha perdido todas sus vidas
     * (es decir, si el número de vidas llega a 0), y {@code false} en caso contrario.
     *
     * @return {@code true} si la persona ha quedado sin vidas, {@code false} en caso contrario.
     */
    public boolean perderVida() {
        vidas = vidas - 1;
        if (vidas == 0) {
            return true;
        } else {
            return false;
        }
    }
}
