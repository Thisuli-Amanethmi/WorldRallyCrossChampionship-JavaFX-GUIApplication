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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class RandomRaceController implements Initializable {
    @FXML
    private Button buttonHomePage;

    @FXML
    private Button buttonViewRaceDetails;

    @FXML
    private TextField randomRaceDate;

    @FXML
    private TextField randomRaceLocation;

    @FXML
    private TableView randomRaceTable;

    @FXML
    private TableColumn<RandomRaceTable, String> columnRRName;

    @FXML
    private TableColumn<RandomRaceTable, Integer> columnRRPoints;

    @FXML
    private TableColumn<RandomRaceTable, Integer> columnRRPosition;

    static ArrayList<List> raceDetails = new ArrayList<>(); // {{date, location}, {date, location}, {date, location}}
    List<String> raceDateLocation = new ArrayList<>(); // {date, location}

    public static String dateGenerator() {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};

        List<Integer> days31 = new ArrayList<>();
        for (int i=0; i<=30; i++) {
            days31.add(numbers[i]);
        }

        List<Integer> days30 = new ArrayList<>();
        for (int i=0; i<=29; i++) {
            days30.add(numbers[i]);
        }

        List<Integer> days29 = new ArrayList<>();
        for (int i=0; i<=28; i++) {
            days29.add(numbers[i]);
        }

        List<Integer> days28 = new ArrayList<>();
        for (int i=0; i<=27; i++) {
            days28.add(numbers[i]);
        }

        LocalDate date = LocalDate.now();
        int year = date.getYear();
        Month month = date.getMonth();
        int day = 1;

        Random random = new Random();

        if(month.toString().equals("JANUARY") || month.toString().equals("MARCH") || month.toString().equals("MAY") || month.toString().equals("JULY") ||
                month.toString().equals("AUGUST") || month.toString().equals("OCTOBER")|| month.toString().equals("DECEMBER")) {
            int randomInt = random.nextInt(30);
            day = days31.get(randomInt);
            days31.remove(randomInt);

        } else if(month.toString().equals("APRIL") || month.toString().equals("JUNE") || month.toString().equals("SEPTEMBER") || month.toString().equals("NOVEMBER")) {
            int randomInt = random.nextInt(29);
            day = days30.get(randomInt);
            days30.remove(randomInt);
        } else if (month.toString().equals("FEBRUARY")) {
            if(year%4 == 0) {
                int randomInt = random.nextInt(28);
                day = days29.get(randomInt);
                days29.remove(randomInt);
            } else {
                int randomInt = random.nextInt(27);
                day = days28.get(randomInt);
                days28.remove(randomInt);
            }
        }

        String yearStr = Integer.toString(year);
        String monthStr = month.toString();
        String dayStr = Integer.toString(day);

        return (yearStr + "-" + monthStr + "-" + dayStr);
    }

    public static String RandomValue(String[] array) {
        int num = new Random().nextInt(array.length);
        return array[num];
    }

    String[] raceLocation = {"Nyirad", "Holjes", "Montalegre", "Barcelona", "Riga", "Norway"};
    String location = RandomValue(raceLocation);


    List<String> DriversList = new ArrayList<>();
    List<String> DriversListCopy = new ArrayList<>();

    public static String RandomValueDriverName(List<String> list) {
        int num = new Random().nextInt(list.size());
        String driverName = list.get(num);
        list.remove(num);
        return driverName;
    }

    ObservableList<RandomRaceTable> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnRRPosition.setCellValueFactory(new PropertyValueFactory<RandomRaceTable, Integer>("Position"));
        columnRRName.setCellValueFactory(new PropertyValueFactory<RandomRaceTable, String >("Name"));
        columnRRPoints.setCellValueFactory(new PropertyValueFactory<RandomRaceTable, Integer>("Points"));

        for(int i=0; i<AddController.mainRecord.size(); i++) {
            DriversList.add((String) AddController.mainRecord.get(i).get(0));
        }
        System.out.println("DRIVERS" + DriversList);


        for(int i=0; i<DriversList.size(); i++) {
            DriversListCopy.add(DriversList.get(i));
        }
        System.out.println("DRIVERS COPY" + DriversListCopy);

        int points = 0;

        for(int i=0; i<DriversListCopy.size(); i++){
            int position = i + 1;
            String name = RandomValueDriverName(DriversList);

            if(i==0) {
                points = 10;

                for(int k=0; k<AddController.mainRecord.size(); k++) {
                    if(name.equals(AddController.mainRecord.get(k).get(0))) {
                        AddController.mainRecord.get(k).set(4, (Integer.parseInt((String) AddController.mainRecord.get(k).get(4)) + points));
                        AddController.mainRecord.get(k).set(4, (AddController.mainRecord.get(k).get(4).toString()));
                        System.out.println(AddController.mainRecord);
                    }
                }
            } else if(i==1) {
                points = 7;

                for(int k=0; k<AddController.mainRecord.size(); k++) {
                    if(name.equals(AddController.mainRecord.get(k).get(0))) {
                        AddController.mainRecord.get(k).set(4, (Integer.parseInt((String) AddController.mainRecord.get(k).get(4)) + points));
                        AddController.mainRecord.get(k).set(4, (AddController.mainRecord.get(k).get(4).toString()));
                        System.out.println(AddController.mainRecord);
                    }
                }
            } else if(i==2) {
                points = 5;

                for(int k=0; k<AddController.mainRecord.size(); k++) {
                    if(name.equals(AddController.mainRecord.get(k).get(0))) {
                        AddController.mainRecord.get(k).set(4, (Integer.parseInt((String) AddController.mainRecord.get(k).get(4)) + points));
                        AddController.mainRecord.get(k).set(4, (AddController.mainRecord.get(k).get(4).toString()));
                        System.out.println(AddController.mainRecord);
                    }
                }
            } else {
                points = 0;
            }

            RandomRaceTable randomRaceTable = new RandomRaceTable(position, name, points);
            list.add(randomRaceTable);
        }
    }

    public void WriteFile() throws IOException {
        // https://www.java67.com/2015/07/how-to-append-text-to-existing-file-in-java-example.html
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("RandomRaceDetails.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println("Race Date : " + date);
            pw.println("Race Location : " + location);
            pw.println();
            pw.format(String.format("%20s %20s %20s", "Position", "Driver's Name", "Points"));
            pw.println();

            for (int i=0; i<list.size(); i++) {
                pw.format(String.format("%20s %20s %20s",list.get(i).getPosition(), list.get(i).getName(), list.get(i).getPoints()));
                pw.println();
            }

            pw.println();
            pw.println();
            pw.println("------------------------------------------------------------------------------------------------");
            pw.println();
            pw.println();

            System.out.println("Data Successfully appended into file");
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

    String date;
    public void viewRaceDetailsTable(ActionEvent actionEvent) throws IOException {
        date = dateGenerator();
        randomRaceDate.setText(date);
        randomRaceLocation.setText(location);
        randomRaceTable.setItems(list);

        WriteFile();

        raceDateLocation.add(date);
        raceDateLocation.add(location);
        raceDetails.add(raceDateLocation);
    }

    public void viewRacDetailsButtonOnClick(ActionEvent actionEvent) throws IOException {
        viewRaceDetailsTable(actionEvent);
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
