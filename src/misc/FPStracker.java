import org.lwjgl.opengl.*;

//import java.util.*;

class FPStracker
{
    long last;
    long cur;
    int[] frames;
    int index;

    public FPStracker()
    {
        frames = new int[3];
        last = System.currentTimeMillis();
    }

    public void update()
    {
        frames[index]++;
        cur = System.currentTimeMillis();
        if (cur - last > 1000L)
        {
            last = cur;
            index = (index + 1) % 3;
            frames[index]= 0;
        }
    }

    public void draw()
    {
        for(int i = 0; i < frames.length; i++)
        {
            for(int j = 0; j < frames[i]; j++)
            {
                draw_quad(j,i);
            }
        }
        draw_quad(30,3);
        draw_quad(60,3);
        draw_quad(90,3);
    }

    private void draw_quad(int x, int y)
    {
        int w = 3;
        int h = 3;
        x = x *w;
        y = y *h;

        GL11.glBegin(GL11.GL_TRIANGLES);

        GL11.glVertex2i(x + w,y);
        GL11.glVertex2i(x,y);
        GL11.glVertex2i(x,y + h);
        GL11.glVertex2i(x, y + h);
        GL11.glVertex2i(x + w, y + h);
        GL11.glVertex2i(x + w, y);

        GL11.glEnd();
    }

    public static void test_draw()
    {
        //GL11.glBindTexture(GL_TEXTURE_RECTANGLE_ARB, sprite.id());
        GL11.glBegin(GL11.GL_TRIANGLES);
        int f = 1080;
        //glTexCoord2f(1 * f, 0);
        GL11.glVertex2i(450 , 10);
        //glTexCoord2f(0, 0);
        GL11.glVertex2i(10, 10);
        //glTexCoord2f(0, 1*f);
        GL11.glVertex2i(10, 450);

        //glTexCoord2f(0, 1 * f);
        GL11.glVertex2i(10, 450);
        //glTexCoord2f(1*f, 1*f);
        GL11.glVertex2i(450, 450);
        //glTexCoord2f(1*f, 0);
        GL11.glVertex2i(450, 10);

        GL11.glEnd();
        //glBindTexture(GL_TEXTURE_RECTANGLE_ARB,0);
    }
}
