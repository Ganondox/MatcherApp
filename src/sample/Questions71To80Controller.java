package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questions71To80Controller {


    @FXML
    private ToggleGroup FineArts ;
    @FXML
    private ToggleGroup ForeignLanguage ; //2
    @FXML
    private ToggleGroup HelpingPeople; //3
    @FXML
    private ToggleGroup Instructing; //4
    @FXML
    private ToggleGroup ManagementOfFinancialResources; //5
    @FXML
    private ToggleGroup Mathematics; //6
    @FXML
    private ToggleGroup Mechanical; //7
    @FXML
    private ToggleGroup MedicineAndDentistry; //8
    @FXML
    private ToggleGroup Memorization; //9
    @FXML
    private ToggleGroup Monitoring; //10


    @FXML
    private Button q71to80Button;

    @FXML
    void toQ81to90(MouseEvent event) {



        //update working user

        Main.client.workingUser.profile.aptitude[UserRecord.FINE_ARTS] = Double.parseDouble((String) FineArts.getSelectedToggle().getUserData()) * 25;
        Main.client.workingUser.profile.aptitude[UserRecord.FOREIGN_LANGUAGE] = Double.parseDouble((String) ForeignLanguage.getSelectedToggle().getUserData()) * 25; //2
        Main.client.workingUser.profile.aptitude[UserRecord.HELPING_PEOPLE] = Double.parseDouble((String) HelpingPeople.getSelectedToggle().getUserData()) * 25;//3
        Main.client.workingUser.profile.aptitude[UserRecord.INSTRUCTING] = Double.parseDouble((String) Instructing.getSelectedToggle().getUserData()) * 25;//4
        Main.client.workingUser.profile.aptitude[UserRecord.MANAGEMENT_OF_FINANCIAL_RESOURCES] = Double.parseDouble((String) ManagementOfFinancialResources.getSelectedToggle().getUserData()) * 25;//5
        Main.client.workingUser.profile.aptitude[UserRecord.MATHEMATICS] = Double.parseDouble((String) Mathematics.getSelectedToggle().getUserData()) * 25;//6
        Main.client.workingUser.profile.aptitude[UserRecord.MECHANICAL] = Double.parseDouble((String) Mechanical.getSelectedToggle().getUserData()) * 25; //7
        Main.client.workingUser.profile.aptitude[UserRecord.MEDICINE_AND_DENTISTRY] = Double.parseDouble((String) MedicineAndDentistry.getSelectedToggle().getUserData()) * 25;//8
        Main.client.workingUser.profile.aptitude[UserRecord.MEMORIZATION] = Double.parseDouble((String) Memorization.getSelectedToggle().getUserData()) * 25;//9
        Main.client.workingUser.profile.aptitude[UserRecord.MONITORING] = Double.parseDouble((String) Monitoring.getSelectedToggle().getUserData()) * 25;//10

        System.out.println(Main.client.workingUser.profile.aptitude[UserRecord.MONITORING]);



        //change scene
        q71to80Button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Questions81To90.fxml"));
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

