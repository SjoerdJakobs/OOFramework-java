package MainPackage;

import OOFramework.ExampleClasses.ExampleObject;
import OOFramework.FrameworkProgram;

public class Program extends FrameworkProgram
{
    boolean state = true;

    Program()
    {

    }

    @Override
    protected void Start() {
        super.Start();

        Remote testObj = new Remote(this,true,true,true,true);
        System.out.println("Hello World!");


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
