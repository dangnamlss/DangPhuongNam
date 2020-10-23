package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.IIOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            Parent root = FXMLLoader.load(this.getClass().getResource("sample.fxml"));
            primaryStage.setTitle("NAM DEP TRAI DICTIONARY");
            primaryStage.setScene(new Scene(root));
            primaryStage.setMaxHeight(440);
            primaryStage.setMinHeight(440);
            primaryStage.setMaxWidth(600);
            primaryStage.setMinWidth(600);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
