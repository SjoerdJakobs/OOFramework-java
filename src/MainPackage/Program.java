package MainPackage;

import OOFramework.ExampleClasses.ExampleStudent;
import OOFramework.FrameworkProgram;

import static javafx.application.Application.launch;

public class Program extends FrameworkProgram
{
    //student variable
    ExampleStudent Student;
    Program()
    {
        super();
    }

    @Override
    protected void Start() {
        super.Start();
        // create new student
        Student = new ExampleStudent(this,false,true,true,true);
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
