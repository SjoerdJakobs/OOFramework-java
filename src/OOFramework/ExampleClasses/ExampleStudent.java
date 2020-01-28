package OOFramework.ExampleClasses;

import OOFramework.FrameworkProgram;
import OOFramework.StandardObject;
import OOFramework.statemachine.StateID;
import OOFramework.statemachine.StateMachine;

public class ExampleStudent extends StandardObject
{
    private StateMachine StudentStateMachine;
    private double peeValue = 0;

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
        StudentStateMachine = new StateMachine();
        StudentStateMachine.AddState(new ExampleGoToLessonState(this));
        StudentStateMachine.AddState(new ExampleGoToToiletState(this));
        StudentStateMachine.SetState(StateID.ExampleGoToLessonState);
    }

    @Override
    protected void Awake()
    {
        super.Awake();
    }

    @Override
    protected void MainLoop(double deltaTime)
    {
        super.MainLoop(deltaTime);
        StudentStateMachine.StateMachineLoop(deltaTime);
    }

    public double getPeeValue()
    {
        return peeValue;
    }

    public void setPeeValue(double peeValue)
    {
        this.peeValue = peeValue;
    }

    public StateMachine getStudentStateMachine()
    {
        return StudentStateMachine;
    }

    public void setStudentStateMachine(StateMachine studentStateMachine)
    {
        StudentStateMachine = studentStateMachine;
    }
}
