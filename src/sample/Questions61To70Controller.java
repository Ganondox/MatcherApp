package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questions61To70Controller  {


    @FXML
    private ToggleGroup AdministrationAndManagement ;
    @FXML
    private ToggleGroup Biology; //2
    @FXML
    private ToggleGroup BodyCoordination; //3
    @FXML
    private ToggleGroup BuildingAndConstruction; //4
    @FXML
    private ToggleGroup Chemistry; //5
    @FXML
    private ToggleGroup Clerical; //6
    @FXML
    private ToggleGroup ComplexProblemSolving; //7
    @FXML
    private ToggleGroup ComputersAndElectronics; //8
    @FXML
    private ToggleGroup CustomerAndPersonalService; //9
    @FXML
    private ToggleGroup EconomicsAndAccounting; //10


    @FXML
    private Button q61to70Button;

    @FXML
    void toQ71to80(MouseEvent event) {



        //update working user

        Main.client.workingUser.profile.aptitude[UserRecord.ADMINISTRATION_AND_MANAGEMENT] = Double.parseDouble((String) AdministrationAndManagement.getSelectedToggle().getUserData()) * 25;
        Main.client.workingUser.profile.aptitude[UserRecord.BIOLOGY] = Double.parseDouble((String) Biology.getSelectedToggle().getUserData()) * 25; //2
        Main.client.workingUser.profile.aptitude[UserRecord.BODY_COORDINATION] = Double.parseDouble((String) BodyCoordination.getSelectedToggle().getUserData()) * 25;//3
        Main.client.workingUser.profile.aptitude[UserRecord.BUILDING_AND_CONSTRUCTION] = Double.parseDouble((String) BuildingAndConstruction.getSelectedToggle().getUserData()) * 25;//4
        Main.client.workingUser.profile.aptitude[UserRecord.CHEMISTRY] = Double.parseDouble((String) Chemistry.getSelectedToggle().getUserData()) * 25;//5
        Main.client.workingUser.profile.aptitude[UserRecord.CLERICAL] = Double.parseDouble((String) Clerical.getSelectedToggle().getUserData()) * 25;//6
        Main.client.workingUser.profile.aptitude[UserRecord.COMPLEX_PROBLEM_SOLVING] = Double.parseDouble((String) ComplexProblemSolving.getSelectedToggle().getUserData()) * 25; //7
        Main.client.workingUser.profile.aptitude[UserRecord.COMPUTERS_AND_ELECTRONICS] = Double.parseDouble((String) ComputersAndElectronics.getSelectedToggle().getUserData()) * 25;//8
        Main.client.workingUser.profile.aptitude[UserRecord.CUSTOMER_AND_PERSONAL_SERVICE] = Double.parseDouble((String) CustomerAndPersonalService.getSelectedToggle().getUserData()) * 25;//9
        Main.client.workingUser.profile.aptitude[UserRecord.ECONOMICS_AND_ACCOUNTING] = Double.parseDouble((String) EconomicsAndAccounting.getSelectedToggle().getUserData()) * 25;//10

        System.out.println(Main.client.workingUser.profile.aptitude[UserRecord.ECONOMICS_AND_ACCOUNTING]);



        //change scene
        q61to70Button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Questions71To80.fxml"));
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

