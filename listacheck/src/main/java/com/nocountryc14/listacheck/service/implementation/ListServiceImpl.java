package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.dto.ShopListDto;
import com.nocountryc14.listacheck.mapper.ShoplistMapper;
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
    public ShopListDto createList(ShopListDto listDto) {
        Long shopListId = listDto.getShopListId();

        if(shopListId != null) {
            throw new RuntimeException("List already exists");
        }
        com.nocountryc14.listacheck.model.ShopList shopList = ShoplistMapper.toList(listDto);

        com.nocountryc14.listacheck.model.ShopList shopListCreated = listRepository.save(shopList);

        return ShoplistMapper.toListDto(shopListCreated);
    }

    @Override
    public ShopListDto getListById(Long listId) {
        return null;
    }

    @Override
    public Collection<ShopListDto> getAllLists() {
        return null;
    }

    @Override
    public ShopListDto updateList(Long listId, ShopListDto shopList) {
        return null;
    }

    @Override
    public ShopListDto deleteList(Long listId) {
        return null;
    }
}
