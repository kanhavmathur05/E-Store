package com.estorebackend.resources;

import com.estorebackend.entities.Product;
import com.estorebackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductResource {

    @Autowired
    ProductService productService;

    @PostMapping("/admin/add-product")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
        Product newProduct = productService.addNewProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(newProduct);
    }

    @GetMapping("/view-product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        Product product = productService.viewProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping("/admin/update-product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product newProduct = productService.addNewProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(newProduct);
    }

    @GetMapping("/list-all-products")
    public ResponseEntity<List<Product>> listAllProducts(Pageable pageable) {
        List<Product> listOfProducts = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(listOfProducts);
    }

    @DeleteMapping("/admin/delete-product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/search-user/{query}")
    public ResponseEntity<Page<Product>> getSearchProduct(@PathVariable String query, Pageable pageable) {
        Page<Product> searchProductList = productService.getProductsBySearch(query, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(searchProductList);
    }
}
