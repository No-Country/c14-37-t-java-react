package com.nocountryc14.listacheck.service;
import com.nocountryc14.listacheck.dto.ShopList;
import java.util.Collection;

public interface IListService {
    ShopList createList(ShopList shopList);
    ShopList getListById(Long listId);

    Collection<ShopList> getAllLists();

    ShopList updateList(Long listId, ShopList shopList);

    ShopList deleteList(Long listId);




}
