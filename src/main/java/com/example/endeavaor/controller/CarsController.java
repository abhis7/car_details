package com.example.endeavaor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.endeavaor.services.CarsService;
import com.example.endeavaor.entity.CarsDetails;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarsController {

    private final CarsService carsService;

    @Autowired
    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping("/details")
    public ResponseEntity<List<CarsDetails>> getAllCarsDetails() {
        List<CarsDetails> carsDetailsList = carsService.getAllCarsDetails();
        return new ResponseEntity<>(carsDetailsList, HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<CarsDetails> getCarDetailsById(@PathVariable Integer id) {
        Optional<CarsDetails> carsDetails = carsService.getCarDetailsById(id);
        return carsDetails.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/details")
    public ResponseEntity<CarsDetails> saveCarDetails(@RequestBody CarsDetails carsDetails) {
        CarsDetails savedCarDetails = carsService.saveCarDetails(carsDetails);
        return new ResponseEntity<>(savedCarDetails, HttpStatus.CREATED);
    }

    @DeleteMapping("/details/{id}")
    public ResponseEntity<Void> deleteCarDetails(@PathVariable Integer id) {
        carsService.deleteCarDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

