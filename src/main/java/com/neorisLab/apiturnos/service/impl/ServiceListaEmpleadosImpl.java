package com.neorisLab.apiturnos.service.impl;

import com.neorisLab.apiturnos.entity.Empleado;
import com.neorisLab.apiturnos.entity.JornadaLaboral;
import com.neorisLab.apiturnos.dto.ListaEmpleados;
import com.neorisLab.apiturnos.entity.TipoJornada;
import com.neorisLab.apiturnos.repository.RepositoryEmpleado;
import com.neorisLab.apiturnos.repository.RepositoryJornadaLaboral;
import com.neorisLab.apiturnos.repository.RepositoryTipoJornada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.HOURS;

@Service
public class ServiceListaEmpleadosImpl {
    @Autowired
    private RepositoryEmpleado repositoryEmpleado;
    @Autowired
    private RepositoryTipoJornada repositoryTipoJornada;
    @Autowired
    private RepositoryJornadaLaboral repositoryJornadaLaboral;

    public ArrayList obtenerListaEmpleados() {
        //obtiene los atributos de las entidades y los guarda en la lista
        List<Empleado> empleados = repositoryEmpleado.obtenerEmpleado();
        List<TipoJornada> tiposJornadas = repositoryTipoJornada.obtenerTiposJornadas();
        List<JornadaLaboral> jornadas = repositoryJornadaLaboral.obtenerJornadasLaborales();

        //creo una lista que va a ser de salida
        ArrayList listaEmpleados = new ArrayList();

        //para cada empleado recorre los diferentes tipos de jornada
        for (Empleado empleado: empleados) {
            double totalHoras = 0; //es una variable local que va a acumular las horas semanales trabajadas por cada tipo de jornada
            //cada tipo de jornada recorre las diferentes jornadas
            for (TipoJornada tipoJornada: tiposJornadas) {
                for(JornadaLaboral jornada : jornadas) {
                    if(jornada.getEmpleado().getIdEmpleado() == empleado.getIdEmpleado() &&
                            jornada.getTipoJornada().getIdTipo() == tipoJornada.getIdTipo()) {
                        //permite ir acumulando la cantidad de horas trabajadas en cada jornada
                        totalHoras += HOURS.between(jornada.getHoraEntrada(), jornada.getHoraSalida());
                    }
                }
                //voy agregando a la lista de acuerdo a la clase diseñado en Lista Empleados
                listaEmpleados.add(new ListaEmpleados(empleado.getIdEmpleado(), tipoJornada.getIdTipo(), totalHoras));
                totalHoras = 0;
            }
        }
        return listaEmpleados;
    }
}
