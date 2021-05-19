package com.p6.adoption.services;


import com.p6.adoption.models.DogDTO;
import com.p6.adoption.models.ListDTO;
import com.p6.adoption.models.adapters.DogAdapter;
import com.p6.adoption.repository.dogs.Dog;
import com.p6.adoption.repository.dogs.DogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogService
{
    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository)
    {

        this.dogRepository = dogRepository;
    }

    public void addDog(DogDTO dogDTO)
    {
        if (dogDTO.getName() == null && dogDTO.getPhotoUrl() == null)
        {
            throw new RuntimeException("Dog must have a name and a photo!");
        }


        dogRepository.save(DogAdapter.fromDto(dogDTO));
    }

    public ListDTO<DogDTO> findAll()
    {
       List<DogDTO> dogs = DogAdapter.toListDto(dogRepository.findAll().stream().filter(dog -> dog.getId() != 2).collect(Collectors.toList()));
        long totalCount = dogRepository.count();

        return new ListDTO<>(Math.toIntExact(totalCount), dogs);
    }






    public DogDTO findDog(String name)
    {
        if (name == null || name == "")
        {
            throw new RuntimeException("Must specify name!");
        }

        return DogAdapter.toDto(dogRepository.findDogByName(name));
    }
}