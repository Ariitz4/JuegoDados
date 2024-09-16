module es.aritzherrero.partidajuego {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens es.aritzherrero.partidajuego to javafx.fxml;
    exports es.aritzherrero.partidajuego;
}