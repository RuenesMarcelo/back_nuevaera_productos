package com.nuevaera_producto.back_nuevaera_productos.Repository;


import com.nuevaera_producto.back_nuevaera_productos.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // Con JpaRepository ya tienes métodos como:
    // findAll(), findById(id), save(entity), deleteById(id), etc.
}
