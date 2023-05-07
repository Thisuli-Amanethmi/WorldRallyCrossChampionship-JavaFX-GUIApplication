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

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class DeleteController {
    public DeleteController() {

    }

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonHomePage;

    @FXML
    private TextField deleteSearchName;

    @FXML
    private Label deleteTextMessage;


    public int checkDeleteSearchName(String name) {
        int count = 0;

        if(name.isEmpty()) {
            return 1; // delete search name is empty
        } else {
            if((!name.matches("^[a-zA-Z]+$"))) {
                return 2; // invalid delete search name
            } else {
                for (int i=0; i<AddController.mainRecord.size(); i++) {
                    if(name.equals(AddController.mainRecord.get(i).get(0))) {
                        count++; // if delete search driver name exist -> counter=1
                    }
                }

                if(count!=1) { // delete search name doesn't exist
                    return 3;
                }
            }

            return 0; // all good
        }
    }

    private void checkDelete() {
       String name = deleteSearchName.getText();

       switch (checkDeleteSearchName(name)) {
           case 1:
               deleteSearchName.setText("Enter the driver's name that you want to delete.");
               break;
           case 2:
               deleteSearchName.setText("Invalid driver name.");
               break;
           case 3:
               deleteSearchName.setText("Driver name doesn't exist.");
               break;
           case 0:
               break;
           default:
               deleteTextMessage.setText(" ");
       }


        if(!(deleteSearchName.getText().equals("Enter the driver's name that you want to delete.")) && !(deleteSearchName.getText().equals("Invalid driver name.")) && !(deleteSearchName.getText().equals("Driver name doesn't exist."))) {
            for(int i=0; i<AddController.mainRecord.size(); i++) {
                if(deleteSearchName.getText().equals(AddController.mainRecord.get(i).get(0))) {
                    AddController.mainRecord.remove(i);

                    System.out.println(AddController.mainRecord);

                    deleteTextMessage.setText("Driver details successfully deleted !!!");
                }
            }
        }
    }

    public void deleteOnClick() {
        checkDelete();
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
