package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LoginController {

    @FXML
    private TextField loginPassword;

    @FXML
    private Button loginLoginButton;

    @FXML
    private Button loginRegisterButton;

    @FXML
    private TextField loginUsername;

    @FXML
    void login(MouseEvent event) {
        connect(true);
    }

    @FXML
    void register(MouseEvent event) {
        if(!loginUsername.getText().equals(""))
        connect(false);
    }

    void connect(boolean login){


        //form request body
        String requestBody = Main.client.key + "#" + loginUsername.getText() + "#" + loginPassword.getText() + "#";
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
        String tag = "Register";
        if(login) tag = "Login";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8001/" + tag)).POST(HttpRequest.BodyPublishers.ofByteArray(encrypted)).build();
        HttpResponse<InputStream> response = null;
        try {
            response = Main.client.client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        } catch (Exception e){

        }
        String message = HandlerSupporter.decryptStream(response.body(), Main.client.pri);
        if(response.statusCode() == 200){

            if(!message.trim().equals("Username is already taken") && !message.trim().equals("Password is incorrect.") &&  !message.trim().equals("Username is not registered") ){
                if(login) Main.client.workingUser = UserRecord.stringToRecord(message);
                else Main.client.workingUser = new UserRecord(loginUsername.getText(), loginPassword.getText(), "", false, new ProfileVector(), false);


                //change scene
                if(login) loginLoginButton.getScene().getWindow().hide(); else loginRegisterButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                if(Main.client.workingUser.isCompleted) loader.setLocation(getClass().getResource("Base.fxml")); else loader.setLocation(getClass().getResource("Questions1.fxml"));
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
        System.out.println(message + ":" + response.statusCode());

    }

}
