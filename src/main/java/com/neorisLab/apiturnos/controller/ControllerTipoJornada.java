package com.neorisLab.apiturnos.controller;

import com.neorisLab.apiturnos.entity.TipoJornada;
import com.neorisLab.apiturnos.service.ServiceTipoJornada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerTipoJornada {
    @Autowired
    private ServiceTipoJornada serviceTipoJornada;
    @PostMapping("/tipo")
    public ResponseEntity guardarTipoJornada(@RequestBody TipoJornada tipoJornada){
     return new ResponseEntity<>(serviceTipoJornada.guardarTipoJornada(tipoJornada), HttpStatus.CREATED);
    }
}
