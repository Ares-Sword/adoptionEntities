package com.p6.adoption.repository.dogs;

import com.p6.adoption.models.DogDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer>
{
    Dog findDogByName(String name);


}