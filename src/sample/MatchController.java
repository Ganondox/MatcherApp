package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MatchController {

    @FXML
    private Label matchLabel;

    @FXML
    private Button matchButtonRefresh;

    @FXML
    private Button matchLeaveButton;

    @FXML
    void refresh(MouseEvent event) {
        //change scene
        matchButtonRefresh.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Match.fxml"));
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
        matchLeaveButton.getScene().getWindow().hide();
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

    @FXML
    public void initialize() {

        //form request body
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

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8001/Match")).POST(HttpRequest.BodyPublishers.ofByteArray(encrypted)).build();
        HttpResponse<InputStream> response = null;
        try {
            response = Main.client.client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        } catch (Exception e){

        }
        String message = HandlerSupporter.decryptStream(response.body(), Main.client.pri);

        String matches = message;
        matchLabel.setText(matches);
    }

}
