package com.example._2236742;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RaceTableController implements Initializable {
    @FXML
    private Button buttonHomePage;

    @FXML
    private Button buttonViewRacTable;

    @FXML
    private TableView<RaceTable> raceTable;

    @FXML
    private TableColumn<RaceTable, String> RTLocation;

    @FXML
    private TableColumn<RaceTable, String> RTDate;


    ObservableList<RaceTable> list = FXCollections.observableArrayList();


    public static ArrayList<List> bubbleSort(ArrayList<List> arrayList) {
        for (int i = 0; i<arrayList.size()-1; i++) {
            for (int j=0; j<arrayList.size()-i-1; j++) {
                String[] splitArray1 = ((String) arrayList.get(j).get(0)).split("-"); // j
                String[] splitArray2 = ((String) arrayList.get(j+1).get(0)).split("-"); // j+1

                int current = Integer.parseInt(splitArray1[2]);
                int next = Integer.parseInt(splitArray2[2]);

                if (current > next) {
                    // swap current and next
                    Object temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j+1));
                    arrayList.set(j + 1, (ArrayList) temp);
                }
            }
        }

        return arrayList;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RTDate.setCellValueFactory(new PropertyValueFactory<RaceTable, String>("Date"));
        RTLocation.setCellValueFactory(new PropertyValueFactory<RaceTable, String>("Location"));

        bubbleSort(RandomRaceController.raceDetails);

        for(int i=0; i<RandomRaceController.raceDetails.size(); i++) {
            String date = (String) RandomRaceController.raceDetails.get(i).get(0);
            String location = (String) RandomRaceController.raceDetails.get(i).get(1);

            RaceTable raceTable = new RaceTable(date, location);
            list.add(raceTable);
        }
    }


    public void buttonViewRaceTable(ActionEvent actionEvent) {
        raceTable.setItems(list);
    }

    public void viewRaceTableButtonOnClick(ActionEvent actionEvent) {
        buttonViewRaceTable(actionEvent);
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
