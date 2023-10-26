package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.dto.ShopListDto;
import com.nocountryc14.listacheck.service.IListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/shoplist")
public class ShopListController {

    private final IListService shopListService;

    @Autowired
    public ShopListController(IListService shopListService) {

        this.shopListService = shopListService;
    }

    @GetMapping("")
    public ResponseEntity<Collection<ShopListDto>> getAllShopLists() {
        List<ShopListDto> shopLists = shopListService.getAllLists();
        if (shopLists == null || shopLists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shopLists, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ShopListDto> createShopList(@RequestBody ShopListDto shopList) throws RuntimeException {
        System.out.println("ShopList name: " + shopList.getShopListName());
        if (shopList.getShopListName() == null) {
            throw new RuntimeException("List must have a name");
        }
        ShopListDto createdList = shopListService.createList(shopList);
        return new ResponseEntity<>(createdList, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ShopListDto> showList(@PathVariable Long id) {
        ShopListDto shopList = shopListService.getListById(id);
        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ShopListDto> edit(@PathVariable Long id, @RequestBody ShopListDto shopListDto) {
        ShopListDto shopList = shopListService.updateList(id, shopListDto);
        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }

    @DeleteMapping("/list/delete/{id}")
    public ResponseEntity<ShopListDto> delete(@PathVariable Long id) {
        if(id == null){
            throw new RuntimeException("List does not exist");
        }
        ShopListDto shopList = shopListService.deleteList(id);
        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }



}
