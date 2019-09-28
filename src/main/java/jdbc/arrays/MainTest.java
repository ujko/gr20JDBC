package jdbc.arrays;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MainTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        wypiszTablice();
//        List<Test> list = getAsList();
//        list.forEach(System.out::println);
        Test t = new Test()
                .setId(1)
                .setName("fsdsdf");
        System.out.println(t);
    }

    private static List<Test> getAsList() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbConnection = "jdbc:mysql://localhost:3306/mysql?useTimezone=true&serverTimezone=UTC";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "example");
        Connection connection = DriverManager.getConnection(dbConnection, properties);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from test");
        List<Test> result = new ArrayList<>();
//        while (resultSet.next()) {
//            result.add(new Test(resultSet.getInt("id"),
//                    resultSet.getString("name")));
//        }
        resultSet.close();
        statement.close();
        connection.close();
        return result;
    }

    private static void wypiszTablice() throws ClassNotFoundException, SQLException {
        Object[][] res = createArray();
        for(int i =0; i< res.length; i++) {
            for(int j=0; j<res[i].length;j++) {
                System.out.print(res[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private static Object[][] createArray() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbConnection = "jdbc:mysql://localhost:3306/mysql?useTimezone=true&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(dbConnection, "root", "example");
        Statement statement = connection.createStatement();
        ResultSet ilosc = statement.executeQuery("select count(*) from test");
        int iloscWierszy = 0;
        if(ilosc.next()) {
            iloscWierszy = ilosc.getInt(1);
        }
        ResultSet resultSet = statement.executeQuery("select * from test");
        Object[][] result = new Object[iloscWierszy][2];

        int i = 0;
        while (resultSet.next()) {
            result[i] = new Object[]{resultSet.getInt("id"),
                    resultSet.getString("name")};
            i++;
        }
        resultSet.close();
        statement.close();
        connection.close();
        return result;
    }
}
