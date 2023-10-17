package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.model.Product;
import com.nocountryc14.listacheck.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository prodRepository;


    //CREATE
    @Override
    public void saveProduct(Product prod) {
        prodRepository.save(prod);

    }

    //consulta-read
    @Override
    public List<Product> getProduct() {
        List<Product> listaProductos = prodRepository.findAll();
        return listaProductos;
    }

    //DELETE/BAJA
    @Override
    public void deleteProduct(Long id_product) {
        prodRepository.deleteById(id_product);

    }

    //BUSQUEDA
    @Override
    public Product findProduct(Long id_product) {
        //si no encuentro el producto devuelvo null;
        Product prod = prodRepository.findById(id_product).orElse(null);
        return prod;
    }



}
