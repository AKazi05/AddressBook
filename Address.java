
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



/********** AddressClass ***********/
 class Address {
    private String name;
    private String street;
    private String city;
    private String state;
    private int zip;

    public Address() {
        this("", "", "", "", 0);
    }

    public Address(String name, String street, String city, String state, int zip) {
        this.setName(name);
        this.setStreet(street);
        this.setCity(city);
        this.setState(state);
        this.setZip(zip);
    }
    
    // Getter and setter functions
    
    // For Name
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // For Street
    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    // For City
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    // For State
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // For Zip
    public int getZip() {
        return this.zip;
    }

    public void setZip(int zip) {
        this.zip = zip > 0 ? zip : 0;
    }
}