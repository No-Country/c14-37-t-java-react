package com.nocountryc14.listacheck.controller;


import com.nocountryc14.listacheck.dto.ProductDto;

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
    public String createProduct(@RequestBody ProductDto prodDto) {
        prodService.createProduct(prodDto);

        return "The product has been created successfully.";

    }

    //get
    @GetMapping("/get")
    public String getProduct() {

        List<ProductDto> productDto = prodService.getProducts();

        if (productDto.isEmpty()) {
            return "No product has been added yet.";
        } else {
            return productDto.toString();
        }
    }

    //DELETE/BAJA
    @DeleteMapping("/delete/{id_product}")
    public String deleteProduct(@PathVariable Long id_product) {
        ProductDto productDto = prodService.findProductById(id_product);

        if (productDto != null) {
            prodService.deleteProduct(id_product);
            return "The product has been deleted successfully";
        } else {
            return "There is no product with this ID to delete.";
        }


    }

    // Find by ID
    @GetMapping("/{id_product}")
    public String findProduct(@PathVariable Long id_product) {
        ProductDto productDto = prodService.findProductById(id_product);

        if (productDto != null) {
            return productDto.toString();

        } else {
            return "There is no product with this ID.";
        }
    }

    // Update
    @PutMapping("/update/{id_product}")
    public String updateProduct(@PathVariable Long id_product, @RequestBody ProductDto updatedProductDto) {

        ProductDto productDto = prodService.findProductById(id_product);

        if (productDto != null) {
            prodService.updateProduct(id_product, updatedProductDto);
            return "The product has been updated successfully.";
        } else {
            return "There is no product with this ID to update.";
        }
    }


}
