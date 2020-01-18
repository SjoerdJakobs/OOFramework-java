package MainPackage;

import OOFramework.FrameworkProgram;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;

public class Program extends FrameworkProgram
{
    Program()
    {

    }

    @Override
    protected void Start() {
        super.Start();
    }

    @Override
    protected void AddToLoop() {
        super.AddToLoop();

    }

    @Override
    protected void ExitProgram() {
        super.ExitProgram();

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        canvas = new javafx.scene.canvas.Canvas(640, 480);
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Hello Java 2D");
        primaryStage.show();

    }

    public void draw(FXGraphics2D graphics) {
        // teken
    }
}
