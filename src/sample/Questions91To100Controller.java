package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Questions91To100Controller {


    @FXML
    private ToggleGroup Science ;
    @FXML
    private ToggleGroup  SociologyAndAnthropology; //2
    @FXML
    private ToggleGroup Speaking; //3
    @FXML
    private ToggleGroup SystemsAnalysis; //4
    @FXML
    private ToggleGroup TeachingAndCourseDesign; //5
    @FXML
    private ToggleGroup Telecommunications; //6
    @FXML
    private ToggleGroup TherapyAndCounseling; //7
    @FXML
    private ToggleGroup TimeManagement; //8
    @FXML
    private ToggleGroup Troubleshooting; //9
    @FXML
    private ToggleGroup Writing; //10


    @FXML
    private Button q91to100Button;

    @FXML
    void toBase(MouseEvent event) {



        //update working user

        Main.client.workingUser.profile.aptitude[UserRecord.SCIENCE] = Double.parseDouble((String) Science.getSelectedToggle().getUserData()) * 25;
        Main.client.workingUser.profile.aptitude[UserRecord.SPEAKING] = Double.parseDouble((String) Speaking.getSelectedToggle().getUserData()) * 25; //2
        Main.client.workingUser.profile.aptitude[UserRecord.SOCIOLOGY_AND_ANTHROPOLOGY] = Double.parseDouble((String) SociologyAndAnthropology.getSelectedToggle().getUserData()) * 25;//3
        Main.client.workingUser.profile.aptitude[UserRecord.SYSTEMS_ANALYSIS] = Double.parseDouble((String) SystemsAnalysis.getSelectedToggle().getUserData()) * 25;//4
        Main.client.workingUser.profile.aptitude[UserRecord.TEACHING_AND_COURSE_DESIGN] = Double.parseDouble((String) TeachingAndCourseDesign.getSelectedToggle().getUserData()) * 25;//5
        Main.client.workingUser.profile.aptitude[UserRecord.TELECOMMUNICATIONS] = Double.parseDouble((String) Telecommunications.getSelectedToggle().getUserData()) * 25;//6
        Main.client.workingUser.profile.aptitude[UserRecord.THERAPY_AND_COUNSELING] = Double.parseDouble((String) TherapyAndCounseling.getSelectedToggle().getUserData()) * 25; //7
        Main.client.workingUser.profile.aptitude[UserRecord.TIME_MANAGEMENT] = Double.parseDouble((String) TimeManagement.getSelectedToggle().getUserData()) * 25;//8
        Main.client.workingUser.profile.aptitude[UserRecord.TROUBLESHOOTING] = Double.parseDouble((String) Troubleshooting.getSelectedToggle().getUserData()) * 25;//9
        Main.client.workingUser.profile.aptitude[UserRecord.WRITING] = Double.parseDouble((String) Writing.getSelectedToggle().getUserData()) * 25;//10

        System.out.println(Main.client.workingUser.profile.aptitude[UserRecord.WRITING]);

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
        q91to100Button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Base.fxml"));
        try {
            loader.load();
        } catch (Exception e){
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 1000, 800));
        stage.show();


    }

}

