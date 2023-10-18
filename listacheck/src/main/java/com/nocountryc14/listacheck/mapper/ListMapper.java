package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.ShopList;
import org.springframework.stereotype.Component;

@Component
public class ListMapper {
    public static ShopList toListDto(com.nocountryc14.listacheck.model.ShopList shopList){
        ShopList listDto = new ShopList();
        if(shopList.getListId() != null){
            listDto.setListId(shopList.getListId());
        }
        listDto.setListName(shopList.getListName());
        if(shopList.getListUser() != null){

            listDto.setListUser(UserMapper.toUserDto(shopList.getListUser()));
        }
        //listDto.setProducts(ProductMapper.toProductDto(list.getProducts()));
        return listDto;
    }
    public static com.nocountryc14.listacheck.model.ShopList toList(ShopList listDto){
        com.nocountryc14.listacheck.model.ShopList shopList = new com.nocountryc14.listacheck.model.ShopList();
        if(listDto.getListId() != null){
            shopList.setListId(listDto.getListId());
        }
        shopList.setListName(listDto.getListName());
        if(listDto.getListUser() != null){
            shopList.setListUser(UserMapper.toUser(listDto.getListUser()));
        }
        //list.setProducts(ProductMapper.toProduct(listDto.getProducts()));
        return shopList;
    }

}
