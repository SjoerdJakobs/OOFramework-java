package MainPackage;

import MainPackage.Modules.Engine;
import OOFramework.FrameworkProgram;
import OOFramework.StandardObject;

public class DriverAI extends StandardObject
{
    private Engine engine;

    protected DriverAI(FrameworkProgram frameworkProgram) {
        super(frameworkProgram);
    }

    public DriverAI(FrameworkProgram frameworkProgram, boolean usesInput, boolean usesMain, boolean usesRenderer, boolean startsActivated, Engine _engine) {
        super(frameworkProgram, usesInput, usesMain, usesRenderer, startsActivated);
        engine = _engine;
        System.out.println("lowest");

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
    protected void MainLoop(double deltaTime) {
        super.MainLoop(deltaTime);
        engine.Drive();
    }

    @Override
    protected void Destroy() {
        super.Destroy();
    }
}
