package com.neorisLab.apiturnos.controller;

import com.neorisLab.apiturnos.entity.Empleado;
import com.neorisLab.apiturnos.service.ServiceEmpleado;
import com.neorisLab.apiturnos.service.impl.ServiceListaEmpleadosImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControllerEmpleado {
    @Autowired
    private ServiceEmpleado serviceEmpleado;
    @Autowired
    private ServiceListaEmpleadosImpl serviceListaEmpleadosImpl;

    @PostMapping("/empleado")
    public ResponseEntity guardarEmpleado(@RequestBody Empleado empleado){
        return new ResponseEntity(serviceEmpleado.guardarEmpleado(empleado), HttpStatus.CREATED);
    };

    @GetMapping("/empleado/tipo")
    public ResponseEntity obtenerListaEmpleados() {
        return new ResponseEntity(serviceListaEmpleadosImpl.obtenerListaEmpleados(), HttpStatus.OK);
    }
}
