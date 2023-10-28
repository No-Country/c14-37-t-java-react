package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.model.Product;


import java.util.List;

public interface IProductService {

    //metodo para crear producto
    Product createProduct(Product product);


    //metodo para traer productos - lectura
    List<Product> getProducts();


    //metodo para borrar producto
    void deleteProduct(Long id_product);


    //metodo para BUSCAR producto x id
    Product findProductById(Long id_product);


    //metodo para editar producto
    Product updateProduct(Long id_product, Product updatedProduct);


}
