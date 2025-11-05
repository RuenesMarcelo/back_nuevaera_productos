package com.nuevaera_producto.back_nuevaera_productos.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Product {
    @Id
    private String id_producto;

    @Column(nullable = false, length = 100)
    private String nombre;



    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    private Category categoria;


    @Column (nullable = false)
    private String imagen;

    public Product() {}

    public Product(String id_producto, String nombre, Category categoria, String imagen) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.imagen = imagen;
    }


    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Category getCategoria() {
        return categoria;
    }

    public void setCategoria(Category categoria) {
        this.categoria = categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}