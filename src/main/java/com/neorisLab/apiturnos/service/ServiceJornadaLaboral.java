package com.neorisLab.apiturnos.service;

import com.neorisLab.apiturnos.entity.JornadaLaboral;

import java.time.LocalTime;


public interface ServiceJornadaLaboral {
    JornadaLaboral cargarJornadaLaboral(JornadaLaboral jornadaLaboral);

    JornadaLaboral modificarCantidadHoras(Long idJornada, LocalTime horaIngreso,
                                            LocalTime horaSalida);
}
