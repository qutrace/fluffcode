abstract class BaseEntity
{
    //protected int _x;
    //protected int _y;
    protected Room _room;
    protected Sprite _sprite;
    protected Hitbox _hitbox;


    public abstract void update();

    public BaseEntity()
    {

    }
    public void setRoom(Room r)
    {
        _room = r;
    }



    //abstract void draw();
    public void draw()
    {
        if (_sprite != null)
        {
            _sprite.draw(_hitbox.x(),_hitbox.y());
            //System.out.println("draw");
        }
    }

    public Hitbox get_hitbox()
    {
        return _hitbox;
    }

    public boolean collides_with(BaseEntity e)
    {
        if (_hitbox != null)
            return _hitbox.collides_with(e.get_hitbox());
        return false;
    }
}
