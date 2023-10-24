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
    public ResponseEntity<Collection<ShopListDto>> getAllLists() {
        List<ShopListDto> shopLists = shopListService.getAllLists();
        if (shopLists == null || shopLists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shopLists, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<ShopListDto> createList(@RequestBody ShopListDto shopList) throws RuntimeException {
        System.out.println("ShopList name: " + shopList.getShopListName());
        if (shopList.getShopListName() == null) {
            throw new RuntimeException("List must have a name");
        }
        ShopListDto createdList = shopListService.createList(shopList);
        return new ResponseEntity<>(createdList, HttpStatus.CREATED);
    }
/*
    @PostMapping("/list")
    public String saveList(List list) {
        listService.saveList(list);
        return "redirect:/list/" + list.getId();
    }

    @GetMapping("/list/{id}")
    public String showList(@PathVariable Long id, Model model) {
        model.addAttribute("list", listService.getListById(id));
        return "listshow";
    }

    @GetMapping("/list/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("list", listService.getListById(id));
        return "listform";
    }

    @GetMapping("/list/delete/{id}")
    public String delete(@PathVariable Long id) {
        listService.deleteList(id);
        return "redirect:/list";
    }


 */
}
