


import java.io.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Address_Book extends Application {
    AddressFile aFile;
    
    // Create TextField
    private TextField tName = new TextField();
    private TextField tStreet = new TextField();
    private TextField tCity = new TextField();
    private TextField tState = new TextField();
    private TextField tZip = new TextField();
    
    // Create different Buttons
    private Button bAdd = new Button("Add");
    private Button bFirst = new Button("First");
    private Button bNext = new Button("Next");
    private Button bPrevious = new Button("Previous");
    private Button bLast = new Button("Last");
    private Button bUpdate = new Button("Update");

    public Address_Book() {
        try {
            this.aFile = new AddressFile();
        } catch (IOException var2) {
            var2.printStackTrace(System.out);
            System.exit(1);
        }

    }

    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5.0D);
        pane.setVgap(5.0D);
        
        // Setting the label 
        pane.add(new Label("Name"), 0, 0);
        pane.add(new Label("Street"), 0, 1);
        pane.add(new Label("City"), 0, 2);
        pane.add(new Label("State"), 0, 3);
        pane.add(new Label("Zip"), 0, 4);
        
        // Adding them in order
        pane.add(this.tName, 1, 0);
        pane.add(this.tStreet, 1, 1);
        pane.add(this.tCity, 1, 2);
        pane.add(this.tState, 1, 3);
        pane.add(this.tZip, 1, 4);
        
        HBox box = new HBox(5.0D);
        box.getChildren().addAll(new Node[]{this.bAdd, this.bFirst, this.bNext, this.bPrevious, this.bLast, this.bUpdate});
        box.setAlignment(Pos.CENTER);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(box);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 440.0D, 200.0D);
        primaryStage.setTitle("Exercise 17_09  ");
        primaryStage.setScene(scene);
        primaryStage.show();
        Address ad = this.aFile.firstAddress();
        if (ad != null) {
            this.setDisplay(ad);
        }
        
        // Create and register handlers
        this.bAdd.setOnAction((e) -> {
            Address address = this.getDisplay();
            this.aFile.addAddress(address);
        });
        
        this.bFirst.setOnAction((e) -> {
            Address address = this.aFile.firstAddress();
            if (address != null) {
                this.setDisplay(address);
            }

        });
        
        
        this.bNext.setOnAction((e) -> {
            Address address = this.aFile.readAddress();
            if (address != null) {
                this.setDisplay(address);
            }

        });
        
        this.bLast.setOnAction((e) -> {
            Address address = this.aFile.lastAddress();
            if (address != null) {
                this.setDisplay(address);
            }

        });
        
        this.bUpdate.setOnAction((e) -> {
            Address address = this.getDisplay();
            this.aFile.writeAddress(address);
        });
    }

    // Setting the Display
    private void setDisplay(Address ad) {
        this.tName.setText(ad.getName());
        this.tStreet.setText(ad.getStreet());
        this.tCity.setText(ad.getCity());
        this.tState.setText(ad.getState());
        this.tZip.setText(String.format("%d", ad.getZip()));
    }

    private Address getDisplay() {
        Address ad = new Address();
        ad.setName(this.tName.getText());
        ad.setStreet(this.tStreet.getText());
        ad.setCity(this.tCity.getText());
        ad.setState(this.tState.getText());
        int zip = Integer.parseInt(this.tZip.getText());
        ad.setZip(zip);
        return ad;
    }
    
    // main method
    public static void main(String[] args) {
        launch(args);
    }
}
