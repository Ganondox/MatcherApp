package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questions1To10Controller {


        @FXML
        private ToggleGroup Cabinets;
        @FXML
        private ToggleGroup Bricks; //2
        @FXML
        private ToggleGroup RepairAppliances; //3
        @FXML
        private ToggleGroup RaiseFish; //4
        @FXML
        private ToggleGroup AssembleElectronics; //5
        @FXML
        private ToggleGroup DriveTruck; //6
        @FXML
        private ToggleGroup TestParts; //7
        @FXML
        private ToggleGroup Locks; //8
        @FXML
        private ToggleGroup OperateMachines; //9
        @FXML
        private ToggleGroup FightFires; //10


        @FXML
        private Button q1to10Button;

        @FXML
        void toQ11to20(MouseEvent event) {



            //update working user
            Main.client.workingUser.profile.interests[UserRecord.REALISTIC] = 0;
            Main.client.workingUser.profile.interests[UserRecord.REALISTIC] += Double.parseDouble((String) Cabinets.getSelectedToggle().getUserData()) * 2.5;
            Main.client.workingUser.profile.interests[UserRecord.REALISTIC] += Double.parseDouble((String) Bricks.getSelectedToggle().getUserData()) * 2.5; //2
            Main.client.workingUser.profile.interests[UserRecord.REALISTIC] += Double.parseDouble((String) RepairAppliances.getSelectedToggle().getUserData()) * 2.5;//3
            Main.client.workingUser.profile.interests[UserRecord.REALISTIC] += Double.parseDouble((String) RaiseFish.getSelectedToggle().getUserData()) * 2.5;//4
            Main.client.workingUser.profile.interests[UserRecord.REALISTIC] += Double.parseDouble((String) AssembleElectronics.getSelectedToggle().getUserData()) * 2.5;//5
            Main.client.workingUser.profile.interests[UserRecord.REALISTIC] += Double.parseDouble((String) DriveTruck.getSelectedToggle().getUserData()) * 2.5;//6
            Main.client.workingUser.profile.interests[UserRecord.REALISTIC] += Double.parseDouble((String) TestParts.getSelectedToggle().getUserData()) * 2.5; //7
            Main.client.workingUser.profile.interests[UserRecord.REALISTIC] += Double.parseDouble((String) Locks.getSelectedToggle().getUserData()) * 2.5;//8
            Main.client.workingUser.profile.interests[UserRecord.REALISTIC] += Double.parseDouble((String) OperateMachines.getSelectedToggle().getUserData()) * 2.5;//9
            Main.client.workingUser.profile.interests[UserRecord.REALISTIC] += Double.parseDouble((String) FightFires.getSelectedToggle().getUserData()) * 2.5;//10

            System.out.println(Main.client.workingUser.profile.interests[UserRecord.REALISTIC]);



            //change scene
            q1to10Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Questions11To20.fxml"));
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

