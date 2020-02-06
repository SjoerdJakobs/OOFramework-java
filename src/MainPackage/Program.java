package MainPackage;

import OOFramework.ExampleClasses.ExampleStudent;
import OOFramework.FrameworkProgram;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.util.ArrayList;

import static OOFramework.Modules.CONSTANTS.CANVAS_HEIGHT;
import static OOFramework.Modules.CONSTANTS.CANVAS_WIDTH;
import static javafx.application.Application.launch;

public class Program extends FrameworkProgram
{

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);

    }

    @Override
    public void draw(FXGraphics2D g2d) {
        super.draw(g2d);
    }

    private ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
    @Override
    protected void Init() {
        super.Init();
        for(int i = 0; i<200;i++)
        {
            rects.add(new Rectangle(this,graphics2D,(int)(Math.random()*1920),(int)(Math.random()*1080)));
        }
    }

    @Override
    protected void AddToLoop() {
        super.AddToLoop();

    }

    @Override
    protected void ExitProgram() {
        super.ExitProgram();
    }
}
