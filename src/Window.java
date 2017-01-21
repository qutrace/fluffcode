import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

class Window
{

    private Long _windowHandle;
    private boolean _close;
    private static boolean TEST = true;
    private GLFWErrorCallback _errorCallback;

    private int _weit;
    private int _hoch;

    public Window()
    {
        init();
    }

    public void step()
    {
        //set error Callback
        GLFW.glfwSetErrorCallback(_errorCallback);
        init_gl();

        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        update();
        draw();

        GLFW.glfwPollEvents();

        GLFW.glfwSwapBuffers(_windowHandle);
        GLFW.glfwSwapBuffers(_windowHandle);

        checkCloseCondition();
    }

    public void init()
    {
        init_glfw();
        init_gl();
        GLFW.glfwShowWindow(_windowHandle);
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

        _weit = m_width;
        _hoch = m_height;

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
        //glfwSwapInterval needs a context on the calling thread,
        //otherwise will cause NO_CURRENT_CONTEXT error
        GLFW.glfwMakeContextCurrent(_windowHandle);

        //Will let lwjgl know we want to use this context
        //as the context to draw with
        GL.createCapabilities();

        GL11.glClearColor(0.3f,0.3f,0.3f,0.0f);
        init_gl_projection();
    }

    private void init_gl_projection()
    {
        GL11.glViewport(0, 0, _weit, _hoch);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, _weit , _hoch, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
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
