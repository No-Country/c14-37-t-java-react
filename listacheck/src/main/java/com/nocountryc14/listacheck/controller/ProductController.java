package com.nocountryc14.listacheck.controller;


import com.nocountryc14.listacheck.model.Product;

import com.nocountryc14.listacheck.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService prodService;


    //create
    @PostMapping("/create")
    public String createProduct(@RequestBody Product product) {
        prodService.createProduct(product);

        return "The product has been created successfully.";

    }

    //get
    @GetMapping("/get")
    public String getProduct() {

        List<Product> product = prodService.getProducts();

        if (product.isEmpty()) {
            return "No product has been added yet.";
        } else {
            return product.toString();
        }
    }

    //DELETE/BAJA
    @DeleteMapping("/delete/{id_product}")
    public String deleteProduct(@PathVariable Long id_product) {
        Product product = prodService.findProductById(id_product);

        if (product != null) {
            prodService.deleteProduct(id_product);
            return "The product has been deleted successfully";
        } else {
            return "There is no product with this ID to delete.";
        }


    }

    // Find by ID
    @GetMapping("/{id_product}")
    public String findProduct(@PathVariable Long id_product) {
        Product product = prodService.findProductById(id_product);

        if (product != null) {
            return product.toString();

        } else {
            return "There is no product with this ID.";
        }
    }

    // Update
    @PutMapping("/update/{id_product}")
    public String updateProduct(@PathVariable Long id_product, @RequestBody Product updatedProduct) {

        Product product = prodService.findProductById(id_product);

        if (product != null) {
            prodService.updateProduct(id_product, updatedProduct);
            return "The product has been updated successfully.";
        } else {
            return "There is no product with this ID to update.";
        }
    }


}
