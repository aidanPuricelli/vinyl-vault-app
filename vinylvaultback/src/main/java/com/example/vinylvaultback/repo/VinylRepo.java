package com.example.vinylvaultback.repo;

import com.example.vinylvaultback.model.Vinyl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VinylRepo extends JpaRepository<Vinyl, Long> {
    Vinyl findVinylById(Long id);
    List<Vinyl> findByUserId(Long userId);
}
