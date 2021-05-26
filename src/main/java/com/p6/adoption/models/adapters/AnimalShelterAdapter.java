package com.p6.adoption.models.adapters;

import com.p6.adoption.models.AnimalShelterDTO;
import com.p6.adoption.repository.shelter.AnimalShelter;

public class AnimalShelterAdapter
{

    public static AnimalShelter fromDto(AnimalShelterDTO shelterDTO)
    {
        if (shelterDTO.getName().equals(""))
        {
            shelterDTO.setName("Generic shelter");
        }
        AnimalShelter animalShelter = new AnimalShelter()
                .setAddress(shelterDTO.getAddress())
                .setName(shelterDTO.getName())
                .setId(shelterDTO.getId())
                .setAnimals(AnimalAdapter.fromDto(shelterDTO.getAnimals()));
        return animalShelter;
    }

    public static AnimalShelterDTO toDto(AnimalShelter shelter)
    {
        return new AnimalShelterDTO()
                .setAddress(shelter.getAddress())
                .setId(shelter.getId())
                .setName(shelter.getName())
                .setAnimals(AnimalAdapter.toListDto(shelter.getAnimals()));
    }

}
