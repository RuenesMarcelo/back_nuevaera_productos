package com.nuevaera_producto.back_nuevaera_productos.Repository;


import com.nuevaera_producto.back_nuevaera_productos.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Con JpaRepository ya tienes métodos como:
    // findAll(), findById(id), save(entity), deleteById(id), etc.
}
