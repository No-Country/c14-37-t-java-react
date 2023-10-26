package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.dto.ProductDto;

import com.nocountryc14.listacheck.mapper.ProductMapper;

import com.nocountryc14.listacheck.model.Product;
import com.nocountryc14.listacheck.repository.IProductRepository;
import com.nocountryc14.listacheck.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository prodRepository;




    // This method is used to create a product.
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.toProduct(productDto);
        Product saveProduct = prodRepository.save(product);
        return ProductMapper.toProductDto(saveProduct);
    }

    // This method is used to get a list with all the products.
    @Override
    public List<ProductDto> getProducts() {
        List<Product> products = prodRepository.findAll();

        return products.stream().map(ProductMapper::toProductDto).collect(Collectors.toList());
    }

    // This method is used to delete a product by ID.
    @Override
    public void deleteProduct(Long id_product) {
        prodRepository.deleteById(id_product);

    }

    // This method is used to find a product by ID.
    @Override
    public ProductDto findProductById(Long id_product) {
        Product product = prodRepository.findById(id_product).orElse(null);
        return (product != null) ? ProductMapper.toProductDto(product) : null;
    }

    // This method is used to update a product by ID.
    @Override
    public ProductDto updateProduct(Long id_product, ProductDto updatedProductDto) {
        Product existingProduct = prodRepository.findById(id_product).orElse(null);

        if (existingProduct != null) {
            existingProduct.setName_product(updatedProductDto.getName_product());
            Product savedProduct = prodRepository.save(existingProduct);
            return ProductMapper.toProductDto(savedProduct);
        }else {
            return null;
        }

    }
}
