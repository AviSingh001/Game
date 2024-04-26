import javax.swing.ImageIcon;
import java.awt.Graphics;
public class Player extends Sprite {
    

    Player(){
        w=100;
        h=100;
        x=100;
        y=600;

        i=new ImageIcon(Player.class.getResource("3.gif")); //for gif use image icon
    }

    public void move(){
        x=x+speed;
    }

    public boolean outOfScreen(){
        return x>1400;
    }

    
    public static void main(String[] args) {
        
    }
}
