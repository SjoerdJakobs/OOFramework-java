package MainPackage;

import OOFramework.Debug.BoxCollisionTestObject;
import OOFramework.Debug.CircleCollisionTestObject;
import OOFramework.Debug.DebugDrawer;
import OOFramework.Collision2D.CollisionSystem;
import OOFramework.FrameworkProgram;
import OOFramework.Maths.Vector2;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Program extends FrameworkProgram
{
    private static Program  programInstance;
    public  static Program  getProgramInstance()
    {
        return programInstance;
    }

    private DebugDrawer     debugDrawer;
    private CollisionSystem collisionSystem;

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
        programInstance = this;

        //used by other classes for drawing their debugging;
        debugDrawer = new DebugDrawer(this);

        //this manages all the collisions
        collisionSystem = new CollisionSystem(this);


        //EnemyUnit unit = new EnemyUnit(this,new Vector2(32, 492),10,26,100,5,0.25,"route0");

        // test classes
        CircleCollisionTestObject circleCollisionTestObject1 = new CircleCollisionTestObject(this,new Vector2(600,500), 100, true);
        BoxCollisionTestObject boxCollisionTestObject1 = new BoxCollisionTestObject(this,new Vector2(600,500), 100,100, false);
        //BoxCollisionTestObject boxCollisionTestObject2 = new BoxCollisionTestObject(this,new Vector2(600,500), 100,100, true);

    }

    @Override
    protected void Init() {
        super.Init();

    }

    @Override
    protected void AddToLoop() {
        super.AddToLoop();

    }

    @Override
    public void ExitProgram() {
        super.ExitProgram();
    }

    public DebugDrawer getDebugDrawer()
    {
        return debugDrawer;
    }

    public CollisionSystem getCollisionSystem()
    {
        return collisionSystem;
    }

    public void setCollisionSystem(CollisionSystem collisionSystem)
    {
        this.collisionSystem = collisionSystem;
    }
}
