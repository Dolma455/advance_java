import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;


public class DisplayGraphics extends Canvas {
    
    public void paint(Graphics g) {
        g.drawString("Hello", 40, 40);
        setBackground(Color.WHITE);
        g.fillRect(130, 30, 100, 80);
        setForeground(Color.GREEN);
        g.fillOval(130, 30, 50, 60);
        g.drawArc(30, 200, 40, 50, 90, 60);
        g.fillArc(30, 130, 40, 50, 180, 40);

        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("C:\\Users\\Admin\\OneDrive\\Desktop\\6thSem\\Ad Java\\AdJava\\src\\hi.jpg");
        g.drawImage(i, 100, 100, this);
    }


    public static void main(String[] args) {
        DisplayGraphics m = new DisplayGraphics();
        JFrame f = new JFrame();
        f.add(m);
        f.setSize(400, 400);
        f.setVisible(true);
    } 
}
