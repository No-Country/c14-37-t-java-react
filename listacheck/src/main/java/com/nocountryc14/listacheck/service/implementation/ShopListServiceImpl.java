package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.model.Product;
import com.nocountryc14.listacheck.model.ShopList;
import com.nocountryc14.listacheck.repository.ListRepository;
import com.nocountryc14.listacheck.service.IListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShopListServiceImpl implements IListService {


    private final ListRepository listRepository;
    private final ProductServiceImpl productService;
    @Autowired
    public ShopListServiceImpl(ListRepository listRepository, ProductServiceImpl productService) {
        this.listRepository = listRepository;
        this.productService = productService;

    }

    @Override
    public ShopList createList(ShopList shopList) {

        ShopList shopListCreated = listRepository.save(shopList);
        ArrayList<Product> products = new ArrayList<>();
        for (Product product: shopListCreated.getProducts()
             ) {
            products.add(productService.findProductById(product.getId_product()));
        }
        shopListCreated.setProducts(products);
        return shopListCreated;
    }

    @Override
    public ShopList getListById(Long listId) {
        ShopList shopList = listRepository.findById(listId).orElse(null);
        return shopList;
    }

    @Override
    public List<ShopList> getAllLists() {
        List<ShopList> shopLists = listRepository.findAll();


        return shopLists;
    }

    @Override
    public ShopList updateList(Long listId, ShopList shopList) {
        ShopList shopListSaved = listRepository.findById(listId).orElse(null);

        return shopListSaved;
    }

    @Override
    public ShopList deleteList(Long listId) {
        ShopList shopListSaved = listRepository.findById(listId).orElse(null);
        listRepository.deleteById(listId);
        return shopListSaved;
    }

    @Override
    public ShopList addProductToList(Long listId, Product product) {
        Product productSaved = productService.createProduct(product);

        ShopList shopList = listRepository.findById(listId).orElse(null);
        List<Product> products = shopList.getProducts();
        products.add(productSaved);
        shopList.setProducts(products);
        ShopList shopListSaved = listRepository.save(shopList);
        return shopListSaved;
        /*
        ShopList shopListCreated = listRepository.save(shopList);
        ArrayList<Product> products = new ArrayList<>();
        for (Product product: shopListCreated.getProducts()
             ) {
            products.add(productService.findProductById(product.getId_product()));
        }
        shopListCreated.setProducts(products);
        return shopListCreated;
         */

    }
}
