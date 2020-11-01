package com.example.skak.Repository;

import com.example.skak.Models.medlem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class restanceRepositoryTest {


    restanceRepository restanceRepository = new restanceRepository();


    @Test
    void tilføjRykkerGebyr() {

        restanceRepository.tilføjRykkerGebyr(30);

        assertEquals(730, restanceRepository.readRestance(30).getMedlemsRestance());

    }

    @Test
    void updateRestance() {

        medlem testmedlem = new medlem(30, "Christoffer", "Brydensholt", 342425, "Voksen", 5, 1000 );

        restanceRepository.updateRestance(testmedlem);

        assertEquals(1000, restanceRepository.readRestance(30).getMedlemsRestance());

    }

    @Test
    void readRestance() {

        restanceRepository.readRestance(30);

        assertEquals(1000, restanceRepository.readRestance(30).getMedlemsRestance());


    }
}