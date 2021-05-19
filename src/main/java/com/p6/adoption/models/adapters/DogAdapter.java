package com.p6.adoption.models.adapters;

import com.p6.adoption.models.DogDTO;
import com.p6.adoption.repository.dogs.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter {

    public static Dog fromDto(DogDTO dogDTO) {
        if(dogDTO.getName().equals("")) {
            dogDTO.setName("Generic dog");
        }
        return new Dog().setName(dogDTO.getName()).setUrl(dogDTO.getPhotoUrl());
    }

    public static DogDTO toDto(Dog dog) {

        return new DogDTO(dog.getName(), dog.getUrl(), dog.getId());
    }

    public static List<DogDTO> toListDto(List<Dog> dogList) {
        List<DogDTO> dtoList = new ArrayList<>();

        dogList.forEach(dog -> dtoList.add(toDto(dog)));

        return dtoList;
    }

    public static List<Dog> fromListDto(List<DogDTO> dtoList) {
        List<Dog> dogList = new ArrayList<>();

        dtoList.forEach(dtoDog -> dogList.add(fromDto(dtoDog)));

        return dogList;
    }



}