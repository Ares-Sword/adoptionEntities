package com.p6.adoption.Controllers;

import com.p6.adoption.models.AnimalShelterDTO;
import com.p6.adoption.services.AnimalShelterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/shelters")
public class AnimalShelterController
{
    private final AnimalShelterService shelterService;

    public AnimalShelterController(AnimalShelterService shelterService)
    {
        this.shelterService = shelterService;
    }

    @GetMapping("/{id}")
    private ResponseEntity<AnimalShelterDTO> getShelter(@PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(shelterService.getShelter(id));
    }

    @PostMapping
    private ResponseEntity<AnimalShelterDTO> createShelter(@RequestBody AnimalShelterDTO shelterDTO)
    {
        return ResponseEntity.ok(shelterService.createShelter(shelterDTO));
    }
}
