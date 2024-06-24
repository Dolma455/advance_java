import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class RegisterController implements ActionListener {
    RegisterView register;

    RegisterController() {
        register = new RegisterView();
        register.submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = register.name.getText();
        String email = register.email.getText();
        String gender;
        if (register.male.isSelected()) {
            gender = "Male";
        } else if (register.female.isSelected()) {
            gender = "Female";
        } else {
            gender = "Not specified";
        }

        String courses = register.operationComboBox.getSelectedItem().toString();

        String language = "";
        if (register.languageCheckBox1.isSelected()) {
            language += "Java ";
        }
        if (register.languageCheckBox2.isSelected()) {
            language += "Python ";
        }
        if (register.languageCheckBox3.isSelected()) {
            language += "Ruby ";
        }

        int age = register.ageSlider.getValue();

        // Create a new DbConnect object
        DbConnect dbConnect = new DbConnect();

        // Insert the data into the table
        dbConnect.insertData(name, email, gender, courses, language, age);

        // Retrieve the data from the table
        List<User> userList = dbConnect.retrieveAllData();

        // Update the table with the data
        String[] columnNames = { "Name", "Email", "Gender", "Courses", "Languages", "Age" };
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        for (User user : userList) {
            Object[] row = { user.getName(), user.getEmail(), user.getGender(), user.getCourses(), user.getLanguages(),
                    user.getAge() };
            tableModel.addRow(row);
        }

        JTable userTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(userTable);
        register.userDetailsPanel.removeAll();
        register.userDetailsPanel.add(scrollPane, BorderLayout.CENTER);
        register.userDetailsPanel.revalidate();
        register.userDetailsPanel.repaint();
    }

    public static void main(String[] args) {
        new RegisterController();
    }
}
