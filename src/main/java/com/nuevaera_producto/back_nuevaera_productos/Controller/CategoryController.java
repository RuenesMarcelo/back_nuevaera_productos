package com.nuevaera_producto.back_nuevaera_productos.Controller;

import com.nuevaera_producto.back_nuevaera_productos.Model.Category;
import com.nuevaera_producto.back_nuevaera_productos.Repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {this.categoryRepository = categoryRepository;}

    // GET /api/rol  → devuelve todos los roles
    @GetMapping
    public List<Category> getAllCategories(){return categoryRepository.findAll();}

    // GET /api/rol/{id_rol}  → devuelve un rol por ID
    @GetMapping("/{id_categoria}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id_categoria){
        return categoryRepository.findById(id_categoria)
                .map(categoria -> ResponseEntity.ok(categoria))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/rol  → crea una nueva categoria
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category saved = categoryRepository.save(category);
        return ResponseEntity.status(201).body(saved);
    }

    // PUT /api/category/{id}  → actualiza una categoria existente
    @PutMapping("/{id_categoria}")
    public ResponseEntity<Category> updateCategory(
        @PathVariable int id_category,
        @RequestBody Category datosCategory){
        return categoryRepository.findById(id_category)
                .map(category -> {
                    category.setNombre(datosCategory.getNombre());
                    Category updated = categoryRepository.save(category);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/rol/{id_category}  → elimina un rol
    @DeleteMapping("/{id_categoria}")
    public ResponseEntity<Void> deleteRol(@PathVariable int id_category) {
        return categoryRepository.findById(id_category)
                .map(category -> {
                    categoryRepository.delete(category);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

//


}