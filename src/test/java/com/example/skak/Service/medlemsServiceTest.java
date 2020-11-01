package com.example.skak.Service;

import com.example.skak.Models.medlem;
import com.example.skak.Repository.medlemsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class medlemsServiceTest {

    @InjectMocks
    medlemsService medlemsServiceInjection = new medlemsService();

    @Mock
    medlemsRepository medlemsRepositoryMock;

    medlemsService medlemsService = new medlemsService();




    @Test
    void createMedlem() {

        medlem testobjekt = new medlem(110, "Thomas", "Hansen", 234324, "Junior", 5, 0);

        when(medlemsRepositoryMock.createMedlem(testobjekt)).thenReturn(testobjekt); //repository er vores data access som vores service bruger. Derfor bruger vi den i when()
        assertTrue(medlemsServiceInjection.createMedlem(testobjekt).equals(testobjekt)); //når vi opretter et nyt medlem i create metoden-

    }

    @Test
    void updateMedlem() {

        medlem testobjekt = new medlem(110, "Thomas", "Hansen", 234324, "Junior", 5, 0);

        medlemsServiceInjection.createMedlem(testobjekt);

        verify(medlemsRepositoryMock, times(1)).createMedlem(testobjekt);




    }

    @Test
    void deleteMedlem() {
        medlem testobjekt = new medlem(110, "Thomas", "Hansen", 234324, "Junior", 5, 0);

        medlemsServiceInjection.deleteMedlem(110);

        verify(medlemsRepositoryMock, times(1)).deleteMedlem(110);





    }

    @Test
    void readMedlem() {

        when(medlemsRepositoryMock.readMedlem(1)).thenReturn(new medlem(1, "Thor", "Hansen", 453252, "junior", 5, 0));
        assertEquals("Thor", medlemsServiceInjection.readMedlem(1).getMedlemsFornavn());




    }

    @Test
    void readAllMedlemmer() {
        when(medlemsServiceInjection.readAllMedlemmer()).thenReturn(Arrays.asList(new medlem(1, "Tim", "Hansen", 5235232, "Senior", 5, 0), new medlem(2, "christian", "petersen", 234234234, "Junior", 2, 0)));
        List<medlem> allemedlemmer = medlemsServiceInjection.readAllMedlemmer();

        assertEquals("Hansen", allemedlemmer.get(0).getMedlemsEfternavn());
        assertEquals("christian", allemedlemmer.get(1).getMedlemsFornavn());

    }


    @Test
    void searchForMember() {

            when(medlemsServiceInjection.searchForMember(325235)).thenReturn(new medlem(9, "hans", "test2", 325235, "Senior", 5, 0));

            assertEquals("hans", medlemsServiceInjection.searchForMember(325235).getMedlemsFornavn());

            verify(medlemsRepositoryMock, times(1)).searchForMember(325235);

    }
}