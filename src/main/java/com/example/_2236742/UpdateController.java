package com.example._2236742;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.InputMismatchException;

public class UpdateController {
    public UpdateController() {

    }

    @FXML
    private TextField updateSearchName;

    @FXML
    private TextField updateSearchData;

    @FXML
    private Label UpdateDataName;

    @FXML
    private TextField updatedValue;

    @FXML
    private Label updateTextMessage;

    @FXML
    private Button buttonSearch;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonHomePage;

    public int checkUpdateSearchNameValid(String name) {
        int count = 0;

        if(name.isEmpty()) {
            return 1; // update search name is empty
            // updateTextMessage.setText("Please enter required details.");
        } else{
            if((!name.matches("^[a-zA-Z]+$"))) {
                return 2; // invalid update search name
            } else {
                for (int i=0; i<AddController.mainRecord.size(); i++) {
                    if(name.equals(AddController.mainRecord.get(i).get(0))) {
                        count++; // if update search name exist -> counter=1
                    }
                }

                if(count!=1) { // update search name doesn't exist
                    return 3;
                }
            }

            return 0; // all good
        }
    }

    public int checkUpdateSearchDataValid(String data) {
        if(data.isEmpty()) {
            return 1; // update search data is empty
        } else if(!(data.equals("Name") || data.equals("Age") || data.equals("Car") || data.equals("Team") || data.equals("Current points"))) {
            return 2; // invalid update search data
        } else {
            return 0;
        }
    }

    private void checkSearch() {
        String name = updateSearchName.getText();
        String data = updateSearchData.getText();

        switch (checkUpdateSearchNameValid(name)) {
            case 1:
                updateSearchName.setText("Enter the driver's name that you want to update.");
                break;
            case 2:
                updateSearchName.setText("Invalid driver name.");
                break;
            case 3:
                updateSearchName.setText("Driver name doesn't exist.");
                break;
            case 0:
                break;
            default:
                updateTextMessage.setText(" ");
        }

        switch (checkUpdateSearchDataValid(data)) {
            case 1:
                updateSearchData.setText("Enter want you want to update");
                break;
            case 2:
                updateSearchData.setText("Invalid data type.");
                break;
            case 0:
                break;
            default:
                updateTextMessage.setText(" ");
        }


        if((!updateSearchName.getText().equals("Enter the driver's name that you want to update.")) && (!updateSearchName.getText().equals("Invalid driver name.")) && (!updateSearchName.getText().equals("Driver name doesn't exist."))
                && (!updateSearchData.getText().equals("Enter want you want to update")) && (!updateSearchData.getText().equals("Invalid data type."))) {
            switch(updateSearchData.getText()) {
                case "Name":
                    UpdateDataName.setText("Enter new name                 : ");
                    break;
                case "Age":
                    UpdateDataName.setText("Enter new age                  : ");
                    break;
                case "Car":
                    UpdateDataName.setText("Enter new car                  : ");
                    break;
                case "Team":
                    UpdateDataName.setText("Enter new team                 : ");
                    break;
                case "Current points":
                    UpdateDataName.setText("Enter new current points       : ");
                    break;
                default:
                    System.out.println(" ");
            }
        }
    }


    public int updatedValueValid(String data, String value) {
        int count = 0;

        if(value.isEmpty()) {
            return 1; // updated value is empty
        } else {
            if(data.equals("Name")) {
                if(!value.matches("^[a-zA-Z]+$")) {
                    return 2; // invalid name -> updated value
                } else {
                    for (int i=0; i<AddController.mainRecord.size(); i++) {
                        if(value.equals(AddController.mainRecord.get(i).get(0))) {
                            count++; // if duplicate name -> updated value -> counter=1
                        }
                    }

                    if(count==1) { // duplicate name
                        return 3;
                    } else {
                        return 0; // updated value -> name - all good
                    }
                }
            }

            if(data.equals("Age")) {
                if((!value.toString().matches("^[0-9]+$"))) {
                    return 4; // if updated value, age is invalid
                } else {
                    return 0; // updated value -> age - all good
                }
            }

            if(data.equals("Current points")) {
                if((!value.toString().matches("^[0-9]+$"))) {
                    return 5; // if updated value, current points is invalid
                } else {
                    return 0; // updated value -> current points - all good
                }
            }

            return 0; // updated value -> car, team - all good
        }
    }

    private void checkUpdate() {
        String data = updateSearchData.getText();
        String value = updatedValue.getText();

        switch (updatedValueValid(data, value)) {
            case 1:
                updatedValue.setText("Enter the new value.");
                break;
            case 2:
                updatedValue.setText("Invalid driver name.");
                break;
            case 3:
                updatedValue.setText("This driver name has already taken.");
                break;
            case 4:
                updatedValue.setText("Invalid age.");
                break;
            case 5:
                updatedValue.setText("Invalid current points.");
                break;
            case 0:
                break;
            default:
                updateTextMessage.setText(" ");
        }

        if(!(updatedValue.getText().equals("Enter the new value.")) && !(updatedValue.getText().equals("Invalid driver name.")) && !(updatedValue.getText().equals("This driver name has already taken."))
                && !(updatedValue.getText().equals("Invalid age.")) && !(updatedValue.getText().equals("Invalid current points."))) {
            for(int i=0; i<AddController.mainRecord.size(); i++) {
                if(updateSearchName.getText().equals(AddController.mainRecord.get(i).get(0))) {
                    if(data.equals("Name")) {
                        AddController.mainRecord.get(i).set(0, value);
                    } else if(data.equals("Age")) {
                        AddController.mainRecord.get(i).set(1, value);
                    }  else if(data.equals("Car")) {
                        AddController.mainRecord.get(i).set(2, value);
                    }  else if(data.equals("Team")) {
                        AddController.mainRecord.get(i).set(3, value);
                    }  else if(data.equals("Current points")) {
                        AddController.mainRecord.get(i).set(4, value);
                    }
                }
            }

            System.out.println(AddController.mainRecord);
            updateTextMessage.setText("Driver details successfully updated !!!");
        }
    }


    public void searchButtonOnClick() {
        checkSearch();
    }

    public void updateOnClick() {
        checkUpdate();
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
