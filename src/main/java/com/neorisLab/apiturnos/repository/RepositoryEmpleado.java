package com.neorisLab.apiturnos.repository;

import com.neorisLab.apiturnos.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryEmpleado extends JpaRepository<Empleado, Long> {
    @Query(value = "SELECT e FROM Empleado e")
    List<Empleado> obtenerEmpleado();
}
