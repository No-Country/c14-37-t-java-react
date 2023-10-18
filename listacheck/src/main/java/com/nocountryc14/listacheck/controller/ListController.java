package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.dto.ShopList;
import com.nocountryc14.listacheck.service.IListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@Controller
//@RequestMapping("/list")
public class ListController {

    private final IListService listService;

    @Autowired
    public ListController(IListService listService) {
        this.listService = listService;
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<ShopList>> getAllLists() {
        Collection<ShopList> lists = listService.getAllLists();
        return new ResponseEntity<>(lists, HttpStatus.OK);
    }

    @PostMapping("/list/new")
    public ResponseEntity<ShopList> createList(@RequestBody ShopList shopList) throws RuntimeException {
        System.out.println("List name: " + shopList.getListName());
        if (shopList.getListName() == null) {
            throw new RuntimeException("List must have a name");
        }
        ShopList createdList = listService.createList(shopList);
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
