package com.example._2236742;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveCurrentDataController {
    @FXML
    private Button buttonHomePage;

    @FXML
    private Button buttonSaveCurrentData;

    @FXML
    private Label saveCurrentDataTextMessage;




    public void WriteFile() throws IOException {
        // referred to:  https://www.java67.com/2015/07/how-to-append-text-to-existing-file-in-java-example.html

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("worldRallyCrossChampionshipData.txt", false);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            for(int i=0; i<AddController.mainRecord.size(); i++) {
                pw.println("Driver " + (i+1) + " : " + "Name-" + AddController.mainRecord.get(i).get(0)
                        + " Age-" + AddController.mainRecord.get(i).get(1) + " Car-" + AddController.mainRecord.get(i).get(2)
                        + " Team-" + AddController.mainRecord.get(i).get(3) + " CurrentPoints-" + AddController.mainRecord.get(i).get(4));
                pw.println();
            }

            System.out.println("Data Successfully added into file");
            pw.flush();
        } finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {
                // can't do anything
            }
        }

    }


    public void saveCurrentData(ActionEvent actionEvent) throws IOException {
        WriteFile();
        saveCurrentDataTextMessage.setText("Current data successfully saved !!!");
    }

    public void saveCurrentDataButtonOnClick(ActionEvent actionEvent) throws IOException {
        saveCurrentData(actionEvent);
    }

    public void homePageButtonOnClick(ActionEvent actionEvent) throws Exception {
        navigateHomePage(actionEvent);
    }

    private void navigateHomePage(ActionEvent actionEvent) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        newStage.setTitle("World Rally Cross Championship");
        newStage.setScene(new Scene(root, 600, 500));
        newStage.show();

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }
}
