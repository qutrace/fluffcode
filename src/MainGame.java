import org.lwjgl.*;
import org.lwjgl.glfw.*;

class MainGame
{

    private static boolean TEST = true;
    private Long _window;
    private boolean _close;


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
        init_glfw();
        init_gl();
    }
    private void loop()
    {
        long startTime;
        long endTime;
        int fps = 30;
        long targetTime = 1000L / fps;

        while (!_close)
        {
            startTime = System.currentTimeMillis();
            update();
            draw();

            //currently crashes monitor
            //GLFW.glfwSwapBuffers(_window);

            GLFW.glfwPollEvents();

            checkCloseCondition();

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
        terminate_glfw();
    }


    private void init_glfw()
    {
        //Needs org.lwjgl.glfw import
        //create error callback
        GLFWErrorCallback errorCallback;
        errorCallback = GLFWErrorCallback.createPrint(System.err);

        //alternatively, import static org.lwjgl.glfw.GLFW.*;
        //set error Callback
        GLFW.glfwSetErrorCallback(errorCallback);
        if( !GLFW.glfwInit())
        {
            String glfwErrMsg = "Unable to initialize glfw";
            throw new IllegalStateException(glfwErrMsg);
        }

        //set window parameters
        String title = "MyTitle"; //must be not null
        boolean resize = true;
        int resizable = resize ? GLFW.GLFW_TRUE : GLFW.GLFW_FALSE;
        int m_width = 1027;
        int m_height = 800;

        //Loads GLFW's default window settings
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_TRUE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, resizable);

        //Create Window Handle
        _window = GLFW.glfwCreateWindow(m_width, m_height, title, 0, 0);
        if (_window == null)
        {
            String windowErrMsg = "Failed to create window";
            throw new RuntimeException(windowErrMsg);
        }
    }
    private void init_gl()
    {

    }
    private void terminate_glfw()
    {
        // Free the window callbacks and destroy the window
        //org.lwjgl.glfw.Callbacks
        Callbacks.glfwFreeCallbacks(_window);
        GLFW.glfwDestroyWindow(_window);

        // Terminate GLFW and free the error callback
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }
    private void terminate_gl()
    {

    }

    private void update()
    {

    }
    private void draw()
    {

    }

    private void checkCloseCondition()
    {
        if (GLFW.glfwWindowShouldClose(_window))
        {
            _close = true;
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
