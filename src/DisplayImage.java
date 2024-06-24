import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;

public class DisplayImage extends JFrame {
    public DisplayImage() {
        ImageIcon imageIcon = new ImageIcon(
                "C:\\Users\\Admin\\OneDrive\\Desktop\\6thSem\\Ad Java\\AdJava\\src\\hi.jpg");
        JButton button = new JButton("Button Text", imageIcon);
        button.setPreferredSize(new Dimension(50, 50));
        add(button);
        pack();
    }

    public static void main(String[] args) {
        DisplayImage frame = new DisplayImage();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
