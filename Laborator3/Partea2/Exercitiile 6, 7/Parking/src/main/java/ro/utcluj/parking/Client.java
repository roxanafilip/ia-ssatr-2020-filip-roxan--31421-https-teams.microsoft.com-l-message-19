/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.parking;
import java.io.*;
import java.net.Socket;

/**
 *
 * @author Roxana
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Ma conectez la server.");
        Socket s = new Socket("127.0.0.1", 4050);
        System.out.println("Conexiune realizata!");
        //......
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
        fluxOut.println("CJ 13 FGK");
        String response = fluxIn.readLine();
        System.out.println(response);
        fluxOut.println("AB 11 CVB");
        response = fluxIn.readLine();
        System.out.println(response);
        fluxOut.println("SB 15 VBV");
        response = fluxIn.readLine();
        System.out.println(response);
        fluxOut.println("B 45 FRE");
        response = fluxIn.readLine();
        System.out.println(response);
        Thread.sleep(5000);
        fluxOut.println("CJ 21 PIU");
        response = fluxIn.readLine();
        System.out.println(response);
        Thread.sleep(5000);
        fluxOut.println("CJ 81 OPI");
        response = fluxIn.readLine();
        System.out.println(response);
        fluxOut.println("close connection");
        response = fluxIn.readLine();
        System.out.println(response);
        s.close();
    }
   
}
