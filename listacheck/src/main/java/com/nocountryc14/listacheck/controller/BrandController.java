package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.model.Brand;
import com.nocountryc14.listacheck.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private IBrandService brandService;
    @Autowired
    public BrandController(IBrandService brandService) {
        this.brandService = brandService;
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) throws RuntimeException{
        if (brand.getBrandName() == null) {
            throw new RuntimeException("Brand must have a name");
        }
        //brand brandSaved = brandService.createBrand(brand);


        return new ResponseEntity<>(brandService.createBrand(brand), HttpStatus.CREATED);
    }

    // Get
    @GetMapping("/get")
    public ResponseEntity<List<Brand>> getBrands() {
        List<Brand> brands = brandService.getBrands();
        if (brands.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(brands ,HttpStatus.OK);
        }
    }


    // Delete
    @DeleteMapping("/delete/{id_brand}")
    public ResponseEntity<Brand> deleteBrand(@PathVariable Long id_brand) {
        Brand brand = brandService.findBrandById(id_brand);
        if (brand != null) {
            brandService.deleteBrand(id_brand);
            return new ResponseEntity<>(brand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Find by ID
    @GetMapping("/{id_brand}")
    public ResponseEntity<Brand> findBrandById(@PathVariable Long id_brand) {
        Brand brand = brandService.findBrandById(id_brand);
        if (brand != null) {
            return new ResponseEntity<>(brand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Find by name
    @GetMapping("/findByName")
    public ResponseEntity<Brand> findBrandByName(@RequestParam String brandName) {
        Brand brand = brandService.findBrandByName(brandName);
        if (brand != null) {
            return new ResponseEntity<>(brand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/update/{id_brand}")
    public ResponseEntity<Brand> updateBrand (@PathVariable Long id_brand, @RequestBody Brand updatedBrand) {
        Brand brand = brandService.updateBrand(id_brand, updatedBrand);
        if (brand != null) {
            return new ResponseEntity<>(brand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}