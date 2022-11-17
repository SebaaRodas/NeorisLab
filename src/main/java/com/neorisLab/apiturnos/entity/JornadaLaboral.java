package com.neorisLab.apiturnos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "Jornada_Laboral")
public class JornadaLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJornada;
    @NotNull(message = "Debes ingresar la fecha")
    @Column(nullable = false)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fecha;
    @NotNull(message = "Debes ingresar la hora de entrada")
    @Column(nullable = false)
    //@JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalTime horaEntrada;
    @NotNull(message = "Debes ingresar la hora de salida")
    @Column(nullable = false)
    //@JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalTime horaSalida;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTipo")
    private TipoJornada tipoJornada;


    public Long getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Long idJornada) {
        this.idJornada = idJornada;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoJornada getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(TipoJornada tipoJornada) {
        this.tipoJornada = tipoJornada;
    }
}
