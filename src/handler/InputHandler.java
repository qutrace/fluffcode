import org.lwjgl.glfw.*;

class InputHandler
{
    Window _win;
    public InputHandler(Window w)
    {
        _win = w;
    }

    private Long handle()
    {
        return _win.handle();
    }

    public int getMouseX()
    {
        double[] x = new double[1];
        double[] y = new double[1];
        GLFW.glfwGetCursorPos(handle(),x,y);
        return (int)x[0];
    }
    public int getMouseY()
    {
        double[] x = new double[1];
        double[] y = new double[1];
        GLFW.glfwGetCursorPos(handle(),x,y);
        return (int)y[0];
    }
    public boolean getKey(int key)
    {
        if(GLFW.glfwGetKey(handle(),key) == GLFW.GLFW_PRESS)
        {
            return true;
        }
        return false;
    }

}
