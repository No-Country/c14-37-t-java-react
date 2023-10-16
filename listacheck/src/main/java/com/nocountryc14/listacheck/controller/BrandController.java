package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.model.Brand;
import com.nocountryc14.listacheck.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    // Create
    @PostMapping("/create")
    public String createBrand(@RequestBody List<Brand> brands) {
        brandService.createBrand(brands);
        return "The brands " + brands.toString() + " have been created successfully.";
    }

    // Get
    @GetMapping("/get")
    public String getBrand() {

        List<Brand> brands = brandService.getBrand();

        if (brands.isEmpty()) {
            return "No brand has been added yet.";
        } else {
            return brands.toString();
        }
    }

    // Delete
    @DeleteMapping("/delete/{id_brand}")
    public String deleteBrand(@PathVariable Long id_brand) {

        Brand brand = brandService.findBrandById(id_brand);

        if (brand != null) {
            brandService.deleteBrand(id_brand);
            return "The brand " + brand.toString() + " has been deleted successfully.";
        } else {
            return "There is no brand with this ID to delete.";
        }
    }

    // Find
    @GetMapping("/{id_brand}")
    public String findBrandById(@PathVariable Long id_brand) {

        Brand brand = brandService.findBrandById(id_brand);

        if (brand != null) {
            return brand.toString();
        } else {
            return "There is no brand with this ID.";
        }
    }

    @GetMapping("/findByName")
    public String findBrandByName(@RequestParam String name) {
        Brand brand = brandService.findBrandByName(name);

        if (brand != null) {
            return brand.toString();
        } else {
            return "There is no brand with this name.";
        }
    }

    // Update
    @PutMapping("/update/{id_brand}")
    public String updateBrand (@PathVariable Long id_brand, @RequestBody Brand updatedBrand) {

        Brand brand = brandService.findBrandById(id_brand);

        if (brand != null) {
            brandService.updateBrand(id_brand, updatedBrand);
            return "The brand " + brand.toString() + " has been updated successfully.";
        } else {
            return "There is no brand with this ID to update.";
        }
    }
}