package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.model.Product;
import com.nocountryc14.listacheck.model.ShopList;
import com.nocountryc14.listacheck.service.IListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

//@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.PUT,
//        RequestMethod.GET, RequestMethod.DELETE})
@RestController
@RequestMapping("/shoplist")
public class ShopListController {

    private final IListService shopListService;

    @Autowired
    public ShopListController(IListService shopListService) {

        this.shopListService = shopListService;
    }

    @GetMapping( " ")
    public ResponseEntity<Collection<ShopList>> getAllShopLists() {
        List<ShopList> shopLists = shopListService.getAllLists();
        if (shopLists == null || shopLists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shopLists, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ShopList> createShopList(@RequestBody ShopList shopList) throws RuntimeException {

        if (shopList.getShopListName() == null) {
            throw new RuntimeException("List must have a name");
        }
        ShopList createdList = shopListService.createList(shopList);
        System.out.println("ShopList created: " + createdList);
        return new ResponseEntity<>(createdList, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ShopList> showList(@PathVariable Long id) {
        ShopList shopList = shopListService.getListById(id);
        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ShopList> edit(@PathVariable Long id, @RequestBody ShopList shopList) {
        ShopList shopListSaved = shopListService.updateList(id, shopList);
        return new ResponseEntity<>(shopListSaved, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ShopList> delete(@PathVariable Long id) {
        if(id == null){
            throw new RuntimeException("List does not exist");
        }
        ShopList shopList = shopListService.deleteList(id);
        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }
    @PostMapping("/{listId}/addProduct")
    public ResponseEntity<ShopList> addProductToShopList(@PathVariable Long listId, @RequestBody Product product) {
        if(listId == null || product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ShopList shopListSaved = shopListService.addProductToList(listId, product);
        return new ResponseEntity<>(shopListSaved, HttpStatus.OK);
    }


}
