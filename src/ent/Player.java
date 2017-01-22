import org.lwjgl.glfw.*;

class Player extends BaseEntity
{
    public Player()
    {
        _hitbox = hitbox(0,0);
        _sprite = ImageLoader.LoadImage("res/blue.png");
    }

    public void update()
    {
        double[] x = new double[2];
        double[] y = new double[2];
        GLFW.glfwGetCursorPos(_room.getWindow().handle(),x,y);
        //System.out.println("x: " + x[0]+ "y: " + y[0]);
        _hitbox.set_x((int)x[0]);
        _hitbox.set_y((int)y[0]);

        if (_room.place_meeting(this))
        {
            _hitbox.set_xy(500,500);
        }
    }

    private static Hitbox hitbox(int x, int y)
    {
        int w = 32;
        int h = 32;

        return new Hitbox(x,y, w, h,0,0);
    }
}
