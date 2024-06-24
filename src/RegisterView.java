import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {
    JTextField name;
    JTextField email;
    JComboBox<String> operationComboBox;
    JRadioButton male;
    JRadioButton female;
    JButton submitButton;
    JCheckBox languageCheckBox1;
    JCheckBox languageCheckBox2;
    JCheckBox languageCheckBox3;
    JSlider ageSlider;
    public String courses;
    JPanel userDetailsPanel;

    public RegisterView() {
        setTitle("Register View");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        userDetailsPanel = new JPanel(new BorderLayout());
        userDetailsPanel.setBorder(BorderFactory.createTitledBorder("User Details"));
        mainPanel.add(userDetailsPanel, BorderLayout.EAST);

        JLabel titleLabel = new JLabel("RegisterView", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel LPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.insets = new Insets(5, 5, 5, 5);

        gbc1.gridx = 0;
        gbc1.gridy = 0;
        LPanel.add(new JLabel("Name: "), gbc1);
        gbc1.gridx = 1;
        name = new JTextField(10);
        LPanel.add(name, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 1;
        LPanel.add(new JLabel("Email:"), gbc1);
        gbc1.gridx = 1;
        email = new JTextField(10);
        LPanel.add(email, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 2;
        LPanel.add(new JLabel("Gender:"), gbc1);
        gbc1.gridx = 1;
        male = new JRadioButton("Male");
        LPanel.add(male, gbc1);
        gbc1.gridx = 2;
        female = new JRadioButton("Female");
        LPanel.add(female, gbc1);

        // Add radio buttons to a group
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        gbc1.gridx = 0;
        gbc1.gridy = 3;
        LPanel.add(new JLabel("Course:"), gbc1);
        gbc1.gridx = 1;
        String[] courses = { "BCA", "BBA", "BBS" };
        operationComboBox = new JComboBox<>(courses);
        LPanel.add(operationComboBox, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 4;
        LPanel.add(new JLabel("Language"), gbc1);
        gbc1.gridx = 1;
        languageCheckBox1 = new JCheckBox("JAVA");
        LPanel.add(languageCheckBox1, gbc1);
        gbc1.gridx = 2;
        languageCheckBox2 = new JCheckBox("Python");
        LPanel.add(languageCheckBox2, gbc1);
        gbc1.gridx = 3;
        languageCheckBox3 = new JCheckBox("Ruby");
        LPanel.add(languageCheckBox3, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 5;
        LPanel.add(new JLabel("Age:"), gbc1);
        gbc1.gridx = 1;
        ageSlider = new JSlider(JSlider.HORIZONTAL, 0, 70, 5);
        ageSlider.setMajorTickSpacing(1);
        ageSlider.setPaintTicks(true);
        ageSlider.setPaintLabels(true);
        LPanel.add(ageSlider, gbc1);

        gbc1.gridx = 1;
        gbc1.gridy = 6;
        submitButton = new JButton("Submit");
        LPanel.add(submitButton, gbc1);

        mainPanel.add(LPanel, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
    }
}
