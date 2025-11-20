package com.nuevaera_producto.back_nuevaera_productos.Controller;

import com.nuevaera_producto.back_nuevaera_productos.Model.Product;
import com.nuevaera_producto.back_nuevaera_productos.Repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "https://nuevaera-v9ts.vercel.app/")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {this.productRepository = productRepository;}

    // GET /api/productos → devuelve todos los productos.
    @GetMapping
    public List<Product> getAllProductos() {
        return productRepository.findAll();
    }

    // GET /api/productos/{id_producto}  → devuelve un producto por ID
    @GetMapping("/{id_producto}")
    public ResponseEntity<Product> getProductoById(@PathVariable String id_producto) {
        return productRepository.findById(id_producto)
                .map(product -> ResponseEntity.ok(product))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{idCategoria}")
    public List<Product> getByCategoria(@PathVariable int idCategoria) {
        return productRepository.findByCategoria_idCategoria(idCategoria);
    }


    // POST /api/producto  → crea un nuevo producto
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        // Aquí podrías validar campos (nombre, email) antes de guardar
        Product saved = productRepository.save(product);
        return ResponseEntity.status(201).body(saved);
    }

    // PUT /api/p/{id}  → actualiza un usuario existente
    @PutMapping("/{id_producto}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable String id_producto,
            @RequestBody Product datosProducto) {
        return productRepository.findById(id_producto)
                .map(product -> {
                    product.setNombre(datosProducto.getNombre());
                    product.setCategoria(datosProducto.getCategoria());
                    product.setImagen(datosProducto.getImagen());
                    Product updated = productRepository.save(product);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/productos/{id_producto}  → elimina un usuario
    @DeleteMapping("/{id_producto}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id_producto) {
        return productRepository.findById(id_producto)
                .map(product -> {
                    productRepository.delete(product);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}