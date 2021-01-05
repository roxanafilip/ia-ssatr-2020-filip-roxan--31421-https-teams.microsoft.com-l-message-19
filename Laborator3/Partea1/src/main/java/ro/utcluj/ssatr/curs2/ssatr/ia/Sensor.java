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
public class Sensor {
    int value;
    String location;
    public Sensor(int value, String location) {
        this.value = value;
        this.location = location;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int hashCode() {
        return  location.hashCode();
    }
    public boolean equals(Object obj) {
        if(obj==null||!(obj instanceof Sensor) )
            return false;
        Sensor x = (Sensor)obj;
        return x.location.equals(location);
    }
    public static void main(String[] args) {
        Sensor sensor1 = new Sensor(4, "Alba");
	Sensor sensor2 = new Sensor(6, "Arad");
        Sensor sensor3 = new Sensor(2, "Bucuresti");
	if(sensor1.equals(sensor2))
		System.out.println("Sersors are equals");
	else
		System.out.println("Sersors are not equals");
        if(sensor1.equals(sensor3))
		System.out.println("Sersors are equals");
	else
		System.out.println("Sersors are not equals");
    }   
}
