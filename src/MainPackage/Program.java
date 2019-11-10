package MainPackage;

import SFramework.ExampleClasses.ExampleObject;
import SFramework.FrameworkProgram;

public class Program extends FrameworkProgram
{
    boolean state = true;

    Program()
    {

    }

    @Override
    protected void Start() {
        super.Start();

        ExampleObject testObj = new ExampleObject(this,true,true,true,true);

        System.out.println("Hello World!");


        //BoeBot.digitalWrite(10, !state);


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
