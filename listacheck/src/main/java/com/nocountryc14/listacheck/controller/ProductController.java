package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.model.Product;
import com.nocountryc14.listacheck.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService prodService;


    //CREAR
    @PostMapping("/products/create")
    public String createProduct(@RequestBody Product prod) {
        prodService.saveProduct(prod);
        //devuelvo String q se creo correctamente
        return "El producto fue creado correctamente";

    }

    //consulta-read
   @GetMapping("/products/get")
    public List<Product> getProduct() {

        return prodService.getProduct();
    }

    //DELETE/BAJA
    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id_product) {
        prodService.deleteProduct(id_product);
        //devuelvo String q se creo correctamente
        return "El producto fue borrado correctamente";



    }

    //BUSQUEDA por id
    @GetMapping("/product/{id}")
    public void findProduct(Long id_product) {
               prodService.findProduct(id_product);
    }
}
