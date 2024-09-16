package es.aritzherrero.partidajuego;

/**
 * La clase {@code Enemigo} representa a un enemigo en un juego
 * y hereda las características de la clase {@code Persona}.Esta clase especialica la creacion de un personaje
 *
 * @author Aritz
 * @version 1.0
 */
public class Enemigo extends Persona {

    /**
     * Crea una nueva instancia de {@code Enemigo} con el nombre y el número de vidas
     * especificados.
     *
     * @param N El nombre del enemigo.
     * @param v El número inicial de vidas del enemigo.
     */
    public Enemigo(String N, int v) {
        // Llama al constructor de la clase base (Persona) con los parámetros recibidos.
        super(N, v);
    }
}
