package ni.edu.uam.registroempleadosfx.model;

import java.time.LocalDate;

public class Empleado {
    private String id;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String correo;
    private String telefono;
    private String cargo;
    private String departamento;
    private double salario;
    private LocalDate fechaContracion;
    private String estado;

    public Empleado() {
    }

    public Empleado(String id, String nombres, String apellidos, String cedula, String correo, String telefono, String cargo, String departamento, double salario, LocalDate fechaContracion, String estado) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
        this.fechaContracion = fechaContracion;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getFechaContracion() {
        return fechaContracion;
    }

    public void setFechaContracion(LocalDate fechaContracion) {
        this.fechaContracion = fechaContracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
