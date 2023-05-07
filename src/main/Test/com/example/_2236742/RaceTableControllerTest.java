package com.example._2236742;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTableControllerTest {
    RaceTableController raceTableController = new RaceTableController();

    @Test
    @DisplayName("Race table, bubble sort - Test")
    void bubbleSort() {
        ArrayList<List> raceDetails = new ArrayList<>();
        List<String> raceDateLocation1 = new ArrayList<>();
        List<String> raceDateLocation2 = new ArrayList<>();
        List<String> raceDateLocation3 = new ArrayList<>();

        String date1 = "2023-APRIL-17";
        raceDateLocation1.add(date1);
        String location1 = "location 1";
        raceDateLocation1.add(location1);
        raceDetails.add(raceDateLocation1);

        String date2 = "2023-APRIL-25";
        raceDateLocation2.add(date2);
        String location2 = "location 2";
        raceDateLocation2.add(location2);
        raceDetails.add(raceDateLocation2);

        String date3 ="2023-APRIL-10";
        raceDateLocation3.add(date3);
        String location3 = "location 3";
        raceDateLocation3.add(location3);
        raceDetails.add(raceDateLocation3);

        System.out.println("Before sorting : " + raceDetails);

        ArrayList<List> raceDetailsSorted = new ArrayList<>();
        raceDetailsSorted.add(raceDateLocation3);
        raceDetailsSorted.add(raceDateLocation1);
        raceDetailsSorted.add(raceDateLocation2);

        System.out.println("Before sorting : " + raceDetailsSorted);

        assertEquals(raceDetailsSorted, raceTableController.bubbleSort(raceDetails));
    }
}