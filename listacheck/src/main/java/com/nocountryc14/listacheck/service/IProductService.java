package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.dto.ProductDto;
import com.nocountryc14.listacheck.model.Product;

import java.util.List;

public interface IProductService {

    //metodo para crear producto
    ProductDto createProduct(ProductDto productDto);


    //metodo para traer productos - lectura
    List<ProductDto> getProducts();


    //metodo para borrar producto
    void deleteProduct(Long id_product);


    //metodo para BUSCAR producto x id
    ProductDto findProductById(Long id_product);


    //metodo para editar producto
    ProductDto updateProduct(Long id_product, ProductDto updatedProductDto);


}
