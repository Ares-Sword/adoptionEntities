package com.p6.adoption.models;



public class DogDTO extends AnimalDTO {

    public DogDTO(String name, String photoUrl, Integer id)
    {

        super(name, photoUrl, id);
    }

    public void iAmADog()
    {

        System.out.println("Dogs are special!");
    }

    @Override
    public void speak()
    {

        System.out.println("Dog speaks!");
    }
}
