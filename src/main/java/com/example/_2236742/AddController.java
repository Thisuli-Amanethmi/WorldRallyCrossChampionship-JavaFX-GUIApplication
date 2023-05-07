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

import java.util.ArrayList;

public class AddController {
    public AddController() {

    }


    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonHomePage;

    @FXML
    private TextField addName;

    @FXML
    private TextField addAge;

    @FXML
    private TextField addCar;

    @FXML
    private TextField addTeam;

    @FXML
    private TextField addCurrentPoints;

    @FXML
    private Label addTextMessage;

    public static ArrayList<ArrayList> mainRecord = new ArrayList();

    ArrayList record = new ArrayList();
    // For each and every driver, there will be an individual, unique record (list).


    public int checkAddNameValid(String name) {
        int count = 0;

        if(name.isEmpty()) {
            return 1; // name is empty
        } else {
            if((!name.matches("^[a-zA-Z]+$"))) {
                return 2; // if name is invalid
            } else {
                for (int i=0; i<mainRecord.size(); i++) {
                    if(name.equals(mainRecord.get(i).get(0))) {
                        count++; // if add driver name exist -> counter=1
                    }
                }
                if(count==1) {
                    return 3; // name valid BUT duplicate driver name
                }
            }

            return 0; // all good
        }
    }

    public int checkAddAgeValid(String age) {
        if(age.isEmpty()) {
            return 1; // age is empty
        } else if((!age.toString().matches("^[0-9]+$"))) {
                return 2; // if age is invalid
        } else {
            return 0; // all good
        }
    }

    public int checkAddCurrentPointsValid(String currentPoints) {
        if(currentPoints.isEmpty()) {
            return 1; // current points is empty
        } else if((!currentPoints.toString().matches("^[0-9]+$"))) {
            return 2; // if current points are invalid
        } else {
            return 0; // all good
        }
    }

    public int checkAddValid(String name, String age, String car, String team, String currentPoints) {
        if((name.isEmpty()) || (age.isEmpty()) || (car.isEmpty()) || (team.isEmpty()) || (currentPoints.isEmpty())) {
            return 1; // if anything is empty
        } else {
            return 0; // check once again
        }
    }


    private void checkAdd() {
        String name = addName.getText();
        String age = addAge.getText();
        String car = addCar.getText();
        String team = addTeam.getText();
        String currentPoints = addCurrentPoints.getText();

        switch (checkAddValid(name, age, car, team, currentPoints)) {
            case 1:
                addTextMessage.setText("Enter all required details.");
                break;
            case 0:
                break;
            default:
                addTextMessage.setText(" ");
        }

        switch (checkAddNameValid(name)) {
            case 1:
                addName.setText("Enter name.");
                break;
            case 2:
                addName.setText("Invalid name.");
                break;
            case 3:
                addName.setText("This driver name has already taken.");
                break;
            case 0:
                break;
            default:
                addTextMessage.setText(" ");
        }

        switch (checkAddAgeValid(age)) {
            case 1:
                addAge.setText("Enter age.");
                break;
            case 2:
                addAge.setText("Invalid age.");
                break;
            case 0:
                break;
            default:
                addTextMessage.setText(" ");
        }

        switch (checkAddCurrentPointsValid(currentPoints)) {
            case 1:
                addCurrentPoints.setText("Enter current points.");
                break;
            case 2:
                addCurrentPoints.setText("Invalid current points.");
                break;
            case 0:
                break;
            default:
                addTextMessage.setText(" ");
        }


        // after checking name, age, current points

        if((addTextMessage.getText().equals("Enter all required details.")) || (addName.getText().equals("Enter name.")) || (addName.getText().equals("Invalid name."))
                || (addName.getText().equals("This driver name has already taken.")) || (addAge.getText().equals("Enter age.")) || (addAge.getText().equals("Invalid age."))
                || (addCurrentPoints.getText().equals("Enter current points.")) || (addCurrentPoints.getText().equals("Invalid current points."))) {
            addTextMessage.setText("Enter all required details.");
        } else {
            record.add(addName.getText());
            record.add(addAge.getText());
            record.add(addCar.getText());
            record.add(addTeam.getText());
            record.add(addCurrentPoints.getText());
            System.out.println(record);

            AddController.mainRecord.add(record);
            System.out.println(mainRecord);

            addTextMessage.setText("Driver details successfully added !!!");
        }
    }

    public void addOnClick(){
        checkAdd();
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
