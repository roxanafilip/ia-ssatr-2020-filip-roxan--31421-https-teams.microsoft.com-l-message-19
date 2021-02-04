/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.solar;

/**
 *
 * @author mihai.hulea
 */
public class AccessSolar {

    private String nume;
    private long timp_intrare;

    public AccessSolar(String nume, long timp_intrare) {
        this.nume = nume;
        this.timp_intrare = timp_intrare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public long getTimp_intrare() {
        return timp_intrare;
    }

    public void setTimp_intrare(long timp_intrare) {
        this.timp_intrare = timp_intrare;
    }

    @Override
    public String toString() {
        return "AccessSolar{" + "nume=" + nume + ", timp_intrare=" + timp_intrare + '}';
    }

}
