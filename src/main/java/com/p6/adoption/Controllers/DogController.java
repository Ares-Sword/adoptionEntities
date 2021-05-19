package com.p6.adoption.Controllers;

import com.p6.adoption.models.DogDTO;
import com.p6.adoption.models.ListDTO;
import com.p6.adoption.services.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/dogs")
public class DogController
{
    private final DogService DogService;

    public DogController(DogService dogService)
    {

        this.DogService = dogService;
    }

    @GetMapping
    public ResponseEntity<ListDTO<DogDTO>> getAllDogs()
    {

        return ResponseEntity.ok(DogService.findAll());
    }

    @PostMapping
    public void addDog(@RequestBody DogDTO dogDTO)
    {

        DogService.addDog(dogDTO);
    }

    @GetMapping("/{name}")
    public DogDTO getDogByName(@PathVariable("name") String name)
    {
        return DogService.findDog(name);
    }
}