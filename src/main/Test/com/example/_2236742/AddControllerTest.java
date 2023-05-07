package com.example._2236742;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddControllerTest {
    AddController addController = new AddController();
    @Test
    @DisplayName("Add name validity - Test")
    void checkAddNameValid() {
        ArrayList record = new ArrayList();
        record.add("A");
        record.add("1");
        record.add("ABC");
        record.add("A23");
        record.add("11");

        addController.mainRecord.add(record);

        assertEquals(1, addController.checkAddNameValid(""));
        assertEquals(2, addController.checkAddNameValid("Jak8"));
        assertEquals(2, addController.checkAddNameValid("J@k8"));
        assertEquals(2, addController.checkAddNameValid("Jake "));
        assertEquals(3, addController.checkAddNameValid("A"));
        assertEquals(0, addController.checkAddNameValid("Jake"));
    }

    @Test
    @DisplayName("Add age validity - Test")
    void checkAddAgeValid() {
        assertEquals(1, addController.checkAddAgeValid(""));
        assertEquals(2, addController.checkAddAgeValid("I1"));
        assertEquals(2, addController.checkAddAgeValid("11 "));
        assertEquals(0, addController.checkAddAgeValid("11"));
    }

    @Test
    @DisplayName("Add current points validity - Test")
    void checkAddCurrentPointsValid() {
        assertEquals(1, addController.checkAddCurrentPointsValid(""));
        assertEquals(2, addController.checkAddCurrentPointsValid("g7"));
        assertEquals(2, addController.checkAddCurrentPointsValid("77 "));
        assertEquals(0, addController.checkAddCurrentPointsValid("77"));
    }

    @Test
    @DisplayName("Add details validity - Test")
    void checkAddValid() {
        assertEquals(1, addController.checkAddValid("", "21", "Honda", "ET1", "87"));
        assertEquals(1, addController.checkAddValid("Jake", "", "Honda", "ET1", "87"));
        assertEquals(1, addController.checkAddValid("Jake", "21", "", "ET1", "87"));
        assertEquals(1, addController.checkAddValid("Jake", "21", "Honda", "", "87"));
        assertEquals(1, addController.checkAddValid("Jake", "21", "Honda", "ET1", ""));
        assertEquals(1, addController.checkAddValid("", "", "", "", ""));
        assertEquals(0, addController.checkAddValid("Jake", "21", "Honda", "ET1", "87"));
    }
}
