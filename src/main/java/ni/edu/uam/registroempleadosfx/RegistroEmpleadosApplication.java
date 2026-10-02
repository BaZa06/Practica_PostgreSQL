package ni.edu.uam.registroempleadosfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegistroEmpleadosApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("empleado-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        scene.getStylesheets().add(
                Objects.requireNonNull(getClass().getResource("/estilos/estilos.css")).toExternalForm()
        );
        stage.setTitle("Registro de empleados");
        stage.setScene(scene);
        stage.show();
    }

}
