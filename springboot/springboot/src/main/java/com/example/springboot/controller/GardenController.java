package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.model.Garden;
import com.example.springboot.service.GardenService;

import java.util.List;

@RestController
@RequestMapping("/api/garden")
public class GardenController {

    @Autowired
    private GardenService gardenService;

    @PostMapping
    public ResponseEntity<Garden> addgarden(@RequestBody Garden garden) {
        Garden newgarden = gardenService.create(garden);
        return new ResponseEntity<>(newgarden, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Garden>> getAllGarden() {
        List<Garden> garden = gardenService.getAllGarden();
        return new ResponseEntity<>(garden, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Garden> getGardenById(@PathVariable("id") int id) {
        Garden garden = gardenService.getGardenById(id).orElse(null);
        if (garden != null) {
            return new ResponseEntity<>(garden, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Garden> updateGarden(@PathVariable("id") int id, @RequestBody Garden gar) {
        if (gardenService.updateGarden(id, gar)) {
            return new ResponseEntity<>(gar, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteGarden(@PathVariable("id") int id) {
        if (gardenService.deleteGarden(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Garden>> getAllGardenSorted(@RequestParam String sortBy) {
        List<Garden> garden = gardenService.getAllGardenSortedBy(sortBy);
        return new ResponseEntity<>(garden, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Garden>> getAllGardenPaginated(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page<Garden> gardenPage = gardenService.getAllGardenPaginated(pageNo, pageSize);
        return new ResponseEntity<>(gardenPage, HttpStatus.OK);
    }
 

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Garden>> getBusesByUserId(@PathVariable int userId) {
        List<Garden> gardens = gardenService.findByUserId(userId);
        return new ResponseEntity<>(gardens, HttpStatus.OK);
    }
}
