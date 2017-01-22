class Wall extends BaseEntity
{


    public Wall()
    {
        _hitbox = hitbox(0,0);
        _sprite = ImageLoader.LoadImage("res/blue.png");
    }

    public Wall(int x, int y)
    {
        _hitbox = hitbox(x,y);
        _sprite = ImageLoader.LoadImage("res/blue.png");
    }

    public void update()
    {
        
    }

    private static Hitbox hitbox(int x, int y)
    {
        int w = 32;
        int h = 32;

        return new Hitbox(x,y, w, h);
    }
}
