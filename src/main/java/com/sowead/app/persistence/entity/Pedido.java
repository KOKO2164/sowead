package com.sowead.app.persistence.entity;

import java.time.LocalDate;
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
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PedidoID")
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "ClienteID", insertable = false, updatable = false)
    private Cliente cliente;

    @Column(name = "Fecha")
    private LocalDate fecha;

    @Column(name = "Total")
    private Double total;

    @OneToMany(mappedBy = "pedido")
    private List<DetallePedido> detallesPedidos;
}
