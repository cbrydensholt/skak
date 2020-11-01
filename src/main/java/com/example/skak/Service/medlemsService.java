package com.example.skak.Service;


import com.example.skak.Models.medlem;
import com.example.skak.Repository.medlemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class medlemsService {


    @Autowired
    medlemsRepository medlemsRepository;


    public medlem createMedlem(medlem medlem1) {

        int voksenRestance = 650;
        int juniorrestance = 250;
        int seniorrestance = 450;

        if(medlem1.getMedlemsKategori().equals("Senior")){
            medlem1.setMedlemsRestance(seniorrestance);
        } else if(medlem1.getMedlemsKategori().equals("Voksen")){
            medlem1.setMedlemsRestance(voksenRestance);
        } else{
            medlem1.setMedlemsRestance(juniorrestance);
        }



       return medlemsRepository.createMedlem(medlem1);


    }

    public void updateMedlem(medlem medlemFromPost) {


        medlemsRepository.updateMedlem(medlemFromPost);
    }

    public medlem deleteMedlem(int medlemsId) {

        medlem toBeDeleted = medlemsRepository.readMedlem(medlemsId);

        medlemsRepository.deleteMedlem(medlemsId);

        return toBeDeleted;
    }



    public medlem readMedlem(int medlemsId){

        medlem medlemtoreturn = medlemsRepository.readMedlem(medlemsId);
        return medlemtoreturn;
    }

    public List readAllMedlemmer(){

        List<medlem> allemedlemmerListe = medlemsRepository.readAllMedlemmer();

        return allemedlemmerListe;
    }

    public void styrkejustering(int medlemsId, int modstanderRating, String result){
        medlem dettemedlem = medlemsRepository.readMedlem(medlemsId);
        System.out.println(dettemedlem);
        int medlemsRating = dettemedlem.getMedlemsRating();
        int ratingChange = 0;
        int totalRating = medlemsRating + ratingChange;

        if(result.equals("won")) {

            if (medlemsRating > modstanderRating) {
                ratingChange = 2;
                dettemedlem.setMedlemsRating(medlemsRating + 2);


            } else if (modstanderRating > medlemsRating) {
                ratingChange = 5;

                dettemedlem.setMedlemsRating(medlemsRating + 5);


            } else {

                dettemedlem.setMedlemsRating(medlemsRating + 1);


            }

        }

        if(result.equals("lost")){

            dettemedlem.setMedlemsRating(medlemsRating - 2);


        }

        System.out.println(dettemedlem.getMedlemsRating());

        medlemsRepository.styrkejustering(dettemedlem);

    }


    public medlem searchForMember(int telefonnummer){

        medlem tempmedlem = medlemsRepository.searchForMember(telefonnummer);


        return tempmedlem;



    }


}
