package serviet;

import controller.ConnectionDB;
import model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressServiet {
    public static Connection connection = ConnectionDB.getConnection();
    public Address getAddressByID(int id){
        PreparedStatement statement1 = null;
        try {
            statement1 = connection.prepareStatement("select * from address where id=?;");
            statement1.setInt(1, id);
            ResultSet resultSet1 = statement1.executeQuery();
            int add_id =0;
            String add_name="";
            while (resultSet1.next()){
                add_id = resultSet1.getInt("id");
                add_name = resultSet1.getString("address");
            }
            return new Address(add_id, add_name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}