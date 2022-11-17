package com.neorisLab.apiturnos.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "Empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;
    @NotNull(message = "Debes ingresar tu nombre")
    private String nombre;
    @NotNull(message = "Debes ingresar tu apellido")
    private String apellido;
    @NotNull(message = "Debes ingresar tu dni")
    private Long dni;
    private String email;
    private String telefono;
    @Transient
    private HashMap<Integer, Double> cantHorasSemanales = new HashMap<>();

    @OneToMany(mappedBy = "empleado")
    private List<JornadaLaboral> jornadas;

    public Empleado() {
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public HashMap<Integer, Double> getCantHorasSemanales() {
        return cantHorasSemanales;
    }

    public void setCantHorasSemanales(HashMap<Integer, Double> cantHorasSemanales) {
        this.cantHorasSemanales = cantHorasSemanales;
    }
}
