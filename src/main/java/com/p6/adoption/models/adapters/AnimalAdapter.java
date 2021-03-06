package com.p6.adoption.models.adapters;

import com.p6.adoption.models.AnimalDTO;
import com.p6.adoption.repository.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter
{
    public static Animal fromDto(AnimalDTO AnimalDTO)
    {
        if (AnimalDTO.getName().equals(""))
        {
            AnimalDTO.setName("Generic Animal");
        }
        return new Animal().setName(AnimalDTO.getName()).setPhotoUrl(AnimalDTO.getPhotoUrl());
    }

    public static List<Animal> fromDto(List<AnimalDTO> dtos)
    {
        List<Animal> animals = new ArrayList<>();
        for (AnimalDTO animal : dtos)
        {
            animals.add(fromDto(animal));
        }
        return animals;
    }

    public static AnimalDTO toDto(Animal Animal)
    {
        return new AnimalDTO(Animal.getName(), Animal.getPhotoUrl(), Animal.getId());
    }

    public static List<AnimalDTO> toListDto(List<Animal> AnimalList)
    {
        List<AnimalDTO> dtoList = new ArrayList<>();

        AnimalList.forEach(Animal -> dtoList.add(toDto(Animal)));

        return dtoList;
    }

}