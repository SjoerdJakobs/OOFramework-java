package MainPackage.Modules;

import java.util.ArrayList;

public class Receiver
{
    public Receiver()
    {
    }

    public void CheckInt(ArrayList<Long> testList)
    {
        long i = testList.get(0);
        testList.set(0, i+2L);
    }

    public void CheckInt(Long testList)
    {
        testList += 2;
    }

    public void CheckInt(Button testButton)
    {
        testButton.setAddress((testButton.getAddress() + 2));
    }

    public void CheckInt1(ArrayList<Button> testList)
    {
        testList.get(0).setAddress((testList.get(0).getAddress()+2));
    }
}
