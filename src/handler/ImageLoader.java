import org.lwjgl.opengl.*;
import java.io.*;

import java.nio.ByteBuffer;
import org.newdawn.slick.opengl.PNGDecoder;

class ImageLoader
{
    public static Sprite LoadImage(String location)
    {
        int texture = GL11.glGenTextures();
        int rect = ARBTextureRectangle.GL_TEXTURE_RECTANGLE_ARB;

        GL11.glBindTexture(rect, texture);
        InputStream in;
        int w = 0;
        int h = 0;
        boolean fail = false;

        try
        {
            in = new FileInputStream(location);
            PNGDecoder de = new PNGDecoder(in);

            w = de.getWidth();
            h = de.getHeight();

            ByteBuffer buffer = ByteBuffer.allocateDirect(4*w * h);
            de.decode(buffer,w*4,PNGDecoder.RGBA);
            buffer.flip();
            in.close();

            GL11.glTexParameteri(rect,GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            GL11.glTexParameteri(rect,GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);

            int rgba = GL11.GL_RGBA;
            GL11.glTexImage2D(rect,0,rgba,w,h,0,rgba,GL11.GL_UNSIGNED_BYTE,buffer);

        }
        catch(FileNotFoundException e)
        {
            String errMsg = "File not found";
            System.err.println(errMsg);
            fail = true;
        }
        catch(IOException e)
        {
            String errMsg = "Failed to load Texture";
            System.err.println(errMsg);
            fail = true;
        }

        GL11.glBindTexture(rect,0);
        Sprite s = new Sprite();
        s.set(texture,w,h,fail);
        return s;
    }
}
