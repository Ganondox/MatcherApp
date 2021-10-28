package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questions51To60Controller {


        @FXML
        private ToggleGroup DevelopSpreadsheet;
        @FXML
        private ToggleGroup ProofreadRecords; //2
        @FXML
        private ToggleGroup InstallSoftware; //3
        @FXML
        private ToggleGroup OperateCalculator; //4
        @FXML
        private ToggleGroup ShippingRecords; //5
        @FXML
        private ToggleGroup CalculateWages; //6
        @FXML
        private ToggleGroup InventorySupplies; //7
        @FXML
        private ToggleGroup RecordPayments; //8
        @FXML
        private ToggleGroup InventoryRecords; //9
        @FXML
        private ToggleGroup ShipMail; //10


        @FXML
        private Button q51to60Button;

        @FXML
        void toQ61to70(MouseEvent event) {



            //update working user
            Main.client.workingUser.profile.interests[UserRecord.CONVENTIONAL] = 0;
            Main.client.workingUser.profile.interests[UserRecord.CONVENTIONAL] += Double.parseDouble((String) DevelopSpreadsheet.getSelectedToggle().getUserData()) * 2.5;
            Main.client.workingUser.profile.interests[UserRecord.CONVENTIONAL] += Double.parseDouble((String) ProofreadRecords.getSelectedToggle().getUserData()) * 2.5; //2
            Main.client.workingUser.profile.interests[UserRecord.CONVENTIONAL] += Double.parseDouble((String) InstallSoftware.getSelectedToggle().getUserData()) * 2.5;//3
            Main.client.workingUser.profile.interests[UserRecord.CONVENTIONAL] += Double.parseDouble((String) OperateCalculator.getSelectedToggle().getUserData()) * 2.5;//4
            Main.client.workingUser.profile.interests[UserRecord.CONVENTIONAL] += Double.parseDouble((String) ShippingRecords.getSelectedToggle().getUserData()) * 2.5;//5
            Main.client.workingUser.profile.interests[UserRecord.CONVENTIONAL] += Double.parseDouble((String) CalculateWages.getSelectedToggle().getUserData()) * 2.5;//6
            Main.client.workingUser.profile.interests[UserRecord.CONVENTIONAL] += Double.parseDouble((String) InventorySupplies.getSelectedToggle().getUserData()) * 2.5; //7
            Main.client.workingUser.profile.interests[UserRecord.CONVENTIONAL] += Double.parseDouble((String) RecordPayments.getSelectedToggle().getUserData()) * 2.5;//8
            Main.client.workingUser.profile.interests[UserRecord.CONVENTIONAL] += Double.parseDouble((String) InventoryRecords.getSelectedToggle().getUserData()) * 2.5;//9
            Main.client.workingUser.profile.interests[UserRecord.CONVENTIONAL] += Double.parseDouble((String) ShipMail.getSelectedToggle().getUserData()) * 2.5;//10

            System.out.println(Main.client.workingUser.profile.interests[UserRecord.CONVENTIONAL]);



            //change scene
            q51to60Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Questions61To70.fxml"));
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


