package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.dto.BrandDto;
import com.nocountryc14.listacheck.mapper.BrandMapper;
import com.nocountryc14.listacheck.model.Brand;
import com.nocountryc14.listacheck.repository.IBrandRepository;
import com.nocountryc14.listacheck.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandRepository brandRepository;

    // This method is used to create a brand or many as an array.
    // If you want to create just ONE brand, you need to add it inside an array anyway, with one object.
    @Override
    public Brand createBrand(BrandDto brandsDto) {
        Brand brand  = BrandMapper.toBrand(brandsDto);
        Brand brandSaved = brandRepository.save(brand);
        return brandSaved;
    }

    // This method is used to get a list with all the brands.
    @Override
    public List<Brand> getBrand() {
        return brandRepository.findAll();
    }

    // This method is used to delete a brand by ID.
    @Override
    public void deleteBrand(Long id_brand) {
        brandRepository.deleteById(id_brand);
    }

    // This method is used to find a brand by ID.
    @Override
    public Brand findBrandById(Long id_brand) {
        return brandRepository.findById(id_brand).orElse(null);
    }

    @Override
    public Brand findBrandByName(String name) {
        return brandRepository.findByBrandName(name);
    }

    // This method is used to update a brand by ID.
    @Override
    public Brand updateBrand(Long id_brand, Brand updatedBrand) {
        Brand existingBrand = brandRepository.findById(id_brand).orElse(null);

        // Update the existing brand with the new brand's values.
        existingBrand.setBrandName(updatedBrand.getBrandName());

        // Save the updated existing brand on the database.
        return brandRepository.save(existingBrand);
    }
}