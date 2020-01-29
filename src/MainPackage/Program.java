package MainPackage;

import OOFramework.ExampleClasses.ExampleStudent;
import OOFramework.FrameworkProgram;

import static javafx.application.Application.launch;

public class Program extends FrameworkProgram
{
    //student variable
    ExampleStudent Student;
    ExampleStudent Student2;
    Program()
    {
        super();
    }

    @Override
    protected void Start() {
        super.Start();
        // create new student
        Student = new ExampleStudent(this, 6 );
        Student2 = new ExampleStudent(this, 9 );
        //Student = new ExampleStudent(this, 12);
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
