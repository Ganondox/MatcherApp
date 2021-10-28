package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questions81To90Controller {


    @FXML
    private ToggleGroup Negotiation ;
    @FXML
    private ToggleGroup OperationsAnalysis ; //2
    @FXML
    private ToggleGroup PersonnelAndHumanResources; //3
    @FXML
    private ToggleGroup ProductionAndProcessing; //4
    @FXML
    private ToggleGroup Programming; //5
    @FXML
    private ToggleGroup Psychology; //6
    @FXML
    private ToggleGroup PublicSafetyAndSecurity; //7
    @FXML
    private ToggleGroup QualityControlAnalysis; //8
    @FXML
    private ToggleGroup Repairing; //9
    @FXML
    private ToggleGroup SalesAndMarketing; //10


    @FXML
    private Button q81to90Button;

    @FXML
    void toQ91to100(MouseEvent event) {



        //update working user

        Main.client.workingUser.profile.aptitude[UserRecord.NEGOTIATION] = Double.parseDouble((String) Negotiation.getSelectedToggle().getUserData()) * 25;
        Main.client.workingUser.profile.aptitude[UserRecord.OPERATIONS_ANALYSIS] = Double.parseDouble((String) OperationsAnalysis.getSelectedToggle().getUserData()) * 25; //2
        Main.client.workingUser.profile.aptitude[UserRecord.PERSONNEL_AND_HUMAN_RESOURCES] = Double.parseDouble((String) PersonnelAndHumanResources.getSelectedToggle().getUserData()) * 25;//3
        Main.client.workingUser.profile.aptitude[UserRecord.PRODUCTION_AND_PROCESSING] = Double.parseDouble((String) ProductionAndProcessing.getSelectedToggle().getUserData()) * 25;//4
        Main.client.workingUser.profile.aptitude[UserRecord.PROGRAMMING] = Double.parseDouble((String) Programming.getSelectedToggle().getUserData()) * 25;//5
        Main.client.workingUser.profile.aptitude[UserRecord.PSYCHOLOGY] = Double.parseDouble((String) Psychology.getSelectedToggle().getUserData()) * 25;//6
        Main.client.workingUser.profile.aptitude[UserRecord.PUBLIC_SAFETY_AND_SECURITY] = Double.parseDouble((String) PublicSafetyAndSecurity.getSelectedToggle().getUserData()) * 25; //7
        Main.client.workingUser.profile.aptitude[UserRecord.QUALITY_CONTROL_ANALYSIS] = Double.parseDouble((String) QualityControlAnalysis.getSelectedToggle().getUserData()) * 25;//8
        Main.client.workingUser.profile.aptitude[UserRecord.REPAIRING] = Double.parseDouble((String) Repairing.getSelectedToggle().getUserData()) * 25;//9
        Main.client.workingUser.profile.aptitude[UserRecord.SALES_AND_MARKETING] = Double.parseDouble((String) SalesAndMarketing.getSelectedToggle().getUserData()) * 25;//10

        System.out.println(Main.client.workingUser.profile.aptitude[UserRecord.SALES_AND_MARKETING]);



        //change scene
        q81to90Button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Questions91To100.fxml"));
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

