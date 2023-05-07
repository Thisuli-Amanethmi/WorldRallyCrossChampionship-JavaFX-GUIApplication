package com.example._2236742;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomRaceControllerTest {
    RandomRaceController randomRaceController = new RandomRaceController();

    @Test
    @DisplayName("Random date validity - Test")
    void dateGenerator() {
        String date = randomRaceController.dateGenerator();
        System.out.println(date);
        assertNotNull(date);
    }

    @Test
    @DisplayName("Random value(for generate location) validity - Test")
    void randomValue() {
        String[] raceLocation = {"Nyirad", "Holjes", "Montalegre", "Barcelona", "Riga", "Norway"};

        String location = randomRaceController.RandomValue(raceLocation);
        System.out.println(location);
        assertNotNull(location);
    }

    @Test
    @DisplayName("Random driver name validity - Test")
    void randomValueDriverName() {
        List<String> driverNameList = new ArrayList<>();
        driverNameList.add("A");
        driverNameList.add("B");
        driverNameList.add("C");

        String driver1 = randomRaceController.RandomValueDriverName(driverNameList);
        System.out.println(driver1);
        assertNotNull(driver1);

        System.out.println(driverNameList);
    }
}