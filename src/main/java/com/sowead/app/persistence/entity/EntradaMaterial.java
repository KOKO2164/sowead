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
@Table(name = "entrada_materiales")
public class EntradaMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada_material")
    private Integer idEntradaMaterial;

    private String descripcion;

    private Integer cantidad;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idMotivo", insertable = false, updatable = false)
    private Motivo motivo;

    @ManyToOne
    @JoinColumn(name = "idAlmacen", insertable = false, updatable = false)
    private Almacen almacen;

    private Boolean estado;
}
