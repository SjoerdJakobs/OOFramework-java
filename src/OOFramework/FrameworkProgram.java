package OOFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FrameworkProgram
{
    private final AtomicBoolean run = new AtomicBoolean(false);

    private final AtomicReference<ArrayList<BaseObject>> objects = new AtomicReference<>(new ArrayList<BaseObject>());

    private final AtomicReference<ArrayList<RunnableObject>> runnableObjects = new AtomicReference<>(new ArrayList<RunnableObject>());

    private ArrayList<StandardObject> inputObjects = new ArrayList<StandardObject>();
    private ArrayList<StandardObject> mainObjects = new ArrayList<StandardObject>();
    private ArrayList<StandardObject> renderObjects = new ArrayList<StandardObject>();

    private double deltaTime = 0;

    public FrameworkProgram()
    {

    }

    public void Run() {

        Start();

        long lastTime = System.nanoTime();

        run.set(true);
        while (run.get()) {

            /**
             * calculate deltatime
             */
            long time = System.nanoTime();
            deltaTime = ((double)(time - lastTime) / 1000_000_000);//delta time in seconds
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
            for (StandardObject object : renderObjects) {
                object.RenderLoop(deltaTime);
            }

            Iterator<BaseObject> it = objects.get().iterator();
            while (it.hasNext()) {
                BaseObject bo = it.next();
                if (bo.ShouldDestruct()) {
                    bo.Destroy();
                    it.remove();
                }
                else if(bo.isActive() && !bo.isActivated())
                {
                    bo.AddToLists();
                    bo.setActivated(true);
                    bo.Awake();
                }
                else if(!bo.isActive() && bo.isActivated())
                {
                    bo.RemoveFromLists();
                    bo.setActivated(false);
                    bo.Sleep();
                }
            }
        }
    }

    protected void Start()
    {

    }

    protected void AddToLoop()
    {

    }

    protected void ExitProgram()
    {
        run.set(false);
    }

    public AtomicBoolean isRun()
    {
        return run;
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

