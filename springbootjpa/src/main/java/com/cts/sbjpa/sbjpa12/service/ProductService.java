package com.cts.sbjpa.sbjpa12.service;


import com.cts.sbjpa.sbjpa12.entity.Product;
import com.cts.sbjpa.sbjpa12.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Product service.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository pRepository;

    /**
     * Save product product.
     *
     * @param product the product
     * @return the product
     */
    public Product saveProduct(Product product){

        return pRepository.save(product);
    }

    /**
     * Get product by id product.
     *
     * @param id the id
     * @return the product
     */
    public Product getProductById(int id){
        return pRepository.findById(id).orElse(null);

    }

    /**
     * Delete product by id string.
     *
     * @param id the id
     * @return the string
     */
    public String deleteProductById(int id){
        pRepository.deleteById(id);
        return "product deleted,{},id";

    }

    /**
     * Get products list.
     *
     * @return the list
     */
    public List<Product> getProducts(){
        return pRepository.findAll();
    }

    /**
     * Update product product.
     *
     * @param product the product
     * @return the product
     */
    public Product updateProduct(Product product){
        Product updateProduct=pRepository.getById(product.getId());
        updateProduct.setName(product.getName());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setQuantity(product.getQuantity());
        return pRepository.save(updateProduct);
    }

    /**
     * Get products by name list.
     *
     * @param name the name
     * @return the list
     */
    public List<Product> getProductsByName(String name){
        return pRepository.findByName(name);
    }


    /**
     * Get products between quantities list.
     *
     * @param start the start
     * @param end   the end
     * @return the list
     */
    public List<Product> getProductsBetweenQuantities(int start, int end){
        return pRepository.findByQuantityBetween(start,end);
    }
}
