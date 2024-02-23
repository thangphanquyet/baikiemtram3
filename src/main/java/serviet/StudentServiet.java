package serviet;

import controller.ConnectionDB;
import model.Address;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentServiet {
    public static Connection connection = ConnectionDB.getConnection();
    public AddressServiet addressServ = new AddressServiet();


    public List<Student> showList(String searchQuery) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select * from student where name like ?;");
        statement.setString(1, "%" + searchQuery + "%");
//        // tra ve thong tin
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            //lay thong tin o bang address
            int add_id = rs.getInt("addressid");
            String address = addressServ.getAddressByID(add_id).getName();

            Student student = new Student(id, name, age, address);
            studentList.add(student);
        }
        return studentList;
    }
    public static void insertStudentToDataBase(Student student) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("insert into student (name, age, addressid) values (?,?,?);");
//            statement.setInt(1, StudentServiet.generateRandomInt());
            statement.setString(1,student.getName());
            statement.setInt(2,student.getAge());
            statement.setInt(3,student.getAddressId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Address> showAddressList() throws SQLException{
        List<Address> studentList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select * from address;");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {

            //lay thong tin o bang address
            int id = rs.getInt("id");
            String name = rs.getString("address");

            Address address = new Address(id, name);
            studentList.add(address);
        }
        return studentList;
    }

    //    public static int generateRandomInt() {
//        Random random = new Random();
//        return random.nextInt(); // Trả về một số nguyên ngẫu nhiên
//    }
    public static void delete(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from student where id=?;");
        statement.setInt(1,id);
        statement.executeUpdate();
    }
}
