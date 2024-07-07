package com.sowead.app.persistence.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "motivos")
public class Motivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMotivo;

    private String nombre;

    private String categoria;

    private Boolean estado;

    @OneToMany(mappedBy = "motivo")
    private List<EntradaMaterial> entradaMateriales;

    @OneToMany(mappedBy = "motivo")
    private List<SalidaMaterial> salidaMateriales;
}
