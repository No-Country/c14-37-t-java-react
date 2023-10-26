package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.dto.ShopListDto;
import com.nocountryc14.listacheck.mapper.ShoplistMapper;
import com.nocountryc14.listacheck.mapper.UserMapper;
import com.nocountryc14.listacheck.model.ShopList;
import com.nocountryc14.listacheck.repository.ListRepository;
import com.nocountryc14.listacheck.service.IListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopListServiceImpl implements IListService {


    private final ListRepository listRepository;

    @Autowired
    public ShopListServiceImpl(ListRepository listRepository) {
        this.listRepository = listRepository;

    }

    @Override
    public ShopListDto createList(ShopListDto listDto) {
        Long shopListId = listDto.getShopListId();

        if(shopListId != null) {
            throw new RuntimeException("List already exists");
        }
        ShopList shopList = ShoplistMapper.toList(listDto);
        System.out.println("Shop list in service: "+ shopList);
        ShopList shopListCreated = listRepository.save(shopList);

        return ShoplistMapper.toListDto(shopListCreated);
    }

    @Override
    public ShopListDto getListById(Long listId) {
        ShopList shopList = listRepository.findById(listId).orElse(null);
        return shopList != null ? ShoplistMapper.toListDto(shopList) : null;
    }

    @Override
    public List<ShopListDto> getAllLists() {
        List<ShopList> shopLists = listRepository.findAll();

        for (ShopList shopList: shopLists
             ) {

        }
        return shopLists.stream()
                .map(ShoplistMapper::toListDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShopListDto updateList(Long listId, ShopListDto shopListDto) {
        ShopList shopList = listRepository.findById(listId).orElse(null);
        if(shopList.getShopListId() == null){
            shopList = listRepository.save(ShoplistMapper.toList(shopListDto));
        }else{
            if(shopListDto.getShopListName() != null){
                shopList.setShopListName(shopListDto.getShopListName());
            }
            if(shopListDto.getShopListUpdateDate() != null){
                shopList.setShopListUpdateDate(shopListDto.getShopListUpdateDate());
            }
            if(shopListDto.getShopListUser() != null){
                shopList.setShopListUser(UserMapper.toUser(shopListDto.getShopListUser()));
            }
            shopList = listRepository.save(shopList);
        }
        return ShoplistMapper.toListDto(shopList);
    }

    @Override
    public ShopListDto deleteList(Long listId) {
        ShopList shopList = listRepository.findById(listId).orElse(null);
        listRepository.deleteById(listId);
        return shopList != null ? ShoplistMapper.toListDto(shopList) : null;
    }
}
