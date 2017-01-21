import org.lwjgl.*;
import org.lwjgl.glfw.*;
import java.util.*;

class MainGame
{

    private static boolean TEST = true;
    private List<Window> _win;
    private boolean _stop;


    public MainGame()
    {

    }
    public static void main(String[] args)
    {
        if (TEST)
        {
            //Needs org.lwjgl package
            System.out.println("Hello LWJGL " + Version.getVersion() + "!");
            System.out.println("Hello World");
        }

        MainGame app = new MainGame();
        app.run();
    }

    public void run()
    {
        init();
        loop();
        terminate();
    }

    private void init()
    {
        _win = new ArrayList<Window>(10);
        _win.add(new Window());
    }

    private void loop()
    {
        long startTime;
        long endTime;
        int fps = 30;
        long targetTime = 1000L / fps;

        while (!_stop)
        {
            startTime = System.currentTimeMillis();
            step();
            checkStopCondition();

            endTime = System.currentTimeMillis();
            sleep(startTime + targetTime - endTime);
        }
    }

    private void terminate()
    {
        if (TEST)
        {
            System.out.println("Terminating");
        }

        for (int i = 0; i < _win.size(); i++)
        {
            _win.get(i).terminate();
        }

        // Terminate GLFW and free the error callback
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }

    private void step()
    {
        //update windows
        for (int i = 0; i < _win.size(); i++)
        {
            _win.get(i).step();
        }

        //remove closed windows
        for (int i = _win.size() - 1; i >= 0; i--)
        {
            if(_win.get(i).remove())
            {
                _win.remove(i);
            }
        }
    }

    private void checkStopCondition()
    {
          if (_win.isEmpty())
        {
            _stop = true;
        }
    }

    private void sleep(long l)
    {
        if (l > 0L)
        {
            try {
                Thread.sleep(l);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
