/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs2.ssatr.ia;

/**
 *
 * @author Roxana
 */
public class TestControler {
    public static void main(String[] args) {
        Controler controler = new Controler(new Sensor(2, "Sibiu"));
        controler.control();
    }
}
