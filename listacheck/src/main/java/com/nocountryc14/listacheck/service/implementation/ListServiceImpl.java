package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.dto.ListDto;
import com.nocountryc14.listacheck.mapper.ListMapper;
import com.nocountryc14.listacheck.repository.ListRepository;
import com.nocountryc14.listacheck.service.IListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import com.nocountryc14.listacheck.model.List;
@Service
public class ListServiceImpl implements IListService {

    private final ListMapper listMapper;
    private final ListRepository listRepository;

    @Autowired
    public ListServiceImpl(ListRepository listRepository, ListMapper listMapper) {
        this.listRepository = listRepository;
        this.listMapper = listMapper;
    }

    @Override
    public ListDto createList(ListDto listDto) {
        Long listId = listDto.getListId();
        List existingList = listRepository.findById(listId).orElse(null);
        if(existingList != null) {
            throw new RuntimeException("List already exists");
        }
        List list = listMapper.fromDto(listDto);
        return null;
    }

    @Override
    public ListDto getListById(Long listId) {
        return null;
    }

    @Override
    public Collection<ListDto> getAllLists() {
        return null;
    }

    @Override
    public ListDto updateList(Long listId, ListDto listDto) {
        return null;
    }

    @Override
    public ListDto deleteList(Long listId) {
        return null;
    }
}
