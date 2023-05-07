package com.example._2236742;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WorldRallyCrossChampionshipApplication extends Application {
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        primaryStage.setTitle("World Rally Cross Championship");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();

        RandomRaceDetailsFile.createFile();
        WorldRallyCrossChampionshipDataFile.createFile();
    }
}