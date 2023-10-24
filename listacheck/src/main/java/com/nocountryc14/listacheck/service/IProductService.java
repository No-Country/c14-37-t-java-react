package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.model.Product;

import java.util.List;

public interface IProductService {

    //metodo para crear producto
    public void saveProduct(Product prod);

    //metodo para traer productos - lectura
    public List<Product> getProduct();

    //metodo para borrar producto
    public void deleteProduct(Long id_product);

    //metodo para BUSCAR producto
    public Product findProduct(Long id_product);


    //metodo para editar producto



}
