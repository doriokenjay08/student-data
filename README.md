/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author drinc
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private final String URL = "jdbc:sqlite:C:/dito/cc3sql/mydata.sqlite";

    public Repository() {
    }

    public void insertStudent(Student student) {

        String sql = """
            INSERT INTO Student
            (StudentId, firstName, lastName, age, course, ContactNo, email, YearLevel, FavoriteColor, address)
            VALUES (?,?,?,?,?,?,?,?,?,?)
        """;

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setInt(4, student.getAge());
            ps.setString(5, student.getCourse());
            ps.setInt(6, student.getContactNo());
            ps.setString(7, student.getEmail());
            ps.setInt(8, student.getYearLevel());
            ps.setString(9, student.getFavoriteColor());
            ps.setString(10, student.getAddress());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Student student = new Student.StudentBuilder()
                        .setStudentId(rs.getInt("StudentId"))
                        .setFirstName(rs.getString("firstName"))
                        .setLastName(rs.getString("lastName"))
                        .setAge(rs.getInt("age"))
                        .setCourse(rs.getString("course"))
                        .setContactNo(rs.getInt("ContactNo"))
                        .setEmail(rs.getString("email"))
                        .setYearLevel(rs.getInt("YearLevel"))
                        .setFavoriteColor(rs.getString("FavoriteColor"))
                        .setAddress(rs.getString("address"))
                        .build();

                students.add(student);
            }

        } catch (SQLException e) {
        }

        return students;
    }

    public String getURL() {
        return URL;
    }
}
