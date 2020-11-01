package com.example.skak.Repository;

import com.example.skak.Models.Turnering;
import com.example.skak.Service.restanceService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class turneringsRepositoryTest {

    turneringsRepository testrepo = new turneringsRepository();

    @InjectMocks
    restanceService restanceServiceInjection = new restanceService();

    @Mock
    turneringsRepository turneringsMock;



    @Test
    void createTurnering(){ //om dette lykkedes testes i vores findById test

        Turnering TestTurnering = new Turnering(9, "Skak Cup 220", 33, "2020-10-10", "Junior");

        testrepo.createTurnering(TestTurnering);




    }


    @Test
    void findById(){


        assertEquals("Skak Cup 320", testrepo.readTurnering(9).getTurneringsNavn());
        //assertNotNull(testrepo.readTurnering(9));


    }

    @Test
    void updateTurnering(){

        Turnering TestTurnering = new Turnering(9, "Skak Cup 220", 33, "2020-10-10", "Junior");

        TestTurnering.setTurneringsNavn("Skak Cup 320");

        testrepo.updateTurnering(TestTurnering);

        assertEquals("Skak Cup 320", testrepo.readTurnering(9).getTurneringsNavn());



    }


    @Test
    void deleteTurnering(){

        testrepo.deleteTurnering(9);
        assertEquals(null, testrepo.readTurnering(9).getTurneringsNavn());


    }

    @Test
    void readAlleTurneringer() { //vi vil have en metode der returnere alle de turneringer der findes i databasen.

        List<Turnering> alleTurneringer = new ArrayList<>();

        alleTurneringer = testrepo.readAllTurneringer();

        assertEquals(3, alleTurneringer.size());



    }




}