import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultField;
    private JComboBox<String> operationComboBox;
    private JButton submitButton;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Title label
        JLabel titleLabel = new JLabel("Calculator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Create form panel with GridBagLayout
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Num 1 label and text field
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Num 1:"), gbc);
        gbc.gridx = 1;
        num1Field = new JTextField(10);
        formPanel.add(num1Field, gbc);

        // Num 2 label and text field
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Num 2:"), gbc);
        gbc.gridx = 1;
        num2Field = new JTextField(10);
        formPanel.add(num2Field, gbc);

        // Operation dropdown
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Operation:"), gbc);
        gbc.gridx = 1;
        String[] operations = {"Add", "Subtract", "Multiply"};
        operationComboBox = new JComboBox<>(operations);
        formPanel.add(operationComboBox, gbc);

        // Result label and text field
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Result:"), gbc);
        gbc.gridx = 1;
        resultField = new JTextField(10);
        resultField.setEditable(false);
        formPanel.add(resultField, gbc);

        // Submit button
        gbc.gridx = 1;
        gbc.gridy = 4;
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        formPanel.add(submitButton, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            String operation = (String) operationComboBox.getSelectedItem();
            switch (operation) {
                case "Add":
                    result = num1 + num2;
                    break;
                case "Subtract":
                    result = num1 - num2;
                    break;
                case "Multiply":
                    result = num1 * num2;
                    break;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}
