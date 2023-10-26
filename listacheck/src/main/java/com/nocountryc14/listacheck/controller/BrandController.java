package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.dto.BrandDto;
import com.nocountryc14.listacheck.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    // Create
    @PostMapping("/create")
    public ResponseEntity<BrandDto> createBrand(@RequestBody BrandDto brandDto) throws RuntimeException{
        if (brandDto.getBrandName() == null) {
            throw new RuntimeException("Brand must have a name");
        }
        brandService.createBrand(brandDto);
        return new ResponseEntity<>(brandDto, HttpStatus.CREATED);
    }

    // Get
    @GetMapping("/get")
    public ResponseEntity<List<BrandDto>> getBrands() {
        List<BrandDto> brandsDto = brandService.getBrands();
        if (brandsDto.isEmpty()) {
            return new ResponseEntity<>(brandsDto, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // Delete
    @DeleteMapping("/delete/{id_brand}")
    public ResponseEntity<BrandDto> deleteBrand(@PathVariable Long id_brand) {
        BrandDto brandDto = brandService.findBrandById(id_brand);
        if (brandDto != null) {
            brandService.deleteBrand(id_brand);
            return new ResponseEntity<>(brandDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Find by ID
    @GetMapping("/{id_brand}")
    public ResponseEntity<BrandDto> findBrandById(@PathVariable Long id_brand) {
        BrandDto brandDto = brandService.findBrandById(id_brand);
        if (brandDto != null) {
            return new ResponseEntity<>(brandDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Find by name
    @GetMapping("/findByName")
    public ResponseEntity<BrandDto> findBrandByName(@RequestParam String brandName) {
        BrandDto brandDto = brandService.findBrandByName(brandName);
        if (brandDto != null) {
            return new ResponseEntity<>(brandDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/update/{id_brand}")
    public ResponseEntity<BrandDto> updateBrand (@PathVariable Long id_brand, @RequestBody BrandDto updatedBrandDto) {
        BrandDto brandDto = brandService.updateBrand(id_brand, updatedBrandDto);
        if (brandDto != null) {
            return new ResponseEntity<>(brandDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}