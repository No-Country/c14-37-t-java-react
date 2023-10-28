package com.nocountryc14.listacheck.service.implementation;


import com.nocountryc14.listacheck.model.Product;
import com.nocountryc14.listacheck.repository.IProductRepository;
import com.nocountryc14.listacheck.service.IBrandService;
import com.nocountryc14.listacheck.service.ICategoryService;
import com.nocountryc14.listacheck.service.INoteService;
import com.nocountryc14.listacheck.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {


    private IProductRepository prodRepository;
    private INoteService noteService;
    private IBrandService brandService;
    private ICategoryService categoryService;
    @Autowired
    public ProductServiceImpl(IProductRepository prodRepository, INoteService noteService, IBrandService brandService, ICategoryService categoryService) {
        this.prodRepository = prodRepository;
        this.noteService = noteService;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }




    // This method is used to create a product.
    @Override
    public Product createProduct(Product product) {

        System.out.println("product in create product service: "+product);
        Product saveProduct = prodRepository.save(product);
        saveProduct.setNote(
                noteService.findNoteById(saveProduct.getNote().getNoteId())
        );
        saveProduct.setBrand(
                brandService.findBrandById(saveProduct.getBrand().getBrandId())
        );
        saveProduct.setCategory(
                categoryService.findCategoryById(saveProduct.getCategory().getCategoryId())
        );
        return saveProduct;
    }

    // This method is used to get a list with all the products.
    @Override
    public List<Product> getProducts() {
        List<Product> products = prodRepository.findAll();

        return products;
    }

    // This method is used to delete a product by ID.
    @Override
    public void deleteProduct(Long id_product) {
        prodRepository.deleteById(id_product);

    }

    // This method is used to find a product by ID.
    @Override
    public Product findProductById(Long id_product) {
        Product product = prodRepository.findById(id_product).orElse(null);
        return product;
    }

    // This method is used to update a product by ID.
    @Override
    public Product updateProduct(Long id_product, Product updatedProduct) {
        Product existingProduct = prodRepository.findById(id_product).orElse(null);

        if (existingProduct != null) {
            existingProduct.setName_product(updatedProduct.getName_product());
            Product savedProduct = prodRepository.save(existingProduct);
            return savedProduct;
        }else {
            return null;
        }

    }
}
