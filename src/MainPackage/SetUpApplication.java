package MainPackage;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
//import org.jfree.fx.FXGraphics2D;

public class SetUpApplication extends Application
{

    private Canvas canvas;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.canvas = new Canvas(640, 480);
        //draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Hello Java 2D");
        primaryStage.show();
    }

    //public void draw(FXGraphics2D graphics) {
        // teken
    //}
}
