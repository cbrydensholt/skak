package com.example.skak.Repository;

import com.example.skak.Models.medarbejder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class arbejderRepositoryTest {

    arbejderRepository arbejderRepository = new arbejderRepository();


    @Test
    void createArbejder() {

        medarbejder testarbejder = new medarbejder(3, "Hans", "Chrisian", 234324324, "Kasserer");

        arbejderRepository.createArbejder(testarbejder);


    }

    @Test
    void readArbejder() {



        assertEquals("Hans", arbejderRepository.readArbejder(3).getArbejderFornavn());


    }


    @Test
    void updateArbejder() {
        medarbejder testarbejder1 = new medarbejder(3, "Peter", "Chrisian", 234324324, "Kasserer");

        arbejderRepository.updateArbejder(testarbejder1);

        assertEquals("Peter", arbejderRepository.readArbejder(3).getArbejderFornavn());

    }


    @Test
    void deleteArbejder() {

        arbejderRepository.deleteArbejder(3);

        assertEquals(null, arbejderRepository.readArbejder(3).getArbejderTitel());

    }




    @Test
    void readAlleArbejdere() {
    }

}