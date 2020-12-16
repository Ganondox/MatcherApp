package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questions2BController {

    @FXML
    private Slider q2bS1;

    @FXML
    private Slider q2bS2;

    @FXML
    private Slider q2bS3;

    @FXML
    private Slider q2bS4;

    @FXML
    private Slider q2bS5;

    @FXML
    private Button q2bButton;

    @FXML
    void toQ3(MouseEvent event) {
        //update working user
        Main.client.workingUser.profile.aptitude[0] = q2bS1.getValue();
        Main.client.workingUser.profile.aptitude[1] = q2bS2.getValue();
        Main.client.workingUser.profile.aptitude[2] = q2bS3.getValue();
        Main.client.workingUser.profile.aptitude[3] = q2bS4.getValue();
        Main.client.workingUser.profile.aptitude[4] = q2bS5.getValue();

        //change scene
        q2bButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Questions3B.fxml"));
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
