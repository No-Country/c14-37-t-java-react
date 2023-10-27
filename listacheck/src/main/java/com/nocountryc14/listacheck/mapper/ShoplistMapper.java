package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.ProductDto;
import com.nocountryc14.listacheck.dto.ShopListDto;
import com.nocountryc14.listacheck.model.Product;
import com.nocountryc14.listacheck.model.ShopList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoplistMapper {
    public static ShopListDto toShopListDto(ShopList shopList) {
        ShopListDto shopListDto = new ShopListDto();
        if (shopList.getShopListId() != null) {
            shopListDto.setShopListId(shopList.getShopListId());
        }
        shopListDto.setShopListName(shopList.getShopListName());
        //shopListDto.setShopListUser(UserMapper.toUserDto(shopList.getShopListUser()));

        /*
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : shopList.getProducts()) {
            productDtos.add(ProductMapper.toProductDto(product));
        }
        shopListDto.setProducts(productDtos);
*/
        return shopListDto;
    }

    public static ShopList toShopList(ShopListDto shopListDto) {
        ShopList shopList = new ShopList();
        if (shopListDto.getShopListId() != null) {
            shopList.setShopListId(shopListDto.getShopListId());
        }
        shopList.setShopListName(shopListDto.getShopListName());
        /*
        if (shopListDto.getShopListUser() != null){

            shopList.setShopListUser(UserMapper.toUser(shopListDto.getShopListUser()));
        }
        */

/*
        List<Product> products = new ArrayList<>();
        for (ProductDto productDto : shopListDto.getProducts()) {
            System.out.println("productDto in shoplistmapper: "+productDto);
            products.add(ProductMapper.toProduct(productDto));
        }
        shopList.setProducts(products);
*/
        return shopList;
    }

}
