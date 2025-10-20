package com.nuevaera_producto.back_nuevaera_productos.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private int idCategoria;

    @Column(nullable = false, length = 50)
    private String nombre;

    public Category(){}

    public Category(int idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    // setter CORRECTO (antes tenías setId_categoria)
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
