package com.example.skak.Service;

import com.example.skak.Models.Turnering;
import com.example.skak.Models.medlem;
import com.example.skak.Repository.medlemsRepository;
import com.example.skak.Repository.turneringsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class turneringsService {



    @Autowired
    turneringsRepository turneringsRepository;


    public Turnering createTurnering(Turnering turnering) {


        return turneringsRepository.createTurnering(turnering);


    }

    public void updateTurnering(Turnering turneringFromPost) {


        turneringsRepository.updateTurnering(turneringFromPost);
    }

    public Turnering deleteTurnering(int turneringsId) {

        Turnering toBeDeleted = turneringsRepository.readTurnering(turneringsId);

        turneringsRepository.deleteTurnering(turneringsId);

        return toBeDeleted;
    }



    public Turnering readTurnering(int turneringsId){

        Turnering turneringToReturn = turneringsRepository.readTurnering(turneringsId);
        return turneringToReturn;
    }

    public List readAllTurneringer(){

        List<Turnering> alleTurneringerListe = turneringsRepository.readAllTurneringer();

        return alleTurneringerListe;
    }


}

