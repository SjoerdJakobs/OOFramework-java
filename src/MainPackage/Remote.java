package MainPackage;

import MainPackage.Modules.Button;
import MainPackage.Modules.Receiver;
import OOFramework.FrameworkProgram;
import OOFramework.StandardObject;

import java.util.ArrayList;

public class Remote extends StandardObject
{
    private Receiver receiver;
    private ArrayList<Button> buttons;
    private ArrayList<Long> buttonsi;
    Long i;

    public Button UpButton;

    protected Remote(FrameworkProgram frameworkProgram) {
        super(frameworkProgram);
    }

    public Remote(FrameworkProgram frameworkProgram, boolean usesInput, boolean usesMain, boolean usesRenderer, boolean startsActivated) {
        super(frameworkProgram, usesInput, usesMain, usesRenderer, startsActivated);
        buttons = new ArrayList<Button>();
        UpButton = new Button(112);
        buttons.add(UpButton);

        receiver = new Receiver();
        i = 1L;
        buttonsi = new ArrayList<Long>();
        buttonsi.add(i);

        System.out.println("lowest");

        System.out.println("i = " + i);
        System.out.println("i in list = " + buttonsi.get(0));
        System.out.println("button = " + UpButton.getAddress());
        System.out.println("button in list = " + buttons.get(0).getAddress());

        receiver.CheckInt(i);
        receiver.CheckInt(buttonsi);
        //receiver.CheckInt(UpButton);
        receiver.CheckInt1(buttons);

        System.out.println("i after method = " + i);
        System.out.println("i in list after method = " + buttonsi.get(0));
        System.out.println("button after method = " + UpButton.getAddress());
        System.out.println("button in list after method = " + buttons.get(0).getAddress());

        /*receiver.CheckInt(i);
        receiver.CheckInt(buttonsi);

        System.out.println("i after method 2 = " + i);
        System.out.println("i in list after method 2 = " + buttonsi.get(0));
        */
    }

    @Override
    protected void Start() {
        super.Start();
    }

    @Override
    protected void Awake() {
        super.Awake();
    }

    @Override
    protected void Sleep()
    {
        super.Sleep();
    }

    @Override
    protected void InputLoop(double deltaTime) {
        super.InputLoop(deltaTime);

    }

    @Override
    protected void Destroy() {
        super.Destroy();
    }
}
