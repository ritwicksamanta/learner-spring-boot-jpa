package com.cts.sbjpa.sbjpa12.controller;


import com.cts.sbjpa.sbjpa12.entity.Product;
import com.cts.sbjpa.sbjpa12.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService pService;
    @PostMapping("/api/newProduct")
    public Product saveNewProduct(@RequestBody Product product){

        return pService.saveProduct(product);
    }
    @GetMapping("/api/product/{id}")
    public Product getProductByID(@PathVariable int id){
        log.debug("Get Product with id {} initiated", id);
        return pService.getProductById(id);
    }

    @PutMapping("/api/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product updated = pService.updateProduct(product);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().
                replacePath("/api/product/{id}").buildAndExpand(updated.getId()).toUri()).body(product);
    }

    @DeleteMapping("/api/deleteProduct/{id}")
    public String deleteProductById(@PathVariable int id){
        log.debug("id:{}",id);
        return pService.deleteProductById(id);
    }

    @GetMapping(value = "/api/products")
    public List<Product> all(){
        return pService.getProducts();
    }

}
