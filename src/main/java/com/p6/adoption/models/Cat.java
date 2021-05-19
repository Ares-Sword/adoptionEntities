package com.p6.adoption.models;

public class Cat extends Animal
{
    public Cat(String name, String photoUrl,Integer id)
    {
        super(name, photoUrl,id);
    }

    public void iAmACat()
    {
        System.out.println("Cats are special!");
    }

    @Override
    public void speak()
    {
        System.out.println("Cat speaks!");
    }
}
