package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questions11To20Controller {



        @FXML
        private ToggleGroup DevelopMedicine;
        @FXML
        private ToggleGroup WaterPollution; //2
        @FXML
        private ToggleGroup ChemicalExperiments; //3
        @FXML
        private ToggleGroup StudyPlanets; //4
        @FXML
        private ToggleGroup UseMicroscope; //5
        @FXML
        private ToggleGroup InvestigateFires; //6
        @FXML
        private ToggleGroup PredictWeather; //7
        @FXML
        private ToggleGroup BiologyLab; //8
        @FXML
        private ToggleGroup ReinventSugar; //9
        @FXML
        private ToggleGroup IdentifyDiseases; //10


        @FXML
        private Button q11to20Button;

        @FXML
        void toQ21to30(MouseEvent event) {



            //update working user
            Main.client.workingUser.profile.interests[UserRecord.INVESTIGATIVE] = 0;
            Main.client.workingUser.profile.interests[UserRecord.INVESTIGATIVE] += Double.parseDouble((String) DevelopMedicine.getSelectedToggle().getUserData()) * 2.5;
            Main.client.workingUser.profile.interests[UserRecord.INVESTIGATIVE] += Double.parseDouble((String) WaterPollution.getSelectedToggle().getUserData()) * 2.5; //2
            Main.client.workingUser.profile.interests[UserRecord.INVESTIGATIVE] += Double.parseDouble((String) ChemicalExperiments.getSelectedToggle().getUserData()) * 2.5;//3
            Main.client.workingUser.profile.interests[UserRecord.INVESTIGATIVE] += Double.parseDouble((String) StudyPlanets.getSelectedToggle().getUserData()) * 2.5;//4
            Main.client.workingUser.profile.interests[UserRecord.INVESTIGATIVE] += Double.parseDouble((String) UseMicroscope.getSelectedToggle().getUserData()) * 2.5;//5
            Main.client.workingUser.profile.interests[UserRecord.INVESTIGATIVE] += Double.parseDouble((String) InvestigateFires.getSelectedToggle().getUserData()) * 2.5;//6
            Main.client.workingUser.profile.interests[UserRecord.INVESTIGATIVE] += Double.parseDouble((String) PredictWeather.getSelectedToggle().getUserData()) * 2.5; //7
            Main.client.workingUser.profile.interests[UserRecord.INVESTIGATIVE] += Double.parseDouble((String) BiologyLab.getSelectedToggle().getUserData()) * 2.5;//8
            Main.client.workingUser.profile.interests[UserRecord.INVESTIGATIVE] += Double.parseDouble((String) ReinventSugar.getSelectedToggle().getUserData()) * 2.5;//9
            Main.client.workingUser.profile.interests[UserRecord.INVESTIGATIVE] += Double.parseDouble((String) IdentifyDiseases.getSelectedToggle().getUserData()) * 2.5;//10

            System.out.println(Main.client.workingUser.profile.interests[UserRecord.INVESTIGATIVE]);



            //change scene
            q11to20Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Questions21To30.fxml"));
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
