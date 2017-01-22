class Hitbox
{
    private int w;
    private int h;
    private int ax;
    private int ay;
    private int x;
    private int y;


    public Hitbox()
    {

    }
    public Hitbox (int startx,int starty, int width, int height)
    {
        x = startx;
        y = starty;
        w = width;
        h = height;
    }
    public Hitbox(int nx, int ny, int nw, int nh, int nax, int nay)
    {
        x = nx;
        y = ny;
        w = nw;
        h = nh;
        ax = nax;
        ay = nay;

    }

    public int x()
    {
        return x;
    }
    public int y()
    {
        return y;
    }

    public void set_x(int newx)
    {
        x = newx;
    }
    public void set_y(int newy)
    {
        y = newy;
    }
    public void set_xy(int newx, int newy)
    {
        set_x(newx);
        set_y(newy);
    }

    public int right()
    {
        return x + w - ax;
    }
    public int left()
    {
        return x - ax;
    }
    public int top()
    {
        return y - ay;
    }
    public int bot()
    {
        return y + w - ay;
    }


    public boolean collides_with(Hitbox h)
    {
        if (h == null)
            return false;

        if (right() > h.left() && left() < h.right())
        {
            if(bot() > h.top() && top() < h.bot())
            {
                return true;
            }
        }
        return false;
    }

    public boolean place_meeting(int nx,int ny, Hitbox h)
    {
        int ox = x;
        int oy = y;
        x = nx;
        y = ny;
        if (h == null)
            return false;

        if (right() > h.left() && left() < h.right())
        {
            if(bot() > h.top() && top() < h.bot())
            {
                x = ox;
                y = oy;
                return true;
            }
        }
        x = ox;
        y = oy;
        return false;
    }
}
