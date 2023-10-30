package com.nocountryc14.listacheck.service.implementation;


import com.nocountryc14.listacheck.model.Brand;
import com.nocountryc14.listacheck.model.Category;
import com.nocountryc14.listacheck.model.Note;
import com.nocountryc14.listacheck.model.Product;
import com.nocountryc14.listacheck.repository.IProductRepository;
import com.nocountryc14.listacheck.service.IBrandService;
import com.nocountryc14.listacheck.service.ICategoryService;
import com.nocountryc14.listacheck.service.INoteService;
import com.nocountryc14.listacheck.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        if(product.getBrand() != null){
            Brand brandSaved = brandService.createBrand(product.getBrand());
            product.setBrand(brandSaved);
        }
        if(product.getNote() != null ){
            Note noteSaved = noteService.createNote(product.getNote());
            product.setNote(noteSaved);
        }
        if(product.getCategory() != null){
            product.setCategory(categoryService.createCategory(product.getCategory()));
        }

        Product saveProduct = prodRepository.save(product);
        /* Para mi no serian necesarias
        saveProduct.setNote(
                noteService.findNoteById(saveProduct.getNote().getNoteId())
        );
        saveProduct.setBrand(
                brandService.findBrandById(saveProduct.getBrand().getBrandId())
        );
        saveProduct.setCategory(
                categoryService.findCategoryById(saveProduct.getCategory().getCategoryId())
        );

         */
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
        Boolean check = false;
        Product existingProduct = prodRepository.findById(id_product).orElse(null);

        existingProduct.setName_product(updatedProduct.getName_product());
        existingProduct.setQuantity(updatedProduct.getQuantity());

        Brand brand = updatedProduct.getBrand();
        List<Brand> brands = brandService.getBrands();
        for (Brand brand1: brands) {
            if (brand.getBrandName().equalsIgnoreCase(brand1.getBrandName())) {
                existingProduct.setBrand(brand1);
                check = true;
                break;
            }
        }
        if (!check) {
            brandService.createBrand(brand);
            existingProduct.setBrand(brand);
        }
        check = false;

        Category category = updatedProduct.getCategory();
        List<Category> categories = categoryService.getCategories();
        for (Category category1: categories) {
            if (category.getCategoryName().equalsIgnoreCase(category1.getCategoryName())) {
                existingProduct.setCategory(category1);
                check = true;
                break;
            }
        }
        if (!check) {
            categoryService.createCategory(category);
            existingProduct.setCategory(category);
        }
        check = false;

        Note note = updatedProduct.getNote();
        List<Note> notes = noteService.getNotes();

            noteService.createNote(note);
            existingProduct.setNote(note);

        return prodRepository.save(existingProduct);
    }

    @Override
    public Product toggleIsBought(Long productId) {
        Optional<Product> productSaved = prodRepository.findById(productId);
        if(productSaved.isPresent()){
            if(productSaved.get().isBought()){
                productSaved.get().setBought(false);
            }else{
                productSaved.get().setBought(true);
            }

            return prodRepository.save(productSaved.get());
        }
        return null;
    }
}
