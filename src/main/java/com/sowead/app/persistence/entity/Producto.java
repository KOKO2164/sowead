package com.sowead.app.persistence.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductoID")
    private Integer idProducto;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Precio")
    private Double precio;

    @Column(name = "Stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "CategoriaID", insertable = false, updatable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "ProveedorID", insertable = false, updatable = false)
    private Proveedor proveedor;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallesPedidos;

    @OneToMany(mappedBy = "producto")
    private List<Inventario> inventarios;
}
