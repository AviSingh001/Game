import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class Sprite {
  public  int speed;
    int x;
    int y;
    int w;
    int h;
    ImageIcon i;

    public void draw(Graphics pen){

        pen.drawImage(i.getImage(),x,y,w,h,null);
      
    }

    public static void main(String[] args) {
        
    }
}
