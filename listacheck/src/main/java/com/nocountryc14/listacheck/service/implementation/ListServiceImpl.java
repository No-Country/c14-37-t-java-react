package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.dto.ShopList;
import com.nocountryc14.listacheck.mapper.ListMapper;
import com.nocountryc14.listacheck.repository.ListRepository;
import com.nocountryc14.listacheck.service.IListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ListServiceImpl implements IListService {


    private final ListRepository listRepository;

    @Autowired
    public ListServiceImpl(ListRepository listRepository) {
        this.listRepository = listRepository;

    }

    @Override
    public ShopList createList(ShopList listDto) {
        Long listId = listDto.getListId();

        if(listId != null) {
            throw new RuntimeException("List already exists");
        }
        com.nocountryc14.listacheck.model.ShopList shopList = ListMapper.toList(listDto);

        com.nocountryc14.listacheck.model.ShopList shopListCreated = listRepository.save(shopList);

        return ListMapper.toListDto(shopListCreated);
    }

    @Override
    public ShopList getListById(Long listId) {
        return null;
    }

    @Override
    public Collection<ShopList> getAllLists() {
        return null;
    }

    @Override
    public ShopList updateList(Long listId, ShopList shopList) {
        return null;
    }

    @Override
    public ShopList deleteList(Long listId) {
        return null;
    }
}
