/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

import java.sql.*;
import tp2.JdbcConn;

/**
 *
 * @author Naratama
 */
public class CreateTable {
   public static void main(String[] args) throws Exception {
      try {
         JdbcConn.main(args);
      } catch (Exception e) {
         System.out.println("JdbcConn Class not found " + e);
      }
      try {
         Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tp2", "postgres",
               "postgres");
         Statement stmt = con.createStatement();
         String query = "CREATE TABLE patients (id SERIAL PRIMARY KEY,nama VARCHAR(20) unique,alamat TEXT, nik CHAR(15) unique, tanggal_lahir DATE)";
         stmt.execute(query);
         System.out.println("Patients table created");
      } catch (SQLException e) {
         System.out.println("SQL exception occured" + e);
      }
   }
}
