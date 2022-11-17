package com.neorisLab.apiturnos.service.impl;

import com.neorisLab.apiturnos.entity.JornadaLaboral;
import com.neorisLab.apiturnos.repository.RepositoryJornadaLaboral;
import com.neorisLab.apiturnos.service.ServiceJornadaLaboral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;


@Service
public class ServiceJornadaLaboralImpl implements ServiceJornadaLaboral {
    @Autowired
    private RepositoryJornadaLaboral repositoryJornadaLaboral;

    @Override
    public JornadaLaboral cargarJornadaLaboral(JornadaLaboral jornadaLaboral) {
        //comprara si cargo vacaciones o dia libre
        System.out.println(jornadaLaboral.getTipoJornada().getTipo().toUpperCase());
        if((jornadaLaboral.getTipoJornada().getTipo().toUpperCase()=="VACACIONES")||
            jornadaLaboral.getTipoJornada().getTipo().toUpperCase()=="LIBRE"){
            System.out.println("Error no puede cargar jornada estando de vacaciones o con el día libre");
        }

        //validar horario semanal y dia

        return repositoryJornadaLaboral.save(jornadaLaboral);
    }

    @Override
    public JornadaLaboral modificarCantidadHoras(@RequestParam Long idJornada, @RequestParam LocalTime horaIngreso, @RequestParam LocalTime horaSalida) {
        JornadaLaboral actualizarJornada = repositoryJornadaLaboral.findById(idJornada).get();
        actualizarJornada.setHoraEntrada(horaIngreso);
        actualizarJornada.setHoraSalida(horaSalida);
        return repositoryJornadaLaboral.save(actualizarJornada);
    }
}
