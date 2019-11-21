package MainPackage.Modules;

public class Button
{

    public Button(long address)
    {
         this.address = address;
         this.isPressed = false;
    }

    private boolean isPressed;
    public boolean IsPressed()
    {
        return isPressed;
    }
    public void setPressed(boolean pressed)
    {
        isPressed = pressed;
    }

    private long address;
    public long getAddress()
    {
        return address;
    }
    public void setAddress(long address)
    {
        this.address = address;
    }
}
