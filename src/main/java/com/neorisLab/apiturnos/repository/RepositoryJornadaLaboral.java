package com.neorisLab.apiturnos.repository;

import com.neorisLab.apiturnos.entity.Empleado;
import com.neorisLab.apiturnos.entity.JornadaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryJornadaLaboral extends JpaRepository<JornadaLaboral, Long> {
    @Query(value = "SELECT j FROM JornadaLaboral j")
    List<JornadaLaboral> obtenerJornadasLaborales();
}
