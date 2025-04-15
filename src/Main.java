import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(); //instead of calling start(stage) method.
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene( //creating a stage and a new scene
                        FXMLLoader.load( //scene loading
                                getClass().getResource("/view/ItemManagementForm.fxml") //scene //when creating packages, first letter simple
                        )
                )
        );
        stage.show();
    }
}