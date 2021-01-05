/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.parking;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Roxana
 */

public class Server {
    
    private static final Map<String, Instant> parkedCars = new HashMap<>();
    private static final double costPerSecond = 2;
    
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4050);
    
    while (true) {
            System.out.println("Astept conexiune de la client...");
            Socket s = ss.accept(); //metoda blocanta
            System.out.println("Clientul s-a conectat!");
            //......
            BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            //......
            String line = "";
            while (!line.equals("close connection")) {
                line = fluxIn.readLine();
                if (parkedCars.containsKey(line)) {
                    fluxOut.println("Iesire " + line + " Cost: " + (Instant.now().getEpochSecond() - parkedCars.get(line).getEpochSecond()) * costPerSecond + " lei");
                    parkedCars.remove(line);
                } else {
                    parkedCars.put(line, Instant.now());
                    fluxOut.println("Intrare " + line + " Ora: " + Instant.now());
                }
            }
            s.close();
        }
    }
}


