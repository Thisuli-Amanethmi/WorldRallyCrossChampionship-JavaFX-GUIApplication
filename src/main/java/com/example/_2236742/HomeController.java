package com.example._2236742;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button standingTableButton;

    @FXML
    private Button randomRaceButton;

    @FXML
    private Button raceTableButton;

    @FXML
    private Button saveDataButton;

    @FXML
    private Button viewDataButton;

    @FXML
    private Button exitButton;

    public void addButtonOnClick(ActionEvent actionEvent) throws Exception {
        navigateAdd(actionEvent);
    }

    private void navigateAdd(ActionEvent actionEvent) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("add-view.fxml"));
        newStage.setTitle("World Rally Cross Championship - Add Driver");
        newStage.setScene(new Scene(root, 600, 500));
        newStage.show();

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }

    public void deleteButtonOnClick(ActionEvent actionEvent) throws Exception {
        navigateDelete(actionEvent);
    }

    private void navigateDelete(ActionEvent actionEvent) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("delete-view.fxml"));
        newStage.setTitle("World Rally Cross Championship - Delete Driver");
        newStage.setScene(new Scene(root, 600, 500));
        newStage.show();

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }

    public void updateButtonOnClick(ActionEvent actionEvent) throws Exception {
        navigateUpdate(actionEvent);
    }

    private void navigateUpdate(ActionEvent actionEvent) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("update-view.fxml"));
        newStage.setTitle("World Rally Cross Championship - Update Driver Details");
        newStage.setScene(new Scene(root, 600, 500));
        newStage.show();

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }


    public void standingTableButtonOnClick(ActionEvent actionEvent) throws Exception {
        navigateStandingTable(actionEvent);
    }

    private void navigateStandingTable(ActionEvent actionEvent) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("standingTable-view.fxml"));
        newStage.setTitle("World Rally Cross Championship - Standing Table");
        newStage.setScene(new Scene(root, 600, 500));
        newStage.show();

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }


    public void RandomRaceButtonOnClick(ActionEvent actionEvent) throws Exception {
        navigateRandomRaceTable(actionEvent);
    }

    private void navigateRandomRaceTable(ActionEvent actionEvent) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("randomRace-view.fxml"));
        newStage.setTitle("World Rally Cross Championship - Random Race");
        newStage.setScene(new Scene(root, 600, 500));
        newStage.show();

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }


    public void raceTableButtonOnClick(ActionEvent actionEvent) throws Exception {
        navigateRaceTable(actionEvent);
    }

    private void navigateRaceTable(ActionEvent actionEvent) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("raceTable-view.fxml"));
        newStage.setTitle("World Rally Cross Championship - Race Table");
        newStage.setScene(new Scene(root, 600, 500));
        newStage.show();

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }


    public void saveCurrentDataButtonOnClick(ActionEvent actionEvent) throws Exception {
        navigateSaveCurrentData(actionEvent);
    }

    private void navigateSaveCurrentData(ActionEvent actionEvent) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("saveCurrentData-view.fxml"));
        newStage.setTitle("World Rally Cross Championship - Save Current Data");
        newStage.setScene(new Scene(root, 600, 500));
        newStage.show();

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }



    public void viewCurrentDataButtonOnClick(ActionEvent actionEvent) throws Exception {
        navigateViewCurrentData(actionEvent);
    }

    private void navigateViewCurrentData(ActionEvent actionEvent) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("viewCurrentData-view.fxml"));
        newStage.setTitle("World Rally Cross Championship - View Current Data");
        newStage.setScene(new Scene(root, 600, 500));
        newStage.show();

        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }

    public void exitButtonOnClick() {
        System.exit(0);
    }
}