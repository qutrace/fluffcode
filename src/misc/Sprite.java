import org.lwjgl.opengl.*;

class Sprite
{
    private int _id;
    private int _w;
    private int _h;
    private boolean _fail;
    private boolean _ready;

    public void set(int tex_id,int w,int h,boolean fail)
    {
        _id = tex_id;
        _w = w;
        _h = h;
        _fail = fail;
        _ready = !fail;
        //System.out.println("" + _id);
    }
    public Sprite()
    {

    }
    public Sprite(int tex_id, int w, int h, boolean fail)
    {
        set(tex_id,w,h,fail);
    }

    public void draw(int x, int y)
    {
        if(_ready)
        {
            int rect = ARBTextureRectangle.GL_TEXTURE_RECTANGLE_ARB;

            GL11.glBindTexture(rect,_id);

            GL11.glBegin(GL11.GL_TRIANGLES);
                GL11.glTexCoord2f(_w,0);
                GL11.glVertex2i(x + _w,y);
                GL11.glTexCoord2f(0,0);
                GL11.glVertex2i(x,y);
                GL11.glTexCoord2f(0, _h);
                GL11.glVertex2i(x,y + _h);

                GL11.glTexCoord2f(0, _h);
                GL11.glVertex2i(x,y+_h);
                GL11.glTexCoord2f(_w,_h);
                GL11.glVertex2i(x+_w,y+_h);
                GL11.glTexCoord2f(_w,0);
                GL11.glVertex2i(x+_w,y);
            GL11.glEnd();

            GL11.glBindTexture(rect,0);

        }
    }
}
