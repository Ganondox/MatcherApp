package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questions31To40Controller  {


    @FXML
    private ToggleGroup TeachExercise;
    @FXML
    private ToggleGroup PersonalProblems; //2
    @FXML
    private ToggleGroup CareerGuidance; //3
    @FXML
    private ToggleGroup RehabilitationTherapy; //4
    @FXML
    private ToggleGroup VolunteerWork; //5
    @FXML
    private ToggleGroup CoachChildren; //6
    @FXML
    private ToggleGroup SignLanguage; //7
    @FXML
    private ToggleGroup GroupTherapy; //8
    @FXML
    private ToggleGroup Daycare; //9
    @FXML
    private ToggleGroup TeachHighschool; //10


    @FXML
    private Button q31to40Button;

    @FXML
    void toQ41to50(MouseEvent event) {



        //update working user
        Main.client.workingUser.profile.interests[UserRecord.SOCIAL] = 0;
        Main.client.workingUser.profile.interests[UserRecord.SOCIAL] += Double.parseDouble((String) TeachExercise.getSelectedToggle().getUserData()) * 2.5;
        Main.client.workingUser.profile.interests[UserRecord.SOCIAL] += Double.parseDouble((String) PersonalProblems.getSelectedToggle().getUserData()) * 2.5; //2
        Main.client.workingUser.profile.interests[UserRecord.SOCIAL] += Double.parseDouble((String) CareerGuidance.getSelectedToggle().getUserData()) * 2.5;//3
        Main.client.workingUser.profile.interests[UserRecord.SOCIAL] += Double.parseDouble((String) RehabilitationTherapy.getSelectedToggle().getUserData()) * 2.5;//4
        Main.client.workingUser.profile.interests[UserRecord.SOCIAL] += Double.parseDouble((String) VolunteerWork.getSelectedToggle().getUserData()) * 2.5;//5
        Main.client.workingUser.profile.interests[UserRecord.SOCIAL] += Double.parseDouble((String) CoachChildren.getSelectedToggle().getUserData()) * 2.5;//6
        Main.client.workingUser.profile.interests[UserRecord.SOCIAL] += Double.parseDouble((String) SignLanguage.getSelectedToggle().getUserData()) * 2.5; //7
        Main.client.workingUser.profile.interests[UserRecord.SOCIAL] += Double.parseDouble((String) GroupTherapy.getSelectedToggle().getUserData()) * 2.5;//8
        Main.client.workingUser.profile.interests[UserRecord.SOCIAL] += Double.parseDouble((String) Daycare.getSelectedToggle().getUserData()) * 2.5;//9
        Main.client.workingUser.profile.interests[UserRecord.SOCIAL] += Double.parseDouble((String) TeachHighschool.getSelectedToggle().getUserData()) * 2.5;//10

        System.out.println(Main.client.workingUser.profile.interests[UserRecord.SOCIAL]);



        //change scene
        q31to40Button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Questions41To50.fxml"));
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

