package com.neorisLab.apiturnos.controller;

import com.neorisLab.apiturnos.entity.JornadaLaboral;
import com.neorisLab.apiturnos.repository.RepositoryEmpleado;
import com.neorisLab.apiturnos.repository.RepositoryTipoJornada;
import com.neorisLab.apiturnos.service.ServiceJornadaLaboral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;

@RestController
@RequestMapping("/api")
public class ControllerJornadaLaboral {
    @Autowired
    private ServiceJornadaLaboral serviceJornadaLaboral;
    @Autowired
    private RepositoryEmpleado repositoryEmpleado;
    @Autowired
    private RepositoryTipoJornada repositoryTipoJornada;

    @PostMapping("/jornada")
    public ResponseEntity guardarJornadaLaboral(@Valid @RequestBody JornadaLaboral jornadaLaboral,
                                                @RequestParam Long idEmpleado, @RequestParam Long idTipo){
            jornadaLaboral.setEmpleado(repositoryEmpleado.findById((idEmpleado)).get());
            jornadaLaboral.setTipoJornada(repositoryTipoJornada.findById(idTipo).get());
            return new ResponseEntity(serviceJornadaLaboral.cargarJornadaLaboral(jornadaLaboral), HttpStatus.CREATED);
        }

    @PutMapping("/jornada")
    public ResponseEntity modificarHorarioTrabajo(@RequestParam Long idJornada,
                                                  @RequestParam LocalTime horaIngreso,
                                                  @RequestParam LocalTime horaSalida){
        return new ResponseEntity(serviceJornadaLaboral.modificarCantidadHoras(idJornada, horaIngreso, horaSalida), HttpStatus.OK);
    }
}
