package com.solera.bootcamp.springbootdemo;


import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solera.bootcamp.springbootdemo.Models.Product;
import com.solera.bootcamp.springbootdemo.repository.MiRepositorio;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1")
public class First {
   
    private static MiRepositorio productRepository;

    public First(MiRepositorio repository) {
        productRepository = repository;
    }


    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
           return "Hello " + name + "!";  }


    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }
    
    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return "Product found: " + product.get().getName() + " with ID: " + product.get().getId();
        } else {
            return "Product with ID: " + id + " not found.";
        }
    }   

    @PostMapping("/products")
    public String postProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "Product saved: " + product.getName() + " has been added with ID: " + product.getId() + " saved successfully!";
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable long id) {
        productRepository.deleteById(id);
        return "Product with ID: " + id + " has been deleted successfully!";
    }   




    //@GetMapping("/products")
    //public List<Product> getProducts(@RequestParam(value = "category", required = false) String category) {
    //    Object productService;
    //    if (category != null) {
    //        return productService.getProductsByCategory(category);
    //    }
    //    return productService.getAllProducts();
    //}

}
