package com.p6.adoption.repository.cats;

import com.p6.adoption.repository.dogs.Dog;

import javax.persistence.*;

@Entity

public class Cat
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Integer id;
    private String name;
    private String url;

    public Integer getId()
    {

        return id;
    }

    public Cat setId(Integer id)
    {
        this.id = id;
        return this;
    }

    public String getName()
    {

        return name;
    }

    public Cat setName(String name)
    {
        this.name = name;
        return this;
    }

    public String getUrl()
    {

        return url;
    }

    public Cat setUrl(String url)
    {
        this.url = url;
        return this;
    }
}