package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.dto.BrandDto;
import com.nocountryc14.listacheck.mapper.BrandMapper;
import com.nocountryc14.listacheck.model.Brand;
import com.nocountryc14.listacheck.repository.IBrandRepository;
import com.nocountryc14.listacheck.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements IBrandService {


    private IBrandRepository brandRepository;




    @Autowired
    public BrandServiceImpl(IBrandRepository brandRepository) {
        this.brandRepository = brandRepository;

    }


    // This method is used to create a brand.
    @Override
    public BrandDto createBrand(BrandDto brandsDto) {
        Brand brand = BrandMapper.toBrand(brandsDto);
        Brand savedBrand = brandRepository.save(brand);
        return BrandMapper.toDto(savedBrand);
    }

    // This method is used to get a list with all the brands.
    @Override
    public List<BrandDto> getBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(BrandMapper::toDto).collect(Collectors.toList());
    }

    // This method is used to delete a brand by ID.
    @Override
    public void deleteBrand(Long id_brand) {
        brandRepository.deleteById(id_brand);
    }

    // This method is used to find a brand by ID.
    @Override
    public BrandDto findBrandById(Long id_brand) {
        Brand brand = brandRepository.findById(id_brand).orElse(null);
        return (brand != null) ? BrandMapper.toDto(brand) : null;
    }

    // This method is used to find a brand by name.
    @Override
    public BrandDto findBrandByName(String brandName) {
        Brand brand = brandRepository.findByBrandName(brandName);
        return (brand != null) ? BrandMapper.toDto(brand) : null;
    }

    // This method is used to update a brand by ID.
    @Override
    public BrandDto updateBrand(Long id_brand, BrandDto updatedBrandDto) {
        Brand existingBrand = brandRepository.findById(id_brand).orElse(null);

        if (existingBrand != null) {
            existingBrand.setBrandName(updatedBrandDto.getBrandName());
            Brand savedBrand = brandRepository.save(existingBrand);
            return BrandMapper.toDto(savedBrand);
        } else {
            return null;
        }
    }
}