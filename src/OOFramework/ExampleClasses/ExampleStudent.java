package OOFramework.ExampleClasses;

import OOFramework.FrameworkProgram;
import OOFramework.StandardObject;

public class ExampleStudent extends StandardObject
{
    public ExampleStudent(FrameworkProgram frameworkProgram)
    {
        super(frameworkProgram);
    }

    public ExampleStudent(FrameworkProgram frameworkProgram, boolean usesInput, boolean usesMain, boolean usesRenderer, boolean startsActivated)
    {
        super(frameworkProgram, usesInput, usesMain, usesRenderer, startsActivated);
    }

    @Override
    protected void Start()
    {
        super.Start();
    }

    @Override
    protected void Awake()
    {
        super.Awake();
    }

    @Override
    protected void InputLoop(double deltaTime)
    {
        super.InputLoop(deltaTime);
    }
}
