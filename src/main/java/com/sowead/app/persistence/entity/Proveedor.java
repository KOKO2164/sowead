package com.sowead.app.persistence.entity;

import java.util.List;

import jakarta.persistence.Column;
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
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProveedorID")
    private Integer idProveedor;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Contacto")
    private String contacto;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Correo")
    private String correo;

    @Column(name = "Direccion")
    private String direccion;

    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;
}
