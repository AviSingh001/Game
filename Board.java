import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Board extends JPanel {
    Timer timer;
    BufferedImage bgImage;
    Player player;
    Enemy enemies[]=new Enemy[4];
    Board(){

        setSize(1400,800);
        loadBackgroundImage();
        player=new Player();
        loadEnemies();
        gameLoop();
        
        bindEvents();
         setFocusable(true);
        
    }

    private void gameOver(Graphics pen){
        if(player.outOfScreen()){
            pen.setFont(new Font("System", Font.BOLD, 30));
            pen.setColor(Color.GREEN);
            pen.drawString("GAME WINS",1400/2,800/2);
            timer.stop();

        }
        for(Enemy enemy:enemies){
            if(isCollide(enemy)){
                pen.setFont(new Font("System", Font.BOLD, 30));
                pen.setColor(Color.RED);
                pen.drawString("GAME OVER",1400/2,800/2);
                timer.stop();
            }
        }
    }



    private boolean isCollide(Enemy enemy){
        int xDistance=Math.abs(player.x-enemy.x);
        int yDistance=Math.abs(player.y-enemy.y);
        int maxH=Math.max(player.h,enemy.h);
        int maxW=Math.max(player.w,enemy.w);
        return xDistance<=maxW-40 && yDistance<=maxH-40;
    } 

    private void bindEvents(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                player.speed=3;
                }
                else if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    player.speed=-3;
                }
                
            }
            @Override
            public void keyReleased(KeyEvent e) {
                player.speed=0;
                
            }
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
            }
        });
    }

    private void loadEnemies(){
        int x=250;
        int gap=280;
        int speed=3;
        for(int i=0;i<enemies.length;i++){
             enemies[i]=new Enemy(x,speed);
             x= x + gap;
             speed=speed+3;
        }
    }

    private void gameLoop(){
        timer=new Timer(100,(e)->repaint());
        timer.start();
    }

    private void loadBackgroundImage(){
       try {
       bgImage= ImageIO.read(Board.class.getResource("bg.jpg")); //disc s ram m
       } catch (Exception e) {
        System.out.println("BackGround Image Not Found");
        System.exit(1);
        e.printStackTrace();
       } 
    }

    private void printEnemies(Graphics pen){
        for(Enemy enemy : enemies){
            enemy.draw(pen);
            enemy.move();
        }
    }


    @Override
    public void paintComponent(Graphics pen) {
       
        super.paintComponent(pen); // clean up
         //all printing logic will be here

         pen.drawImage(bgImage,0,0,1500,800,null);
         player.draw(pen);
         player.move();
         printEnemies(pen);
         gameOver(pen);

    }

    public static void main(String[] args) {
        
    }
}
