package com.neorisLab.apiturnos.service.impl;

import com.neorisLab.apiturnos.entity.Empleado;
import com.neorisLab.apiturnos.repository.RepositoryEmpleado;
import com.neorisLab.apiturnos.service.ServiceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEmpleadoImpl implements ServiceEmpleado {
    @Autowired
    private RepositoryEmpleado repositoryEmpleado;

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return repositoryEmpleado.save(empleado);
    }
}
