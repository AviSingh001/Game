import javax.swing.*;
import java.awt.*;
public class GameFrame extends JFrame{

    GameFrame(){
        Board board=new Board();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("GAME");
        setSize(1400,800);
        setLocation(0,0);
        setResizable(false);
       // setLocationRelativeTo(null);
        add(board);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GameFrame();
    }
}