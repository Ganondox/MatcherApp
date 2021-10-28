package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questions1Controller {

    //@FXML
    //private CheckBox q1CheckBox;

    @FXML
    private TextArea q1Description;

    @FXML
    private Button q1Button;

    @FXML
    void toQ2(MouseEvent event) {

        System.out.println("Clicked");

        //update working user
        Main.client.workingUser.description = q1Description.getText();
       // Main.client.workingUser.isEmployer = q1CheckBox.isSelected();


        System.out.println("Change");
        //change scene
        q1Button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        //if(q1CheckBox.isSelected()) loader.setLocation(getClass().getResource("Questions2A.fxml")); else loader.setLocation(getClass().getResource("Questions2B.fxml"));
        loader.setLocation(getClass().getResource("Questions1To10.fxml"));
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
