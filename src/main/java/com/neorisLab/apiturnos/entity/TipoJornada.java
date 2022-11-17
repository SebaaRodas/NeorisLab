package com.neorisLab.apiturnos.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Tipos_Jornadas")
public class TipoJornada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipo;
    private String tipo;

    @OneToMany(mappedBy = "tipoJornada")
    private List<JornadaLaboral> jornadas;

    public Long getIdTipo() {
        return idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
