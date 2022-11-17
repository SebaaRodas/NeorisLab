package com.neorisLab.apiturnos.service.impl;

import com.neorisLab.apiturnos.entity.TipoJornada;
import com.neorisLab.apiturnos.repository.RepositoryTipoJornada;
import com.neorisLab.apiturnos.service.ServiceTipoJornada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTipoJornadaImpl implements ServiceTipoJornada {
    @Autowired
    private RepositoryTipoJornada repositoryTipoJornada;

    @Override
    public TipoJornada guardarTipoJornada(TipoJornada tipoJornada) {
        return repositoryTipoJornada.save(tipoJornada);
    }

}
