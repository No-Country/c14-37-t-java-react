package com.nocountryc14.listacheck.mapper;

import org.mapstruct.Mapper;

import com.nocountryc14.listacheck.dto.ListDto;
import com.nocountryc14.listacheck.model.List;

import org.mapstruct.factory.Mappers;

@Mapper
public interface ListMapper {

    ListMapper INSTANCE = Mappers.getMapper(ListMapper.class);

    ListDto toDto(List list);

    List fromDto(ListDto listDto);
}
