package es.aritzherrero.partidajuego;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.security.Principal;
import java.util.Random;
/**
 * La clase {@code HelloApplication} es una aplicación JavaFX que simula un juego
 * donde un personaje principal y un enemigo lanzan dados para determinar quién
 * pierde vidas. La aplicación permite reiniciar el juego y muestra la información
 * actual en la interfaz gráfica.
 *
 * @author Aritz
 * @version 1.0
 */
public class HelloApplication extends Application {

    // Instancia de Enemigo y PersonajePrincipal con atributos iniciales
    Enemigo enemigo = new Enemigo("Duende ", 3);
    PersonajePrincipal personaje = new PersonajePrincipal("Aritz ", 3);

    // Etiquetas para mostrar resultados y estados en la interfaz
    Label numDadRival = new Label("??");
    Label numDadPrinc = new Label("??");
    Label vidasEne = new Label(enemigo.vidas + " vidas");
    Label vidasPrinc = new Label(personaje.vidas + " vidas");

    // Botones para interactuar con la interfaz
    Button tiraDados = new Button("Tirar Dados");
    Button reiniciar = new Button("Jugar Otra Vez");


    /**
     * Metodo principal que configura y muestra la interfaz gráfica de la aplicación.
     *
     * @param stage El escenario principal de la aplicación.
     */
    public void start(Stage stage) {
        // Crear un contenedor vertical para la ventana principal
        VBox ventanaV = new VBox();

        // Configurar el título de la ventana
        stage.setTitle("PartidaDado");

        // Crear una etiqueta para mostrar el nombre del enemigo y del personaje principal
        Label ene = new Label(enemigo.nombre);
        Label princ = new Label(personaje.nombre);

        // Crear un contenedor horizontal para los dados y la información de los personajes
        HBox ventaDado = new HBox();

        // Etiquetas para mostrar información sobre los dados de cada personaje
        Label dadRiv = new Label("Dado " + enemigo.nombre + " ");
        Label dadPrinc = new Label(" Dado " + personaje.nombre + " ");


        // Inicializar el botón de reinicio como deshabilitado al inicio
        reiniciar.setDisable(true);

        // Contenedor horizontal para el enemigo y sus vidas
        HBox boxrival = new HBox();
        boxrival.getChildren().addAll(ene, vidasEne);

        // Contenedor horizontal para los dados y sus valores
        HBox boxDados = new HBox();
        boxDados.getChildren().addAll(dadRiv, numDadRival, dadPrinc, numDadPrinc);

        // Contenedor horizontal para el personaje principal y sus vidas
        HBox boxPrincipal = new HBox();
        boxPrincipal.getChildren().addAll(princ, vidasPrinc);

        // Agregar los contenedores y botones al contenedor principal
        ventanaV.getChildren().addAll(boxrival, boxDados, boxPrincipal, tiraDados, reiniciar);

        // Crear una escena con el contenedor principal
        Scene scene = new Scene(ventanaV, 420, 240);

        // Configurar las acciones de los botones
        tiraDados.setOnAction(e -> tirarDados());
        reiniciar.setOnAction(e -> reiniciarPartida());

        // Establecer la escena en el escenario y mostrar la ventana
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Reinicia la partida, restableciendo las vidas de los personajes, los valores de los dados,
     * y actualiza las etiquetas correspondientes. Deshabilita el botón de reinicio y habilita
     * el botón de tirar dados.
     */
    public void reiniciarPartida() {
        // Restablecer las vidas de los personajes
        enemigo.vidas = 3;
        personaje.vidas = 3;
        // Actualizar las etiquetas con el número de vidas
        vidasPrinc.setText(personaje.vidas + " vidas");
        vidasEne.setText(enemigo.vidas + " vidas");
        // Reiniciar los valores de los dados
        numDadRival.setText("??");
        numDadPrinc.setText("??");
        // Deshabilitar el botón de reinicio y habilitar el botón de tirar dados
        reiniciar.setDisable(true);
        tiraDados.setDisable(false);
    }

    /**
     * Lanza los dados para el enemigo y el personaje principal, compara los resultados y
     * actualiza las vidas y etiquetas correspondientes. Deshabilita el botón de tirar dados
     * y habilita el botón de reinicio si uno de los personajes pierde todas sus vidas.
     */
    public void tirarDados() {
        Random ale = new Random();
        // Generar dos números aleatorios entre 1 y 6 (inclusive)
        int dado1 = ale.nextInt(6) + 1;
        int dado2 = ale.nextInt(6) + 1;
        // Mostrar los resultados de los dados en las etiquetas
        numDadRival.setText(dado1 + "");
        numDadPrinc.setText(dado2 + "");
        // Determinar el ganador comparando los resultados de los dados
        if (dado1 > dado2) {
            // El personaje pierde si el dado del enemigo es mayor
            if (personaje.perderVida()) {
                vidasPrinc.setText("Has perdido todas las vidas has sido derrotado");
                tiraDados.setDisable(true); // Deshabilitar el botón de tirar dados
                reiniciar.setDisable(false); // Habilitar el botón de reinicio
            } else {
                vidasPrinc.setText(personaje.vidas + " vidas");
            }
        } else if (dado2 > dado1) {
            // El enemigo pierde si el dado del personaje es mayor
            if (enemigo.perderVida()) {
                vidasEne.setText("El enemigo ha perdido todas las vidas HAS GANADO");
                tiraDados.setDisable(true); // Deshabilitar el botón de tirar dados
                reiniciar.setDisable(false); // Habilitar el botón de reinicio
            } else {
                vidasEne.setText(enemigo.vidas + " vidas");
            }
        }
    }
    /**
     * Método principal que lanza la aplicación JavaFX.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        launch();
    }
}