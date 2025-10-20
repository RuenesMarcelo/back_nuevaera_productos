package com.nuevaera_producto.back_nuevaera_productos.Repository;

import com.nuevaera_producto.back_nuevaera_productos.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // usar la propiedad Java (idCategoria)
    List<Product> findByCategoria_idCategoria(int idCategoria);
}
