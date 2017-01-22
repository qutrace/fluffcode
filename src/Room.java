import java.util.*;

public class Room
{
    private Window _win;
    private List<BaseEntity> _content;

    public Room(Window w)
    {
        _win = w;
        _content = new ArrayList<BaseEntity>(10);

    }
    public Window getWindow()
    {
        return _win;
    }

    public void update()
    {
        for (BaseEntity ent : _content)
        {
            ent.update();
        }
    }

    public void add(BaseEntity e)
    {
        e.setRoom(this);
        _content.add(e);
    }

    public void draw()
    {
        for(BaseEntity ent : _content)
        {
            ent.draw();
        }
    }

    public boolean place_meeting(BaseEntity e)
    {
        if (_content.contains(e))
        {
            for (BaseEntity ent : _content)
            {
                if (ent != e)
                {
                    if (e.collides_with(ent))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
