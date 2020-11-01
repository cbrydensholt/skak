package com.example.skak.Service;

import com.example.skak.Models.medlem;
import com.example.skak.Repository.medlemsRepository;
import com.example.skak.Repository.restanceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class restanceServiceTest {


    @InjectMocks
    restanceService restanceServiceInjection = new restanceService();

    @Mock
    restanceRepository restanceMock;


    @Test
    void readAllRestancer() {
        when(restanceServiceInjection.readAllRestancer()).thenReturn(Arrays.asList(new medlem(1, "Tim", "Hansen", 5235232, "Senior", 5, 200), new medlem(2, "christian", "petersen", 234234234, "Junior", 2, 500)));
        List<medlem> restanceListe = restanceServiceInjection.readAllRestancer();
        assertEquals(250, restanceListe.get(0).getMedlemsRestance());

    }
}