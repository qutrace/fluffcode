import org.lwjgl.glfw.*;

class Window
{
    private Long _windowHandle;
    private boolean _close;
    private static boolean TEST = true;
    private GLFWErrorCallback _errorCallback;

    public Window()
    {
        init();
    }

    public void step()
    {
        //set error Callback
        GLFW.glfwSetErrorCallback(_errorCallback);

        update();
        draw();
        GLFW.glfwPollEvents();
        //currently crashes monitor
        //GLFW.glfwSwapBuffers(_window);

        checkCloseCondition();
    }

    public void init()
    {
        init_glfw();
        init_gl();
    }

    public void terminate()
    {
        if (TEST)
        {
            System.out.println("Terminating window");
        }
        terminate_glfw_window();
    }

    private void init_glfw()
    {
        //Needs org.lwjgl.glfw import
        //create error callback
        _errorCallback = GLFWErrorCallback.createPrint(System.err);

        //alternatively, import static org.lwjgl.glfw.GLFW.*;
        //set error Callback
        GLFW.glfwSetErrorCallback(_errorCallback);
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
        _windowHandle = GLFW.glfwCreateWindow(m_width, m_height, title, 0, 0);
        if (_windowHandle == null)
        {
            String windowErrMsg = "Failed to create window";
            throw new RuntimeException(windowErrMsg);
        }
    }

    private void init_gl()
    {
    }

    private void terminate_glfw_window()
    {
        // Free the window callbacks and destroy the window
        //org.lwjgl.glfw.Callbacks
        Callbacks.glfwFreeCallbacks(_windowHandle);
        GLFW.glfwDestroyWindow(_windowHandle);

    }

    private void checkCloseCondition()
    {
        if (GLFW.glfwWindowShouldClose(_windowHandle))
        {
            _close = true;
            terminate();
        }
    }
    public boolean remove()
    {
        return _close;
    }

    private void update()
    {

    }
    private void draw()
    {

    }
}
