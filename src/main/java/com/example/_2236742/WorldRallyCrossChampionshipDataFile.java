package com.example._2236742;

import java.io.File;
import java.io.IOException;

public class WorldRallyCrossChampionshipDataFile {

    public static void createFile() {
        try{
            File myObject = new File("worldRallyCrossChampionshipData.txt");

            if(myObject.createNewFile()) {
                System.out.println("File created : " + myObject.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("File already exists.");
        }
    }
}
