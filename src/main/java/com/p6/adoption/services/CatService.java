package com.p6.adoption.services;

import com.p6.adoption.models.CatDTO;
import com.p6.adoption.models.ListDTO;
import com.p6.adoption.models.adapters.CatAdapter;
import com.p6.adoption.repository.cats.CatRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatService {
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {

        this.catRepository = catRepository;
    }

    public void addCat(CatDTO catDto) {
        if (catDto.getName() == null && catDto.getPhotoUrl() == null) {
            throw new RuntimeException("Cat must have a name and a photo!");
        }

        catRepository.save(CatAdapter.fromDto(catDto));
    }

    public ListDTO<CatDTO> findAll() {
        List<CatDTO> cats = CatAdapter.toListDto(catRepository.findAll().stream().filter(cat -> cat.getId() != 2).collect(Collectors.toList()));
        long totalCount = catRepository.count();

        return new ListDTO<>(Math.toIntExact(totalCount), cats);
    }

    public CatDTO findCat(String name) {
        if (name == null || name.equals("")) {
            throw new RuntimeException("Must specify name!");
        }

        return CatAdapter.toDto(catRepository.findCatByName(name));
    }
}