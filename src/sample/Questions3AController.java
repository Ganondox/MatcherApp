package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Questions3AController {

    @FXML
    private Slider q3aS1;

    @FXML
    private Slider q3aS2;

    @FXML
    private Slider q3aS3;

    @FXML
    private Slider q3aS4;

    @FXML
    private Slider q3aS5;

    @FXML
    private Button q3aButton;

    @FXML
    void toBase(MouseEvent event) {

        //update working user
        Main.client.workingUser.profile.interests[0] = q3aS1.getValue();
        Main.client.workingUser.profile.interests[1] = q3aS2.getValue();
        Main.client.workingUser.profile.interests[2] = q3aS3.getValue();
        Main.client.workingUser.profile.interests[3] = q3aS4.getValue();
        Main.client.workingUser.profile.interests[4] = q3aS5.getValue();

        Main.client.workingUser.isCompleted = true;

        //make request
        String requestBody = Main.client.key + "#" + UserRecord.recordToString(Main.client.workingUser) + "#";
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
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8001/Update" )).POST(HttpRequest.BodyPublishers.ofByteArray(encrypted)).build();
        HttpResponse<InputStream> response = null;
        try {
            response = Main.client.client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        } catch (Exception e){

        }


        //change scene
        q3aButton.getScene().getWindow().hide();
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
