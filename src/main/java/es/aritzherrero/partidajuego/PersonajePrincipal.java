package es.aritzherrero.partidajuego;

/**
 * La clase {@code PersonajePrincipal} representa a un personaje principal en un juego
 * y hereda las características de la clase {@code Persona}.Esta clase especialica la creacion de un personaje
 *
 * @author Aritz
 * @version 1.0
 */
public class PersonajePrincipal extends Persona{

    /**
     * Crea una nueva instancia de {@code PersonajePrincipal} con el nombre y el número de vidas
     * especificados.
     *
     * @param N El nombre del personaje principal.
     * @param v El número inicial de vidas del personaje principal.
     */
    public PersonajePrincipal(String N,int v) {
        // Llama al constructor de la clase base (Persona) con los parámetros recibidos.
        super(N,v);
    }
}
