package OOFramework.ExampleClasses;

import OOFramework.statemachine.State;
import OOFramework.statemachine.StateID;

public class ExampleGoToToiletState extends State
{
    private ExampleStudent Student;

    public ExampleGoToToiletState(ExampleStudent exampleStudent)
    {
        super(StateID.ExampleGoToToiletState);
        this.Student = exampleStudent;
    }

    @Override
    protected void enter()
    {
        super.enter();
        System.out.println("lets go to the toilet");
    }

    @Override
    protected void checkForStateSwitch()
    {
        super.checkForStateSwitch();
        if(Student.getPeeValue()<= 0)
        {
            Student.setPeeValue(0);
            stateMachine.SetState(StateID.ExampleGoToLessonState);
        }
    }

    double timer = 0;
    @Override
    protected void logic()
    {
        super.logic();
        timer += stateMachine.getDeltaTime();
        if(timer >= 1) {
            System.out.println("iam in or going to the toilet");
            timer = 0;
        }
        Student.setPeeValue(Student.getPeeValue() - stateMachine.getDeltaTime()*3);
    }

    @Override
    protected void leave()
    {
        super.leave();
        System.out.println("going to 'going to lesson state'");
    }
}