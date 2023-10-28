package com.nocountryc14.listacheck.service;
import com.nocountryc14.listacheck.model.Product;
import com.nocountryc14.listacheck.model.ShopList;
import java.util.Collection;
import java.util.List;

public interface IListService {
    ShopList createList(ShopList shopList);
    ShopList getListById(Long listId);

    List<ShopList> getAllLists();

    ShopList updateList(Long listId, ShopList shopList);

    ShopList deleteList(Long listId);


    ShopList addProductToList(Long listId, Product product);
}
