package com.p6.adoption.models.adapters;

import com.p6.adoption.models.CatDTO;
import com.p6.adoption.repository.cats.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter {

    public static Cat fromDto(CatDTO catDTO) {
        if(catDTO.getName().equals("")) {
            catDTO.setName("Generic cat");
        }
        return new Cat().setName(catDTO.getName()).setUrl(catDTO.getPhotoUrl());
    }

    public static CatDTO toDto(Cat cat) {
        return new CatDTO(cat.getName(), cat.getUrl(), cat.getId());
    }

    public static List<CatDTO> toListDto(List<Cat> catList) {
        List<CatDTO> dtoList = new ArrayList<>();

        catList.forEach(cat -> dtoList.add(toDto(cat)));

        return dtoList;
    }


}
