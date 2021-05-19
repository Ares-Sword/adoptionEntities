package com.p6.adoption.examples;

import com.p6.adoption.models.Animal;
import com.p6.adoption.models.Cat;
import com.p6.adoption.models.Dog;

public class OopExample
{

    public static void main(String[] args)
    {
        Animal animal = new Animal();
        Animal animal2 = new Animal("Hachi", "http://hachi.jpg",2);
        Animal animal3 = new Animal()
                .setName("Hachi")
                .setPhotoUrl("photo");


        //Polymorphism
        Cat cat = new Cat("Machi", "photo",1);
        Dog dog = new Dog("Machia", "photoa",1);
        Animal catAnimal = new Cat("Zoro", "photo",1);
        Animal dogAnimal = new Dog("Zoro", "photo",4);

        cat.speak();
        catAnimal.speak();
    }
}