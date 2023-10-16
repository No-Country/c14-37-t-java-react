package com.nocountryc14.listacheck.mapper;

import org.mapstruct.Mapper;

import com.nocountryc14.listacheck.dto.ListDto;
import com.nocountryc14.listacheck.model.List;
@Mapper
public interface ListMapper {

    ListDto toDto(List list);

    List fromDto(ListDto listDto);
}
