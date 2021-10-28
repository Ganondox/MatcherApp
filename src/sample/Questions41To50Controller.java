package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questions41To50Controller   {


    @FXML
    private ToggleGroup StocksBonds;
    @FXML
    private ToggleGroup ManageRetail; //2
    @FXML
    private ToggleGroup OperateSalon; //3
    @FXML
    private ToggleGroup ManageDepartment; //4
    @FXML
    private ToggleGroup StartBusiness; //5
    @FXML
    private ToggleGroup NegotiateContracts; //6
    @FXML
    private ToggleGroup RepresentLawsuit; //7
    @FXML
    private ToggleGroup MarketClothing; //8
    @FXML
    private ToggleGroup SellMerchandise; //9
    @FXML
    private ToggleGroup ManageStore; //10


    @FXML
    private Button q41to50Button;

    @FXML
    void toQ51to60(MouseEvent event) {



        //update working user
        Main.client.workingUser.profile.interests[UserRecord.ENTERPRISING] = 0;
        Main.client.workingUser.profile.interests[UserRecord.ENTERPRISING] += Double.parseDouble((String) StocksBonds.getSelectedToggle().getUserData()) * 2.5;
        Main.client.workingUser.profile.interests[UserRecord.ENTERPRISING] += Double.parseDouble((String) ManageRetail.getSelectedToggle().getUserData()) * 2.5; //2
        Main.client.workingUser.profile.interests[UserRecord.ENTERPRISING] += Double.parseDouble((String) OperateSalon.getSelectedToggle().getUserData()) * 2.5;//3
        Main.client.workingUser.profile.interests[UserRecord.ENTERPRISING] += Double.parseDouble((String) ManageDepartment.getSelectedToggle().getUserData()) * 2.5;//4
        Main.client.workingUser.profile.interests[UserRecord.ENTERPRISING] += Double.parseDouble((String) StartBusiness.getSelectedToggle().getUserData()) * 2.5;//5
        Main.client.workingUser.profile.interests[UserRecord.ENTERPRISING] += Double.parseDouble((String) NegotiateContracts.getSelectedToggle().getUserData()) * 2.5;//6
        Main.client.workingUser.profile.interests[UserRecord.ENTERPRISING] += Double.parseDouble((String) RepresentLawsuit.getSelectedToggle().getUserData()) * 2.5; //7
        Main.client.workingUser.profile.interests[UserRecord.ENTERPRISING] += Double.parseDouble((String) MarketClothing.getSelectedToggle().getUserData()) * 2.5;//8
        Main.client.workingUser.profile.interests[UserRecord.ENTERPRISING] += Double.parseDouble((String) SellMerchandise.getSelectedToggle().getUserData()) * 2.5;//9
        Main.client.workingUser.profile.interests[UserRecord.ENTERPRISING] += Double.parseDouble((String) ManageStore.getSelectedToggle().getUserData()) * 2.5;//10

        System.out.println(Main.client.workingUser.profile.interests[UserRecord.ENTERPRISING]);



        //change scene
        q41to50Button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Questions51To60.fxml"));
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


