package com.p6.adoption.services;

import com.p6.adoption.models.AnimalShelterDTO;
import com.p6.adoption.models.adapters.AnimalShelterAdapter;
import com.p6.adoption.repository.animals.Animal;
import com.p6.adoption.repository.animals.AnimalRepository;
import com.p6.adoption.repository.shelter.AnimalShelter;
import com.p6.adoption.repository.shelter.AnimalShelterRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimalShelterService
{
    private final AnimalShelterRepository animalShelterRepository;
    private final AnimalRepository animalRepository;

    public AnimalShelterService(AnimalShelterRepository animalShelterRepository, AnimalRepository animalRepository)
    {
        this.animalShelterRepository = animalShelterRepository;
        this.animalRepository = animalRepository;
    }

    public AnimalShelterDTO getShelter(Integer id)
    {
        return AnimalShelterAdapter.toDto(animalShelterRepository.getOne(id));
    }

    public AnimalShelterDTO createShelter(AnimalShelterDTO shelterDTO)
    {
        AnimalShelter animalShelter = AnimalShelterAdapter.fromDto(shelterDTO);

        animalShelter.setId(null);
        for (Animal animal : animalShelter.getAnimals())
        {
            animal.setId(null);
        }

        return AnimalShelterAdapter.toDto(animalShelterRepository.save(animalShelter));
    }
}
