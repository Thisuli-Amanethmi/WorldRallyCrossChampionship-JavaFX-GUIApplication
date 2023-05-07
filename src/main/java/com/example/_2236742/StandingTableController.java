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
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;

public class StandingTableController implements Initializable {
    @FXML
    private Button buttonHomePage;

    @FXML
    private Button buttonViewTable;

    @FXML
    private TableView<StandingTable> standingTable;

    @FXML
    private TableColumn<StandingTable, String> columnName;

    @FXML
    private TableColumn<StandingTable, Integer> columnAge;

    @FXML
    private TableColumn<StandingTable, String> columnCar;

    @FXML
    private TableColumn<StandingTable, String> columnTeam;

    @FXML
    private TableColumn<StandingTable, Integer> columnCurrentPoints;


    ObservableList<StandingTable> list = FXCollections.observableArrayList();

    public static ArrayList<ArrayList> bubbleSort(ArrayList<ArrayList> arrayList) {
        for (int i = 0; i<arrayList.size()-1; i++) {
            for (int j=0; j<arrayList.size()-i-1; j++) {
                int current = Integer.parseInt((String) arrayList.get(j).get(4));
                int next = Integer.parseInt((String) arrayList.get(j+1).get(4));

                if (current < next) {
                    // swap current and next
                    Object temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j+1));
                    arrayList.set(j + 1, (ArrayList) temp);
                }
            }
        }

        return arrayList;
    }

    ArrayList<ArrayList> mainRecordCopy = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // referred to : https://youtu.be/fnU1AlyuguE
        columnName.setCellValueFactory(new PropertyValueFactory<StandingTable, String >("Name"));
        columnAge.setCellValueFactory(new PropertyValueFactory<StandingTable, Integer>("Age"));
        columnCar.setCellValueFactory(new PropertyValueFactory<StandingTable, String >("Car"));
        columnTeam.setCellValueFactory(new PropertyValueFactory<StandingTable, String >("Team"));
        columnCurrentPoints.setCellValueFactory(new PropertyValueFactory<StandingTable, Integer>("CurrentPoints"));


        for(int i=0; i<AddController.mainRecord.size(); i++) {
            mainRecordCopy.add(AddController.mainRecord.get(i));
        }
        System.out.println("COPY" + mainRecordCopy);

        bubbleSort(mainRecordCopy);

        System.out.println("COPY - AFTER BUBBLE SORT" + mainRecordCopy);

        for(int i=0; i<mainRecordCopy.size(); i++) {
            String name = mainRecordCopy.get(i).get(0).toString();
            String ageStr = mainRecordCopy.get(i).get(1).toString();
            int age = Integer.parseInt(ageStr);
            String car = mainRecordCopy.get(i).get(2).toString();
            String team = mainRecordCopy.get(i).get(3).toString();
            String currentPointsStr = mainRecordCopy.get(i).get(4).toString();
            int currentPoints = Integer.parseInt(currentPointsStr);

            StandingTable standingTable = new StandingTable(name, age, car, team, currentPoints);
            list.add(standingTable);
        }
    }



    public void viewHomeTable(ActionEvent actionEvent) {
        standingTable.setItems(list);
    }

    public void viewTableButtonOnClick(ActionEvent actionEvent) {
        viewHomeTable(actionEvent);
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
