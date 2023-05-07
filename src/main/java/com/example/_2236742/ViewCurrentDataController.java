package com.example._2236742;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ViewCurrentDataController {

    @FXML
    private Button buttonHomePage;

    @FXML
    private Button buttonViewCurrentData;

    @FXML
    private TextArea currentDataArea;


    public void ReadFiles() {
        try {
            File myObject = new File("worldRallyCrossChampionshipData.txt");
            Scanner myReader = new Scanner(myObject);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                currentDataArea.appendText(data + "\n");
                System.out.println(data);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public void viewCurrentData(ActionEvent actionEvent) throws IOException {
        ReadFiles();
    }

    public void viewCurrentDataButtonOnClick(ActionEvent actionEvent) throws IOException {
        viewCurrentData(actionEvent);
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
