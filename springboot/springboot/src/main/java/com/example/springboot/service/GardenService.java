package com.example.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.springboot.model.Garden;
import com.example.springboot.repository.GardenRepo;

@Service
public class GardenService {

    @Autowired
    GardenRepo gardenRepository;

    public Garden create(Garden garden) {
        return gardenRepository.save(garden);
    }

    public List<Garden> getAllGarden() {
        return gardenRepository.findAll();
    }

    public Optional<Garden> getGardenById(int id) {
        return gardenRepository.findById(id);
    }

    public boolean updateGarden(int id, Garden garden) {
        if (!gardenRepository.existsById(id)) {
            return false;
        }
        garden.setId(id);
        gardenRepository.save(garden);
        return true;
    }

    public boolean deleteGarden(int id) {
        if (!gardenRepository.existsById(id)) {
            return false;
        }
        gardenRepository.deleteById(id);
        return true;
    }

    public List<Garden> getAllGardenSortedBy(String sortBy) {
        return gardenRepository.findAll(Sort.by(sortBy));
    }

    public Page<Garden> getAllGardenPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return gardenRepository.findAll(pageable);
    }
 

    public List<Garden> findByUserId(int userId) {
        return gardenRepository.findByUserId(userId);
    }

}
