package com.example.skak.Service;


import com.example.skak.Models.medlem;
import com.example.skak.Repository.restanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class restanceService {

    @Autowired
    restanceRepository restanceRepository;

    public List readAllRestancer(){

       List<medlem> restanceListe = restanceRepository.readAllRestancer();

        return restanceListe;


    }

    public void tilføjGebyr(int medlemsId){

        restanceRepository.tilføjRykkerGebyr(medlemsId);

    }

    public void updateRestance(medlem medlemFromPost){

        restanceRepository.updateRestance(medlemFromPost);

    }

    public medlem readRestance(int medlemsId){

       medlem medlemToReturn = restanceRepository.readRestance(medlemsId);

       return medlemToReturn;
    }


}
