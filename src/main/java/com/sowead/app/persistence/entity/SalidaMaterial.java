package com.sowead.app.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "salida_materiales")
public class SalidaMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salida_material")
    private Integer idSalidaMaterial;

    private String descripcion;

    private Integer cantidad;
    
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = true, updatable = true)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_motivo", insertable = true, updatable = true)
    private Motivo motivo;

    @ManyToOne
    @JoinColumn(name = "id_almacen", insertable = true, updatable = true)
    private Almacen almacen;
    
    private Boolean estado;
}
