package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.ShopListDto;
import org.springframework.stereotype.Component;

@Component
public class ShoplistMapper {
    public static ShopListDto toListDto(com.nocountryc14.listacheck.model.ShopList shopList){
        ShopListDto listDto = new ShopListDto();
        if(shopList.getShopListId() != null){
            listDto.setShopListId(shopList.getShopListId());
        }
        listDto.setShopListName(shopList.getShopListName());
        if(shopList.getShopListUpdateDate() != null){
            listDto.setShopListUpdateDate(shopList.getShopListUpdateDate());
        }
        if(shopList.getShopListUser() != null){

            listDto.setShopListUser(UserMapper.toUserDto(shopList.getShopListUser()));
        }
        //listDto.setProducts(ProductMapper.toProductDto(list.getProducts()));
        return listDto;
    }
    public static com.nocountryc14.listacheck.model.ShopList toList(ShopListDto listDto){
        com.nocountryc14.listacheck.model.ShopList shopList = new com.nocountryc14.listacheck.model.ShopList();
        if(listDto.getShopListId() != null){
            shopList.setShopListId(listDto.getShopListId());
        }
        if(listDto.getShopListUpdateDate() != null){
            shopList.setShopListUpdateDate(listDto.getShopListUpdateDate());
        }
        shopList.setShopListUpdateDate(listDto.getShopListUpdateDate());
        if(listDto.getShopListUser() != null){
            shopList.setShopListUser(UserMapper.toUser(listDto.getShopListUser()));
        }
        //list.setProducts(ProductMapper.toProduct(listDto.getProducts()));
        return shopList;
    }

}
