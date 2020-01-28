package OOFramework.ExampleClasses;

import OOFramework.statemachine.State;
import OOFramework.statemachine.StateID;

public class ExampleGoToLessonState extends State
{
    private ExampleStudent Student;

    public ExampleGoToLessonState(ExampleStudent exampleStudent)
    {
        super(StateID.ExampleGoToLessonState);
        this.Student = exampleStudent;
    }

    @Override
    protected void enter()
    {
        super.enter();
        System.out.println("lets go to the lesson");
    }

    @Override
    protected void checkForStateSwitch()
    {
        super.checkForStateSwitch();
        if(Student.getPeeValue() >= 10)
        {
            stateMachine.SetState(StateID.ExampleGoToToiletState);
        }
    }

    double timer = 0;
    @Override
    protected void logic()
    {
        super.logic();
        timer += stateMachine.getDeltaTime();
        if(timer >= 1) {
            System.out.println("iam in or going to the lesson");
            timer = 0;
        }
        Student.setPeeValue(Student.getPeeValue() + stateMachine.getDeltaTime());
    }

    @Override
    protected void leave()
    {
        super.leave();
        System.out.println("going to 'going to toilet state'");
    }
}