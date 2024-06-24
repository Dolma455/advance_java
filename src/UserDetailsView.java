import javax.swing.*;
import java.awt.*;

public class UserDetailsView extends JPanel {
    public UserDetailsView(User user) {
      //  setTitle("User Details");
        setSize(300, 200);
       // setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));

        add(new JLabel("Name: " + user.getName()));
        add(new JLabel("Email: " + user.getEmail()));
        add(new JLabel("Gender: " + user.getGender()));
        add(new JLabel("Courses: " + user.getCourses()));
        add(new JLabel("Languages: " + user.getLanguages()));
        add(new JLabel("Age: " + user.getAge()));

        setVisible(true);
    }
}