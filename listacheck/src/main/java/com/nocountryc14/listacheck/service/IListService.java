package com.nocountryc14.listacheck.service;
import com.nocountryc14.listacheck.dto.ListDto;
import java.util.Collection;

public interface IListService {
    ListDto createList(ListDto listDto);
    ListDto getListById(Long listId);

    Collection<ListDto> getAllLists();

    ListDto updateList(Long listId,ListDto listDto);

    ListDto deleteList(Long listId);




}
