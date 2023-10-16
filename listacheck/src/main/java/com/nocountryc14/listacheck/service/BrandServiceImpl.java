package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.model.Brand;
import com.nocountryc14.listacheck.repository.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandRepository brandRepository;

    // This method is used to create a brand.
    @Override
    public List<Brand> createBrand(List<Brand> brands) {
        brandRepository.saveAll(brands);
        return brands;
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
    public Brand findBrand(Long id_brand) {
        return brandRepository.findById(id_brand).orElse(null);
    }

    // This method is used to update a brand by ID.
    @Override
    public Brand updateBrand(Long id_brand, Brand updatedBrand) {
        Brand existingBrand = brandRepository.findById(id_brand).orElse(null);

        // Update the existing brand with the new brand's values.
        existingBrand.setName(updatedBrand.getName());

        // Save the updated existing brand on the database.
        return brandRepository.save(existingBrand);
    }
}