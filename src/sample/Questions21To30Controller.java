package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questions21To30Controller {


    @FXML
    private ToggleGroup WriteBooks;
    @FXML
    private ToggleGroup PlayInstrument; //2
    @FXML
    private ToggleGroup MakeMusic; //3
    @FXML
    private ToggleGroup DrawPictures; //4
    @FXML
    private ToggleGroup MovieEffects; //5
    @FXML
    private ToggleGroup PaintSets; //6
    @FXML
    private ToggleGroup WriteScripts; //7
    @FXML
    private ToggleGroup JazzDance; //8
    @FXML
    private ToggleGroup Sing; //9
    @FXML
    private ToggleGroup EditMovies; //10


    @FXML
    private Button q21to30Button;

    @FXML
    void toQ31to40(MouseEvent event) {



        //update working user
        Main.client.workingUser.profile.interests[UserRecord.ARTISTIC] = 0;
        Main.client.workingUser.profile.interests[UserRecord.ARTISTIC] += Double.parseDouble((String) WriteBooks.getSelectedToggle().getUserData()) * 2.5;
        Main.client.workingUser.profile.interests[UserRecord.ARTISTIC] += Double.parseDouble((String) PlayInstrument.getSelectedToggle().getUserData()) * 2.5; //2
        Main.client.workingUser.profile.interests[UserRecord.ARTISTIC] += Double.parseDouble((String) MakeMusic.getSelectedToggle().getUserData()) * 2.5;//3
        Main.client.workingUser.profile.interests[UserRecord.ARTISTIC] += Double.parseDouble((String) DrawPictures.getSelectedToggle().getUserData()) * 2.5;//4
        Main.client.workingUser.profile.interests[UserRecord.ARTISTIC] += Double.parseDouble((String) MovieEffects.getSelectedToggle().getUserData()) * 2.5;//5
        Main.client.workingUser.profile.interests[UserRecord.ARTISTIC] += Double.parseDouble((String) PaintSets.getSelectedToggle().getUserData()) * 2.5;//6
        Main.client.workingUser.profile.interests[UserRecord.ARTISTIC] += Double.parseDouble((String) WriteScripts.getSelectedToggle().getUserData()) * 2.5; //7
        Main.client.workingUser.profile.interests[UserRecord.ARTISTIC] += Double.parseDouble((String) JazzDance.getSelectedToggle().getUserData()) * 2.5;//8
        Main.client.workingUser.profile.interests[UserRecord.ARTISTIC] += Double.parseDouble((String) Sing.getSelectedToggle().getUserData()) * 2.5;//9
        Main.client.workingUser.profile.interests[UserRecord.ARTISTIC] += Double.parseDouble((String) EditMovies.getSelectedToggle().getUserData()) * 2.5;//10

        System.out.println(Main.client.workingUser.profile.interests[UserRecord.ARTISTIC]);



        //change scene
        q21to30Button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Questions31To40.fxml"));
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

