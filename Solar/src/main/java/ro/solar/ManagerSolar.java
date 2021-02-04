/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.solar;

import java.sql.SQLException;

/**
 *
 * @author mihai.hulea
 */
public class ManagerSolar {

    private DBAccess db;
    public static final int UNIT_PRICE = 1;

    public ManagerSolar() throws ClassNotFoundException, SQLException {
        db = new DBAccess();
    }

    public String manager(String nume) throws SQLException {
        AccessSolar c = db.gasesteClienta(nume);
        if (c == null) {
            AccessSolar x = new AccessSolar(nume, System.currentTimeMillis());
            db.intrareClienta(x);
            return "A intrat clienta: " + x.getNume();
        } else {
            int p = bon(c.getTimp_intrare());
            db.stergeClienta(nume);
            return "A iesit clienta: " + c.getNume() + " si are de plata: " + p + " RON";
        }
    }

    private int bon(long timpIntrare) {
        //1 LEU / secunda 

        long crt = System.currentTimeMillis();
        return (int) (((crt - timpIntrare) / 1000) * UNIT_PRICE);

    }

    public static void main(String[] args) throws Exception {
        ManagerSolar p = new ManagerSolar();
        System.out.println(p.manager("Gina"));
        Thread.sleep(2000);
        System.out.println(p.manager("Gina"));
        System.out.println(p.manager("Roxana"));
    }

}
