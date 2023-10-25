package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.dto.BrandDto;
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
    public String createBrand(@RequestBody BrandDto brandDto) {
        brandService.createBrand(brandDto);
        return "The brand " + brandDto.toString() + " has been created successfully.";
    }

    // Get
    @GetMapping("/get")
    public String getBrands() {

        List<BrandDto> brandsDto = brandService.getBrands();

        if (brandsDto.isEmpty()) {
            return "No brand has been added yet.";
        } else {
            return brandsDto.toString();
        }
    }

    // Delete
    @DeleteMapping("/delete/{id_brand}")
    public String deleteBrand(@PathVariable Long id_brand) {

        BrandDto brandDto = brandService.findBrandById(id_brand);

        if (brandDto != null) {
            brandService.deleteBrand(id_brand);
            return "The brand " + brandDto.toString() + " has been deleted successfully.";
        } else {
            return "There is no brand with this ID to delete.";
        }
    }

    // Find by ID
    @GetMapping("/{id_brand}")
    public String findBrandById(@PathVariable Long id_brand) {
        BrandDto brandDto = brandService.findBrandById(id_brand);

        if (brandDto != null) {
            return brandDto.toString();
        } else {
            return "There is no brand with this ID.";
        }
    }

    // Find by name
    @GetMapping("/findByName")
    public String findBrandByName(@RequestParam String brandName) {
        BrandDto brandDto = brandService.findBrandByName(brandName);

        if (brandDto != null) {
            return brandDto.toString();
        } else {
            return "There is no brand with this name.";
        }
    }

    // Update
    @PutMapping("/update/{id_brand}")
    public String updateBrand (@PathVariable Long id_brand, @RequestBody BrandDto updatedBrandDto) {

        BrandDto brandDto = brandService.findBrandById(id_brand);

        if (brandDto != null) {
            brandService.updateBrand(id_brand, updatedBrandDto);
            return "The brand " + brandDto.toString() + " has been updated successfully.";
        } else {
            return "There is no brand with this ID to update.";
        }
    }
}