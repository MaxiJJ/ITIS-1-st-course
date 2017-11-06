package course1.april25;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/course1/april25/sample.fxml"));
        AnchorPane player = loader.load();
        Scene scene = new Scene(player);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.Q) {
                Player.playSound(new Integer[]{500, 69, 301, 0});
            } else if (event.getCode() == KeyCode.W) {
                Player.playSound(new Integer[]{500, 66, 100, 0});
            } else if (event.getCode() == KeyCode.E) {
                Player.playSound(new Integer[]{500, 63, 201, 0});
            } else if (event.getCode() == KeyCode.R) {
                Player.playSound(new Integer[]{500, 65, 100, 0});
            } else if (event.getCode() == KeyCode.T) {
                Player.playSound(new Integer[]{500, 64, 100, 0});
            } else if (event.getCode() == KeyCode.Y) {
                Player.playSound(new Integer[]{500, 78, 301, 0});
            } else if (event.getCode() == KeyCode.U) {
                Player.playSound(new Integer[]{500, 75, 100, 0});
            } else if (event.getCode() == KeyCode.I) {
                Player.playSound(new Integer[]{500, 72, 201, 0});
            } else if (event.getCode() == KeyCode.O) {
                Player.playSound(new Integer[]{500, 74, 100, 0});
            } else if (event.getCode() == KeyCode.P) {
                Player.playSound(new Integer[]{500, 73, 100, 0});
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
