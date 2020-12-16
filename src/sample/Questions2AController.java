package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questions2AController {

    @FXML
    private Slider q2aS1;

    @FXML
    private Slider q2aS2;

    @FXML
    private Slider q2aS3;

    @FXML
    private Slider q2aS4;

    @FXML
    private Slider q2aS5;

    @FXML
    private Button q2aButton;

    @FXML
    void toQ3(MouseEvent event) {

        //update working user
        Main.client.workingUser.profile.aptitude[0] = q2aS1.getValue();
        Main.client.workingUser.profile.aptitude[1] = q2aS2.getValue();
        Main.client.workingUser.profile.aptitude[2] = q2aS3.getValue();
        Main.client.workingUser.profile.aptitude[3] = q2aS4.getValue();
        Main.client.workingUser.profile.aptitude[4] = q2aS5.getValue();


        //change scene
        q2aButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Questions3A.fxml"));
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
