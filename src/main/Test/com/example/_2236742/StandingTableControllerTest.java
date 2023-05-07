package com.example._2236742;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StandingTableControllerTest {
    StandingTableController standingTableController = new StandingTableController();

    @Test
    @DisplayName("Bubble sort - Test")
    void bubbleSort() {
        ArrayList<ArrayList> testMainList = new ArrayList<>();
        ArrayList<String> testList1 = new ArrayList<>();
        ArrayList<String> testList2 = new ArrayList<>();
        ArrayList<String> testList3 = new ArrayList<>();

        testList1.add("A");
        testList1.add("1");
        testList1.add("A");
        testList1.add("A");
        testList1.add("1");
        testMainList.add(testList1);

        testList3.add("C");
        testList3.add("3");
        testList3.add("C");
        testList3.add("C");
        testList3.add("3");
        testMainList.add(testList3);

        testList2.add("B");
        testList2.add("2");
        testList2.add("B");
        testList2.add("B");
        testList2.add("2");
        testMainList.add(testList2);

        // after bubble sort
        ArrayList<ArrayList> testMainListAfterSort = new ArrayList<>();
        testMainListAfterSort.add(testList3);
        testMainListAfterSort.add(testList2);
        testMainListAfterSort.add(testList1);


        assertEquals(testMainListAfterSort, standingTableController.bubbleSort(testMainList));
    }
}