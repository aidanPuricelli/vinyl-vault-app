package com.example.vinylvaultback.service;

import com.example.vinylvaultback.model.Vinyl;
import com.example.vinylvaultback.repo.VinylRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VinylService {
    private final VinylRepo vinylRepo;

    @Autowired
    public VinylService(VinylRepo vinylRepo) {
        this.vinylRepo = vinylRepo;
    }

    public Vinyl addVinyl(Long userId, Vinyl vinyl) {
        vinyl.setUser_id(userId);
        return vinylRepo.save(vinyl);
    }

    public List<Vinyl> findAllVinyls(Long userId) {
        return vinylRepo.findByUserId(userId);
    }

    public Vinyl updateVinyl(Vinyl vinyl) {
        return vinylRepo.save(vinyl);
    }

    public Vinyl findVinylById(Long id) {
        return vinylRepo.findVinylById(id);
    }

    public void deleteVinyl(Long id) {
        vinylRepo.deleteById(id);
    }

}
