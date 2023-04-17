/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

import java.sql.*;

/**
 *
 * @author Naratama
 */
public class JdbcConn {
   public static Connection connection;

   public static void main(String[] args) throws Exception {
      try {
         Class.forName("org.postgresql.Driver");
      } catch (ClassNotFoundException e) {
         System.out.println("Class not found " + e);
      }

      try {
         Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tp2", "postgres",
               "postgres");
         connection = conn;
      } catch (SQLException e) {
         System.out.println("SQL exception occured" + e);
      }
   }
}
