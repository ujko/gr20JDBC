import java.sql.*;

public class MainTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
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
