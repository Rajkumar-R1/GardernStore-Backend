package com.example.springboot.repository;

import com.example.springboot.model.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GardenRepo extends JpaRepository<Garden, Integer> {

    List<Garden> findBygardenName(String gardenName);
    
    @Query("SELECT DISTINCT g FROM Garden g INNER JOIN g.users u WHERE u.id = ?1")
    List<Garden> findByUserId(int userId);

    @Query("SELECT DISTINCT g FROM Garden g INNER JOIN g.users u WHERE u.id = ?1")
    List<Garden> findByUsername(int username);
}
