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
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InventarioID")
    private Integer idInventario;

    @ManyToOne
    @JoinColumn(name = "ProductoID", insertable = false, updatable = false)
    private Producto producto;

    @Column(name = "Cantidad")
    private Integer cantidad;
}
