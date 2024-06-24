import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class DbConnect {
    private final String url = "jdbc:mysql://localhost:3306/userdb";
    private final String user = "root";
    private final String password = "root";

    public DbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void insertData(String name, String email, String gender, String courses, String language, int age) {
        String sql = "INSERT INTO user (name, email, gender, courses, languages, age) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, gender);
            pstmt.setString(4, courses);
            pstmt.setString(5, language);
            pstmt.setInt(6, age);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public User retrieveData(String email) {
        String sql = "SELECT * FROM user WHERE email = ?";
        User user = new User();
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setCourses(rs.getString("courses"));
                user.setLanguages(rs.getString("languages"));
                user.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    public List<User> retrieveAllData() {
        String sql = "SELECT * FROM user";
        List<User> userList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setCourses(rs.getString("courses"));
                user.setLanguages(rs.getString("languages"));
                user.setAge(rs.getInt("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return userList;
    }

    public static void main(String[] args) {
        DbConnect dbConnect = new DbConnect();
        List<User> users = dbConnect.retrieveAllData();
        for (User user : users) {
            System.out.println(user.getName() + "  " + user.getEmail());
        }
    }
}
