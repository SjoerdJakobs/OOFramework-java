package MainPackage;

import SFramework.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main
{
    public static void main(String[] args)
    {
        Program program = new Program();
        program.Run();

        Multithreading object1 = new Multithreading(1000, 1000, 15);
        Multithreading object2 = new Multithreading(500, 500, 10);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(object1);
        executorService.execute(object2);
    }
}


// Java code for thread creation by implementing
// the Runnable Interface
class Multithreading implements Runnable
{
    private final AtomicBoolean atomicBoolean = new AtomicBoolean();

    public void setToFalse()
    {
        this.atomicBoolean.set(false);
    }

    public void setToTrue()
    {
        this.atomicBoolean.set(true);
        //run();
    }

    public void Restart()
    {
        this.setToTrue();
        this.run();
    }

    int m_onTime;
    int m_offTime;
    int m_addres;

    Multithreading(int onTime, int offTime, int addres)
    {
        this.setToTrue();
        m_addres = addres;
        m_onTime = onTime;
        m_offTime = offTime;
    }

    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " +
                    Thread.currentThread().getId() +
                    " is running with addres" + m_addres);
            boolean state = false;

            while (atomicBoolean.get()) {


            }
        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}