package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.model.Brand;
import com.nocountryc14.listacheck.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    @Autowired
    private IBrandService brandService;

    // Create
    @PostMapping("/brand/create")
    public String createBrand(@RequestBody List<Brand> brands) {
        brandService.createBrand(brands);
        return "The brands have been created successfully.";
    }

    // Get
    @GetMapping("/brand/get")
    public String getBrand() {

        List<Brand> brands = brandService.getBrand();

        if (brands.isEmpty()) {
            return "No brand has been added yet.";
        } else {
            return brands.toString();
        }
    }

    @DeleteMapping("/brand/delete/{id_brand}")
    public String deleteBrand(@PathVariable Long id_brand) {

        Brand brand = brandService.findBrand(id_brand);

        if (brand != null) {
            brandService.deleteBrand(id_brand);
            return "The brand has been deleted successfully.";
        } else {
            return "There is no brand with this ID to delete.";
        }
    }

    @GetMapping("/brand/{id_brand}")
    public String findBrand(@PathVariable Long id_brand) {

        Brand brand = brandService.findBrand(id_brand);

        if (brand != null) {
            return brand.toString();
        } else {
            return "There is no brand with this ID.";
        }
    }

    @PutMapping("/brand/update/{id_brand}")
    public String updateBrand (@PathVariable Long id_brand, @RequestBody Brand updatedBrand) {

        Brand brand = brandService.findBrand(id_brand);

        if (brand != null) {
            brandService.updateBrand(id_brand, updatedBrand);
            return "The brand has been updated successfully.";
        } else {
            return "There is no brand with this ID to update.";
        }
    }
}