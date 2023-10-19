package com.nocountryc14.listacheck.service;
import com.nocountryc14.listacheck.dto.ShopListDto;
import java.util.Collection;

public interface IListService {
    ShopListDto createList(ShopListDto shopList);
    ShopListDto getListById(Long listId);

    Collection<ShopListDto> getAllLists();

    ShopListDto updateList(Long listId, ShopListDto shopList);

    ShopListDto deleteList(Long listId);




}
