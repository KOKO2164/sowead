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
@Table(name = "almacenes")
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlmacen;

    private String codigo;

    private String nombre;

    private String descripcion;

    private Boolean estado;

    @OneToMany(mappedBy = "almacen")
    private List<EntradaMaterial> entradaMateriales;

    @OneToMany(mappedBy = "almacen")
    private List<SalidaMaterial> salidaMateriales;
}
