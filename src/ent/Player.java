import org.lwjgl.glfw.*;

class Player extends BaseEntity
{
    public static int grav = 5;

    public Player()
    {
        _hitbox = hitbox(0,0);
        _sprite = ImageLoader.LoadImage("res/blue.png");
    }

    public void update()
    {
        set_x(input().getMouseX());
        set_y(input().getMouseY());
        
    }

    private static Hitbox hitbox(int x, int y)
    {
        int w = 32;
        int h = 32;

        return new Hitbox(x,y, w, h,0,0);
    }
    private void set_x(int x)
    {
        _hitbox.set_x(x);
    }
    private void set_y(int y)
    {
        _hitbox.set_y(y);
    }
}
