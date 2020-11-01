package com.example.skak.Service;


import com.example.skak.Models.medarbejder;
import com.example.skak.Models.medlem;
import com.example.skak.Repository.arbejderRepository;
import com.example.skak.Repository.medlemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class medarbejderService {


    @Autowired
    arbejderRepository arbejderRepository;


    public medarbejder createArbejder(medarbejder medarbejderFromPost) {


        arbejderRepository.createArbejder(medarbejderFromPost);

        return arbejderRepository.createArbejder(medarbejderFromPost);

    }

    public void updateArbejder(medarbejder medarbejderFromPost) {


        arbejderRepository.updateArbejder(medarbejderFromPost);
    }

    public void deleteArbejder(int arbejderId) {


        arbejderRepository.deleteArbejder(arbejderId);
    }



    public medarbejder readMedarbejder(int arbejderId){

        medarbejder arbejderToReturn = arbejderRepository.readArbejder(arbejderId);
        return arbejderToReturn;
    }

    public List readAllArbejdere(){

        List<medarbejder> alleArbejdereList = arbejderRepository.readAlleArbejdere();

        return alleArbejdereList;
    }


}

