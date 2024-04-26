import javax.swing.ImageIcon;
import java.awt.Graphics;
public class Enemy extends Sprite{
    Enemy(int x,int speed){
        this.x=x;
        this.speed=speed;
        w=200;
        h=200;
        y=10;
         
       // speed=100;

        i=new ImageIcon(Player.class.getResource("1.gif")); //for gif use image icon
    }

    public void move(){
        if(y>800){
            y=0;
        }
        y=y+speed;
    }

    public static void main(String[] args) {
    }
}
