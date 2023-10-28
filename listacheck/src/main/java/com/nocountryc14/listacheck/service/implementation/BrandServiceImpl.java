package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.model.Brand;
import com.nocountryc14.listacheck.repository.IBrandRepository;
import com.nocountryc14.listacheck.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Brand createBrand(Brand brand) {

        Brand savedBrand = brandRepository.save(brand);
        return savedBrand;
    }

    // This method is used to get a list with all the brands.
    @Override
    public List<Brand> getBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brands;
    }

    // This method is used to delete a brand by ID.
    @Override
    public void deleteBrand(Long id_brand) {
        brandRepository.deleteById(id_brand);
    }

    // This method is used to find a brand by ID.
    @Override
    public Brand findBrandById(Long id_brand) {
        Optional<Brand> brand = brandRepository.findById(id_brand);
        if (brand.isPresent()) {
            return brand.get();
        }
        return null;

    }

    // This method is used to find a brand by name.
    @Override
    public Brand findBrandByName(String brandName) {
        Brand brand = brandRepository.findByBrandName(brandName);
        return (brand != null) ? brand : null;
    }

    // This method is used to update a brand by ID.
    @Override
    public Brand updateBrand(Long id_brand, Brand updatedBrand) {
        Brand existingBrand = brandRepository.findById(id_brand).orElse(null);

        if (existingBrand != null) {
            existingBrand.setBrandName(updatedBrand.getBrandName());
            Brand savedBrand = brandRepository.save(existingBrand);
            return savedBrand;
        } else {
            return null;
        }
    }
}