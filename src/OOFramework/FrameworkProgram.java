package OOFramework;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static OOFramework.Modules.CONSTANTS.*;

public abstract class FrameworkProgram extends Application
{
    private final AtomicBoolean running = new AtomicBoolean(false);
    private final AtomicBoolean paused  = new AtomicBoolean(false);

    private final AtomicReference<ArrayList<BaseObject>> objects = new AtomicReference<>(new ArrayList<BaseObject>());

    private final AtomicReference<ArrayList<RunnableObject>> runnableObjects = new AtomicReference<>(new ArrayList<RunnableObject>());

    private ArrayList<StandardObject> inputObjects  = new ArrayList<StandardObject>();
    private ArrayList<StandardObject> mainObjects   = new ArrayList<StandardObject>();
    private ArrayList<StandardObject> renderObjects = new ArrayList<StandardObject>();

    private double deltaTime = 0;

    protected Stage stage;
    protected Canvas canvas;
    protected FXGraphics2D graphics2D;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        this.graphics2D = new FXGraphics2D(canvas.getGraphicsContext2D());
        this.stage.setScene(new Scene(new Group(canvas)));
        this.stage.setTitle(TITLE);
        this.stage.show();
        Init();

        new AnimationTimer() {
            long last = -1;
            @Override
            public void handle(long now) {
                if (last == -1)
                    last = now;
                Run(graphics2D);
                last = now;
            }
        }.start();
    }

    public void draw(FXGraphics2D g2d) {

    }

    long lastTime = System.nanoTime();

    public void Run(FXGraphics2D g2d) {

        /**
         * calculate deltatime
         */
        long time = System.nanoTime();
        deltaTime = ((double) (time - lastTime) / 1000_000_000);//delta time in seconds
        lastTime = time;

        //uncomment to print the deltatime in seconds
        //String s = String.format("%.5f", deltaTime);
        //System.out.println(s);

        AddToLoop();

        for (StandardObject object : inputObjects) {
            object.InputLoop(deltaTime);
        }
        for (StandardObject object : mainObjects) {
            object.MainLoop(deltaTime);
        }

        //clear screen
        g2d.setBackground(Color.white);
        g2d.clearRect(0,0,CANVAS_WIDTH,CANVAS_HEIGHT);
        //

        for (StandardObject object : renderObjects) {
            object.RenderLoop(deltaTime);
        }

        Iterator<BaseObject> it = objects.get().iterator();
        while (it.hasNext()) {
            BaseObject bo = it.next();
            if (bo.ShouldDestruct()) {
                bo.Destroy();
                it.remove();
            } else if (bo.isActive() && !bo.isActivated()) {
                bo.AddToLists();
                bo.setActivated(true);
                bo.Awake();
            } else if (!bo.isActive() && bo.isActivated()) {
                bo.RemoveFromLists();
                bo.setActivated(false);
                bo.Sleep();
            }
        }
    }

    protected void Init()
    {
        running.set(true);
    }

    protected void AddToLoop()
    {

    }

    protected void ExitProgram()
    {
        running.set(false);
    }


    public AtomicBoolean isRunning()
    {
        return running;
    }

    public AtomicBoolean isPaused()
    {
        return paused;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public FXGraphics2D getGraphics2D() {
        return graphics2D;
    }

    public AtomicReference<ArrayList<BaseObject>> getObjects()
    {
        return objects;
    }

    public AtomicReference<ArrayList<RunnableObject>> getRunnableObjects()
    {
        return runnableObjects;
    }

    public ArrayList<StandardObject> getInputObjects()
    {
        return inputObjects;
    }

    public ArrayList<StandardObject> getMainObjects()
    {
        return mainObjects;
    }

    public ArrayList<StandardObject> getRenderObjects()
    {
        return renderObjects;
    }
}

