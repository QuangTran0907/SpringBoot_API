package com.SpringBootMaven.Quang.controllers;

import com.SpringBootMaven.Quang.models.Product;
import com.SpringBootMaven.Quang.models.ResponseObject;
import com.SpringBootMaven.Quang.repositories.ProductRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    @Autowired
    private ProductRepository repository;
    @GetMapping("")
    List<Product> getAllProducts()
    {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id)
    {
        Optional<Product> foundProduct = repository.findById(id);
        return  (foundProduct.isPresent())?
             ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok","Query product successfully", foundProduct)
            ):
             ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false","Can not find the product with id:  "+id,null)
            );
    }
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct)
    {

        List<Product> foundProducts = repository.findByName(newProduct.getName().trim());
        return  (foundProducts.size()>0)?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("false","This product's name was taken",null)
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Insert product successfully", repository.save(newProduct))

                );
    }
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct,@PathVariable Long id)
    {
        List<Product> foundProducts = repository.findByName(newProduct.getName().trim());
        if (foundProducts.size()>0){
           return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("false","This product's name was taken",null)
            );
        }
        Product updatedProduct = repository.findById(id).map(product -> {
            product.setName(newProduct.getName());
            return  repository.save(product);
        }).orElseGet(()->{
            newProduct.setId(id);
            return repository.save(newProduct);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Update product successfully",null)

        );
    }
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id)
    {
        boolean exists = repository.existsById(id);
        if (!exists){
        return  ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("failed","There are no products with id "+id,null)
            );
        }
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Delete product successfully", null)
                );
    }
}
