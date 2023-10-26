package com.nocountryc14.listacheck.service;
import com.nocountryc14.listacheck.dto.ShopListDto;
import java.util.Collection;
import java.util.List;

public interface IListService {
    ShopListDto createList(ShopListDto shopList);
    ShopListDto getListById(Long listId);

    List<ShopListDto> getAllLists();

    ShopListDto updateList(Long listId, ShopListDto shopListDto);

    ShopListDto deleteList(Long listId);




}
