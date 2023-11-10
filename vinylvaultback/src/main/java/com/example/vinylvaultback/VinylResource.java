package com.example.vinylvaultback;

import com.example.vinylvaultback.model.Vinyl;
import com.example.vinylvaultback.service.VinylService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vinyl")
public class VinylResource {

    private final VinylService vinylService;

    public VinylResource(VinylService vinylService) { this.vinylService = vinylService; }

    @GetMapping("/all")
    public ResponseEntity<List<Vinyl>> getAllVinyls(@RequestParam("userId") Long userId) {
        List<Vinyl> vinyls = vinylService.findAllVinyls(userId);
        return new ResponseEntity<>(vinyls, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Vinyl> getVinylById(@PathVariable("id") Long id) {
        Vinyl vinyl = vinylService.findVinylById(id);
        return new ResponseEntity<>(vinyl, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Vinyl> addVinyl(@RequestParam("userId") Long userId, @RequestBody Vinyl vinyl) {
        Vinyl newVinyl = this.vinylService.addVinyl(userId, vinyl);
        return new ResponseEntity<>(newVinyl, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vinyl> updateVinyl(@RequestBody Vinyl vinyl) {
        Vinyl updateVinyl = this.vinylService.updateVinyl(vinyl);
        return new ResponseEntity<>(updateVinyl, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVinyl(@PathVariable("id") Long id) {
        vinylService.deleteVinyl(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
