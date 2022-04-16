package com.informatario.shoppingcart.entity;

import javax.persistence.*;

@Entity
public class LineaDeCarritos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Carrito carrito;
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;
    private Integer cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "LineaDeCarritos{" +
                "id=" + id +
                ", carrito=" + carrito +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }
}
