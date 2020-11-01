package com.example.skak.Service;

import com.example.skak.Models.medarbejder;
import com.example.skak.Models.medlem;
import com.example.skak.Repository.arbejderRepository;
import com.example.skak.Repository.medlemsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class medarbejderServiceTest {

    @InjectMocks
    medarbejderService medarbejderServiceInjection = new medarbejderService();

    @Mock
    arbejderRepository arbejderRepositoryMock;





    @Test
    void createArbejder() {

        medarbejder testobjekt = new medarbejder(100, "Christoffer", "Brydensholt", 342432, "Kasserer");

        arbejderRepositoryMock.createArbejder(testobjekt);

        Mockito.verify(arbejderRepositoryMock, times(1)).createArbejder(testobjekt);


    }
}