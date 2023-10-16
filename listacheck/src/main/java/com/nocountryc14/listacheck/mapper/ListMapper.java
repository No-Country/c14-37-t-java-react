package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.ListDto;
import com.nocountryc14.listacheck.model.List;
import org.springframework.stereotype.Component;

@Component
public class ListMapper {
    public static ListDto toListDto(List list){
        ListDto listDto = new ListDto();
        if(list.getListId() != null){
            listDto.setListId(list.getListId());
        }
        listDto.setListName(list.getListName());
        listDto.setListUser(UserMapper.toUserDto(list.getListUser()));
        //listDto.setProducts(ProductMapper.toProductDto(list.getProducts()));
        return listDto;
    }
    public static List toList(ListDto listDto){
        List list = new List();
        if(listDto.getListId() != null){
            list.setListId(listDto.getListId());
        }
        list.setListName(listDto.getListName());
        list.setListUser(UserMapper.toUser(listDto.getListUser()));
        //list.setProducts(ProductMapper.toProduct(listDto.getProducts()));
        return list;
    }

}
