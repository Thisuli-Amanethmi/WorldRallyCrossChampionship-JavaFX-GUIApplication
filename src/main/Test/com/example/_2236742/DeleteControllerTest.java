package com.example._2236742;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeleteControllerTest {

    @Test
    @DisplayName("Delete search name validity - Test")
    void checkDeleteSearchName() {
        DeleteController deleteController = new DeleteController();

        ArrayList record = new ArrayList();
        record.add("A");
        record.add("1");
        record.add("ABC");
        record.add("A23");
        record.add("11");

        AddController addController = new AddController();
        addController.mainRecord.add(record);

        assertEquals(1, deleteController.checkDeleteSearchName(""));
        assertEquals(2, deleteController.checkDeleteSearchName("Jak3"));
        assertEquals(2, deleteController.checkDeleteSearchName("J@ake"));
        assertEquals(2, deleteController.checkDeleteSearchName("Jake "));
        assertEquals(3, deleteController.checkDeleteSearchName("Jake"));
        assertEquals(0, deleteController.checkDeleteSearchName("A"));
    }
}