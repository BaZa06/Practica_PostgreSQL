module ni.edu.uam.registroempleadosfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.registroempleadosfx to javafx.fxml;
    exports ni.edu.uam.registroempleadosfx;
}