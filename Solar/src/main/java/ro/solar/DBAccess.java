/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.solar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {

    private Connection conn;

    public DBAccess() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost/test_db4;create=false", "APP", "APP");
    }

    public void intrareClienta(AccessSolar e) throws SQLException {
        Statement s = conn.createStatement();
        s.executeUpdate("INSERT INTO CLIENTE VALUES ('" + e.getNume() + "'," + e.getTimp_intrare() + ")");
        s.close();
    }

    public AccessSolar gasesteClienta(String nume) throws SQLException {
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM CLIENTE WHERE NUME='" + nume + "'");
        if (rs.next()) {
            return new AccessSolar(rs.getString("nume"), rs.getLong("timp_intrare"));
        } else {
            return null;
        }
    }

    public void stergeClienta(String nume) throws SQLException {
        Statement s = conn.createStatement();
        s.executeUpdate("DELETE FROM CLIENTE WHERE NUME='" + nume + "'");
    }

    public String afisareCliente() throws SQLException {
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM CLIENTE");
        String result = "";
        while (rs.next()) {
            result += rs.getString("nume") + "\n";
        }

        return result;
    }

    public int numarCliente() throws SQLException {
        Statement s = conn.createStatement();
        int numar = 0;
        ResultSet rs = s.executeQuery("SELECT count(nume) FROM CLIENTE");
        if (rs.next()) {
            numar = rs.getInt(1);
        }

        return numar;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBAccess db = new DBAccess();

        AccessSolar result = db.gasesteClienta("Anca");
        System.out.println(result);
        if (result != null) {
            db.gasesteClienta(result.getNume());
            System.out.println("Clienta sters!");
        } else {
            System.out.println("Clienta nu a fost gasita!");
        }

    }

}
