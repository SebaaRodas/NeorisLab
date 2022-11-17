package com.neorisLab.apiturnos.repository;

import com.neorisLab.apiturnos.entity.Empleado;
import com.neorisLab.apiturnos.entity.TipoJornada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryTipoJornada extends JpaRepository<TipoJornada, Long> {
    @Query(value = "SELECT t FROM TipoJornada t")
    List<TipoJornada> obtenerTiposJornadas();
}
