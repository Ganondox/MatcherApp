package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeleteController {

    @FXML
    private Button deleteYesButton;

    @FXML
    private Button deleteNoButton;

    @FXML
    void deleteProfile(MouseEvent event) {
        //delete profile
        //make request
        String requestBody = Main.client.key + "#" + Main.client.workingUser.username + "#" + Main.client.workingUser.password + "#";
        while(requestBody.length() % 245 != 0){
            requestBody += '0';
        }

        //encrypt message
        byte[] encrypted = null;
        try {
            encrypted =  HandlerSupporter.cipherTrans(true,  Main.client.pub2, requestBody.getBytes("UTF-8"));
        } catch (Exception e) {
        }

        //send request
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8001/Delete" )).POST(HttpRequest.BodyPublishers.ofByteArray(encrypted)).build();
        HttpResponse<InputStream> response = null;
        try {
            response = Main.client.client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        } catch (Exception e){

        }

        //change scene
        deleteYesButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Home.fxml"));
        try {
            loader.load();
        } catch (Exception e){
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 500, 275));
        stage.show();
    }

    @FXML
    void toBase(MouseEvent event) {
        //change scene
        deleteNoButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Base.fxml"));
        try {
            loader.load();
        } catch (Exception e){
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 500, 275));
        stage.show();
    }

}
