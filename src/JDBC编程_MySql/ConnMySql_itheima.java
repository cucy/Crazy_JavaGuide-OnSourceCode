package JDBC编程_MySql;

import java.sql.*;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/25 16:01
 * @Description： 本段程序来自IT黑马，用来测试我是否连上数据库。
 */
public class ConnMySql_itheima {
    public static void main(String[] args)  {

        try {
//        Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());//在new Driver（）的时候就已经注册了。所以相当于注册两遍。

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root","0206");

            Statement connStatement = conn.createStatement();

            String sql="select * from stu";
            ResultSet resultSet = connStatement.executeQuery(sql);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double score = resultSet.getDouble("score");

                System.out.println("id="+id+"name="+name+"score"+score);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
