package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.*;
import java.security.spec.RSAPublicKeySpec;

public class HomeController {

    @FXML
    private Button homeBegin;

    @FXML
    void beginMatch(MouseEvent event) {


        //generate key

        KeyPair kpg = null;
        try {
            kpg = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        } catch (Exception e){


        }

        Main.client.pri  = kpg.getPrivate();
        PublicKey pub = kpg.getPublic();


        Main.client.key = reformatKey(pub.toString());

        //make request
        String requestBody = Main.client.key + "#" + "bob#jones#Bob Jones is a god among mortal men#Y#1@2@3@4@5&1@2@3@4@5#Y" + "#";

        while(requestBody.length() % 245 != 0){
            requestBody += '0';
        }

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8001/Home")).GET().build();
        Main.client.client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();

        HttpResponse<String> response = null;
        try {
            response = Main.client.client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
        }
        System.out.println(response.toString());
        System.out.println(response.body());


        //save key
        String[] parameters = reformatKey(response.body()).split("#");
        BigInteger modulus = new BigInteger(parameters[0]);
        BigInteger exponent = new BigInteger(parameters[1]);


        RSAPublicKeySpec spec = new RSAPublicKeySpec(modulus, exponent);

        try {
            KeyFactory factory = KeyFactory.getInstance("RSA");
            Main.client.pub2 = factory.generatePublic(spec);
        } catch (Exception e) {
        }



        //change scene
        homeBegin.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Login.fxml"));
        try {
            loader.load();
        } catch (Exception e){
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 500, 275));
        stage.show();

        System.out.println("Test");



    }


    public static String reformatKey(String key){
        String[] parameters = key.split(":");
        String modulus = parameters[2].split("\n")[0].trim();
        //System.out.println(modulus);
        String exponent = parameters[3].trim();
        //System.out.println(exponent);
        return modulus +"#"+ exponent;
    }
}


