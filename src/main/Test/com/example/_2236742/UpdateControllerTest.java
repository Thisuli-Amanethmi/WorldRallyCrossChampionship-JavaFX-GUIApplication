package com.example._2236742;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UpdateControllerTest {
    UpdateController updateController = new UpdateController();

    @Test
    @DisplayName("Update search name validity - Test")
    void checkUpdateSearchNameValid() {
        ArrayList record = new ArrayList();
        record.add("A");
        record.add("1");
        record.add("ABC");
        record.add("A23");
        record.add("11");

        AddController addController = new AddController();
        addController.mainRecord.add(record);

        assertEquals(1, updateController.checkUpdateSearchNameValid(""));
        assertEquals(2, updateController.checkUpdateSearchNameValid("A1"));
        assertEquals(2, updateController.checkUpdateSearchNameValid("A@"));
        assertEquals(2, updateController.checkUpdateSearchNameValid("A "));
        assertEquals(3, updateController.checkUpdateSearchNameValid("W"));
        assertEquals(0, updateController.checkUpdateSearchNameValid("A"));
    }

    @Test
    @DisplayName("Update search data validity - Test")
    void checkUpdateSearchDataValid() {
        assertEquals(1, updateController.checkUpdateSearchDataValid(""));
        assertEquals(2, updateController.checkUpdateSearchDataValid("xxx"));
        assertEquals(2, updateController.checkUpdateSearchDataValid("x7"));
        assertEquals(2, updateController.checkUpdateSearchDataValid("x@"));
        assertEquals(0, updateController.checkUpdateSearchDataValid("Name"));
        assertEquals(0, updateController.checkUpdateSearchDataValid("Age"));
        assertEquals(0, updateController.checkUpdateSearchDataValid("Car"));
        assertEquals(0, updateController.checkUpdateSearchDataValid("Team"));
        assertEquals(0, updateController.checkUpdateSearchDataValid("Current points"));
    }

    @Test
    @DisplayName("Updated value validity - Test")
    void updatedValueValid() {
        AddController addController = new AddController();
        ArrayList record = new ArrayList();

        record.add("A");
        record.add("1");
        record.add("ABC");
        record.add("A23");
        record.add("11");
        addController.mainRecord.add(record);

        record.add("P");
        record.add("8");
        record.add("PQR");
        record.add("P67");
        record.add("83");
        addController.mainRecord.add(record);

        assertEquals(1, updateController.updatedValueValid("", ""));
        assertEquals(1, updateController.updatedValueValid("Age", ""));
        // assertEquals(1, updateController.updatedValueValid("", "4"));
        // this is not possible. because if data is empty, it can't take the value

        assertEquals(2, updateController.updatedValueValid("Name", "P5 "));
        // assertEquals(3, updateController.updatedValueValid("Name", "P"));
        assertEquals(0, updateController.updatedValueValid("Age", "4"));
        assertEquals(0, updateController.updatedValueValid("Car", "XYZ"));
        assertEquals(0, updateController.updatedValueValid("Team", "X89"));
        assertEquals(0, updateController.updatedValueValid("Current points", "24"));
        assertEquals(0, updateController.updatedValueValid("Name", "X"));
    }
}