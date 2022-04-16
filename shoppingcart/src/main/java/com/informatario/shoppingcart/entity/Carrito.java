package com.informatario.shoppingcart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean cerrado;
    @CreationTimestamp
    private LocalDate fechaCreacion;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    private String creadoDesde;
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaDeCarritos> lineasDeCarrito = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isCerrado() {
        return cerrado;
    }

    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }

    public String getCreadoDesde() {
        return creadoDesde;
    }

    public void setCreadoDesde(String creadoDesde) {
        this.creadoDesde = creadoDesde;
    }

    public List<LineaDeCarritos> getLineasDeCarrito() {
        return lineasDeCarrito;
    }

    public void setLineasDeCarrito(List<LineaDeCarritos> lineasDeCarrito) {
        this.lineasDeCarrito = lineasDeCarrito;
    }

    public void agregarLineaCarrito(LineaDeCarritos lineaDeCarrito) {
        lineasDeCarrito.add(lineaDeCarrito);
        lineaDeCarrito.setCarrito(this);
    }

    public void removerLineaCarrito(LineaDeCarritos lineaDeCarrito) {
        lineasDeCarrito.remove(lineaDeCarrito);
        lineaDeCarrito.setCarrito(null);
    }


    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", cerrado=" + cerrado +
                ", fechaCreacion=" + fechaCreacion +
                ", usuario=" + usuario +
                ", creadoDesde='" + creadoDesde + '\'' +
                '}';
    }
}
