package com.example.skak.Repository;

import com.example.skak.Models.medlem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class medlemsRepositoryTest {

    medlemsRepository medlemsRepository = new medlemsRepository();

    @Test
    void createMedlem() {

        medlem testmedlem = new medlem(18, "Hans", "Christian", 343243, "Junior", 5, 800);

        medlemsRepository.createMedlem(testmedlem);


    }

    @Test
    void readMedlem() {

        medlemsRepository.readMedlem(18);

        assertEquals("Hans", medlemsRepository.readMedlem(18).getMedlemsFornavn());

    }


    @Test
    void updateMedlem() {

        medlem testmedlem = new medlem(18, "Sofie", "Christian", 343243, "Junior", 5, 800);

        medlemsRepository.updateMedlem(testmedlem);

        assertEquals("Sofie", medlemsRepository.readMedlem(18).getMedlemsFornavn());

    }


    @Test
    void deleteMedlem() {

        medlemsRepository.deleteMedlem(18);

        assertEquals(null, medlemsRepository.readMedlem(18).getMedlemsEfternavn());


    }


    @Test
    void searchForMember() {


        assertEquals("hans", medlemsRepository.searchForMember(325235).getMedlemsFornavn());


    }
}