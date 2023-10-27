package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.dto.ProductDto;
import com.nocountryc14.listacheck.dto.ShopListDto;
import com.nocountryc14.listacheck.mapper.ProductMapper;
import com.nocountryc14.listacheck.mapper.ShoplistMapper;
import com.nocountryc14.listacheck.mapper.UserMapper;
import com.nocountryc14.listacheck.model.Product;
import com.nocountryc14.listacheck.model.ShopList;
import com.nocountryc14.listacheck.repository.ListRepository;
import com.nocountryc14.listacheck.service.IListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public ShopListDto createList(ShopListDto listDto) {
        Long shopListId = listDto.getShopListId();

        if(shopListId != null) {
            throw new RuntimeException("List already exists");
        }
        // Llamar al product Service y obtener la lista de productos
        //findProductById}
        ArrayList<Product> products = new ArrayList<>();
        for (ProductDto productDto : listDto.getProducts()
                ) {
            ProductDto productDto1 = productService.findProductById(productDto.getId_product());
            System.out.println("productDto1 in shoplistserviceimpl: "+productDto1);
            products.add(ProductMapper.toProduct(productDto1));
        }
        //

        ShopList shopList = ShoplistMapper.toShopList(listDto);
        // inyectar los productos a la lista
        shopList.setProducts(products);
        System.out.println("Shop list in service RE TUNEADA: "+ shopList);
        ShopList shopListCreated = listRepository.save(shopList);

        return ShoplistMapper.toShopListDto(shopListCreated);
    }

    @Override
    public ShopListDto getListById(Long listId) {
        ShopList shopList = listRepository.findById(listId).orElse(null);
        return shopList != null ? ShoplistMapper.toShopListDto(shopList) : null;
    }

    @Override
    public List<ShopListDto> getAllLists() {
        List<ShopList> shopLists = listRepository.findAll();

        for (ShopList shopList: shopLists
             ) {

        }
        return shopLists.stream()
                .map(ShoplistMapper::toShopListDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShopListDto updateList(Long listId, ShopListDto shopListDto) {
        ShopList shopList = listRepository.findById(listId).orElse(null);
        if(shopList.getShopListId() == null){
            shopList = listRepository.save(ShoplistMapper.toShopList(shopListDto));
        }else{
            if(shopListDto.getShopListName() != null){
                shopList.setShopListName(shopListDto.getShopListName());
            }
/*
            if(shopListDto.getShopListUser() != null){
                shopList.setShopListUser(UserMapper.toUser(shopListDto.getShopListUser()));
            }

 */
            shopList = listRepository.save(shopList);
        }
        return ShoplistMapper.toShopListDto(shopList);
    }

    @Override
    public ShopListDto deleteList(Long listId) {
        ShopList shopList = listRepository.findById(listId).orElse(null);
        listRepository.deleteById(listId);
        return shopList != null ? ShoplistMapper.toShopListDto(shopList) : null;
    }
}
