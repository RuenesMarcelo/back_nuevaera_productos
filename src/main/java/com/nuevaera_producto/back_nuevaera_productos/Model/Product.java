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

    @Column(columnDefinition = "TEXT", nullable = true)
    private String descripcion;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String presentacion;


    public Product() {}

    public Product(String id_producto, String nombre, Category categoria, String imagen, String descripcion, String presentacion) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.presentacion = presentacion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

}