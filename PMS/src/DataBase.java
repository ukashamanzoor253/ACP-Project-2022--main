import javax.swing.*;
import java.sql.*;

public class DataBase {
    public Connection connection= null;
    public Statement statement= null;
    public ResultSet resultSet= null;
    String fUrl = "D://UNI//4 TH Fall 2022//Advanced Computer Programming//Assignment//assignment2//PMS_dbs.accdb";
    String URL = "jdbc:ucanaccess://" + fUrl;
    DataBase (){
        //constractor is empity;
    };

    public void makeConnection (){
        try {
            connection= DriverManager.getConnection(URL);
            JOptionPane.showMessageDialog(null,"Coneccted Seccessfully");
        } catch (SQLException e) {
            throw new RuntimeException("Connection Problem");
        }
    }
    public Connection receiveConecction (){
        try {
            connection= DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException("Connection Problem");
        }
        return connection;
    }
    public void createStatement ( ){

        try {
            statement= connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException("Statement Proble");
        }
    }
    public void QueryExecute (String q)  {

        try {
            statement.executeQuery(q);
            JOptionPane.showMessageDialog(null,"Seccessfully Inserted");

        } catch (SQLException e) {
            throw new RuntimeException("Query Problem");
        }

    }
    public ResultSet reciveResult (String q){
        try {
           resultSet= statement.executeQuery(q);
        } catch (SQLException e) {
            throw new RuntimeException("problem acceure");
        }
        return resultSet;
    }
public void closeConnection ()
{
    try {
        connection.close();
    } catch (SQLException e) {
        throw new RuntimeException("Problem with close connection");
    }
}



}



















/*
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DataBase {
        DataBase(){


        Connection connection = null;
        try {
           // String msAccDB = "d://java programming store//HospitalDBs.accdb";

          //  String u = "jdbc:ucanacess://D://UNI//4 TH Fall 2022//Advanced Computer Programming//Assignment//assignment2//PMS_dbs.accdb";
        //   connection = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Usman Saeed//Documents//std.accdb");
            connection = DriverManager.getConnection(dbURL);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("Select * from Doctor");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "  " +
                        resultSet.getString(2));
                connection.close();
            }


        } catch (Exception e) {
            throw new RuntimeException("some thing went wrong! ");
        }
    }}*/
