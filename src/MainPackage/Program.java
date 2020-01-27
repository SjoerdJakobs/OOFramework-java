package MainPackage;

import OOFramework.FrameworkProgram;

import static javafx.application.Application.launch;

public class Program extends FrameworkProgram
{
    Program()
    {
        super();
    }

    @Override
    protected void Start() {
        super.Start();
        launch(SetUpApplication.class);
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
