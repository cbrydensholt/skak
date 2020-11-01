package com.example.skak.Service;

import com.example.skak.Models.Turnering;
import com.example.skak.Repository.restanceRepository;
import com.example.skak.Repository.turneringsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class turneringsServiceTest {

      @InjectMocks
    turneringsService turneringsServiceInjection = new turneringsService();

    @Mock
    turneringsRepository turneringsMock;



    @Test
    void readAllTournaments() {
        when(turneringsServiceInjection.readAllTurneringer()).thenReturn(Arrays.asList(new Turnering(1, "IKEA CUP", 22, "2020-10-20", "Senior"),
                new Turnering(2, "COLA CUP", 33, "2020-12-12", "Junior")));

        List<Turnering> alleTurneringer = turneringsServiceInjection.readAllTurneringer();

        assertEquals("IKEA CUP", alleTurneringer.get(0).getTurneringsNavn());
        assertEquals("COLA CUP", alleTurneringer.get(1).getTurneringsNavn());



    }

    @Test
    void createTurnering() {

        Turnering testturnering = new Turnering(33, "cph cup", 20, "2020-10-10", "Junior");

        when(turneringsMock.createTurnering(testturnering)).thenReturn(testturnering);
        assertEquals("cph cup", turneringsServiceInjection.createTurnering(testturnering).getTurneringsNavn());


    }


    @Test
    void updateTurnering() {
    }

    @Test
    void deleteTurnering() {

        Turnering testturnering = new Turnering(33, "cph cup", 20, "2020-10-10", "Junior");

        turneringsServiceInjection.deleteTurnering(33);

        Mockito.verify(turneringsMock, times(1)).deleteTurnering(33);

    }

    @Test
    void readTurnering() {
        when(turneringsMock.readTurnering(1)).thenReturn(new Turnering(1, "test", 33, "2020-10-10", "Senior"));
        assertEquals("Senior", turneringsServiceInjection.readTurnering(1).getDeltagerKategori());
    }

    @Test
    void readAllTurneringer() {
    }
}