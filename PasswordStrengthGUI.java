package com.example.passwordstrength;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class PasswordStrengthGUI extends Application {
    //creates and initializes text boxes and buttons
    static TextField tfPassword = new TextField();
    static TextField tfStrength = new TextField();
    static Button btCalculateStrength = new Button("Calculate Strength");
    static CheckBox checkbox = new CheckBox("Hide/Show");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //creates the pane where all the information will be presented
        GridPane gridPane = new GridPane();

        //sets the gap between columns
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        //positions the text boxes and buttons
        gridPane.add(new Label("Password: "), 0, 0);
        gridPane.add(tfPassword, 1, 0);
        gridPane.add(new Label("Strength: "), 0, 1);
        gridPane.add(tfStrength, 1, 1);
        gridPane.add(btCalculateStrength, 1, 2);
        gridPane.add(checkbox, 0, 2);

        //aligns the textboxes
        gridPane.setAlignment(Pos.CENTER);
        tfPassword.setAlignment(Pos.CENTER_LEFT);
        tfStrength.setAlignment(Pos.CENTER_LEFT);
        //doesn't allow the user to change the information in the strength text box
        tfStrength.setEditable(false);
        //horizontally aligns the button and checkbox
        GridPane.setHalignment(btCalculateStrength, HPos.RIGHT);
        GridPane.setHalignment(checkbox, HPos.RIGHT);

        //changes the style of the calculate strength button
        Font buttonFont = Font.font("Courier New", FontWeight.BOLD, 15);
        btCalculateStrength.setFont(buttonFont);
        btCalculateStrength.setStyle("-fx-background-color: #ff1111; ");

        //calculate strength button
        btCalculateStrength.setOnAction(
                e -> {
                    //when the button is clicked calculate the strength of the password
                    calculateStrength();
                    //repeats the password the user entered
                    System.out.println("The password you entered is " + PasswordStrengthGUI.tfPassword.getText());
                });

        checkbox.setOnAction(
                e -> {
                    if(checkbox.isSelected()){
                        String password = tfPassword.getText();
                        Hide hide1 = new Hide();
                        tfPassword.setText(String.format(hide1.hiddenPassword(password)));
                    }
                    if(!checkbox.isSelected()){
                        String password = tfPassword.getText();
                        tfPassword.setText(password);
                    }
                });



        //creates the scene for the grid pane
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("Password Strength Checker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //calls the method that corresponds to the button above
    private void calculateStrength() {
        String password = tfPassword.getText();
        Strength strength1 = new Strength();
        tfStrength.setText(String.format(strength1.getStrength(password)));
    }
}