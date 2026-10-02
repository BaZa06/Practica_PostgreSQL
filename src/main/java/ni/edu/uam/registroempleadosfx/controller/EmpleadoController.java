package ni.edu.uam.registroempleadosfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ni.edu.uam.registroempleadosfx.database.DatabaseConnection;
import ni.edu.uam.registroempleadosfx.model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoController {

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCargo;

    @FXML
    private ComboBox<String> cmbDepartamento;

    @FXML
    private TextField txtSalario;

    @FXML
    private DatePicker dpFechaContratacion;

    @FXML
    private ComboBox<String> cmbEstado;

    @FXML
    private TableView<Empleado> tblEmpleados;

    @FXML
    private TableColumn<Empleado, String> colId;

    @FXML
    private TableColumn<Empleado, String> colNombres;

    @FXML
    private TableColumn<Empleado, String> colApellidos;

    @FXML
    private TableColumn<Empleado, String> colCedula;

    @FXML
    private TableColumn<Empleado, String> colCorreo;

    @FXML
    private TableColumn<Empleado, String> colTelefono;

    @FXML
    private TableColumn<Empleado, String> colCargo;

    @FXML
    private TableColumn<Empleado, String> colDepartamento;

    @FXML
    private TableColumn<Empleado, String> colSalario;

    @FXML
    private TableColumn<Empleado, String> colFechaContratacion;

    private final ObservableList<Empleado> empleados = FXCollections.observableArrayList();


    @FXML
    private void initialize() {
        configurarComboboxDepartamento();
        configurarComboboxEstado();
        configurarTableView();
        tblEmpleados.setItems(empleados);

    }

    private void configurarComboboxDepartamento(){
        cmbDepartamento.getItems().clear();
        cmbDepartamento.getItems().addAll("Administración", "Recursos Humanos", "Finanzas", "Marketing", "Ventas", "Sistemas", "Producción");
    }


    private void configurarComboboxEstado(){
        cmbEstado.getItems().clear();
        cmbEstado.getItems().addAll("Activo", "Inactivo");

    }

    private void configurarTableView(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colDepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        colSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        colFechaContratacion.setCellValueFactory(new PropertyValueFactory<>("fechaContratacion"));
    }

    @FXML
    private void guardar(){
        if (!validarCampos()) {
            return;
        }
        //Consulta  SQL a ejecutar
        String sql = "INSERT INTO empleado (nombres, apellidos, cedula, correo, telefono, cargo, departamento, fechaContratacion, estado)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1, txtNombres.getText());
            statement.setString(2, txtApellidos.getText());
            statement.setString(3, txtCedula.getText());
            statement.setString(4, txtCorreo.getText());
            statement.setString(5, txtTelefono.getText());
            statement.setString(6, txtCargo.getText());
            statement.setString(7, cmbDepartamento.getValue());
            statement.setDate(8, java.sql.Date.valueOf(dpFechaContratacion.getValue()));
            statement.setString(9, cmbEstado.getValue());

            statement.execute();
        }

        catch(SQLException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void actualizarTabla(){
        empleados.clear();

        String sql = "SELECT * FROM empleado";

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getInt("id"));
                empleado.setNombres(resultSet.getString("nombres"));
                empleado.setApellidos(resultSet.getString("apellidos"));
                empleado.setCedula(resultSet.getString("cedula"));
                empleado.setCorreo(resultSet.getString("correo"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleado.setCargo(resultSet.getString("cargo"));
                empleado.setDepartamento(resultSet.getString("departamento"));
                empleado.setSalario(resultSet.getDouble("salario"));
                empleado.setFechaContracion(resultSet.getDate("fechaContratacion"));
                empleado.setEstado(resultSet.getString("estado"));

                empleados.add(empleado);
            }

            mostrarAlerta(
                    Alert.AlertType.INFORMATION,
                    "Registro guardado exitosamente.",
                    "Libro registrado.",
                    "El libro se ha almacenado exitosamente."
            );
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    private boolean validarCampos(){
        return true;
    }

    @FXML
    public void limpiar(ActionEvent actionEvent) {
        txtNombres.clear();
        txtApellidos.clear();
        txtCedula.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtCargo.clear();
        cmbDepartamento.getSelectionModel().clearSelection();
        dpFechaContratacion.setValue(null);
        cmbEstado.getSelectionModel().clearSelection();
    }


    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String encabezado, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
    }

}
