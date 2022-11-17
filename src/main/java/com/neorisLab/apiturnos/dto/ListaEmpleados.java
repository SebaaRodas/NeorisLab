package com.neorisLab.apiturnos.dto;

public class ListaEmpleados {
    public Long idEmpleado;
    public Long idTipo;
    public Double cantHoras;

    public ListaEmpleados(Long idEmpleado, Long idTipo, Double cantHoras) {
        this.idEmpleado = idEmpleado;
        this.idTipo = idTipo;
        this.cantHoras = cantHoras;
    }
}
