/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplodatagramsocketemisorreceptor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 *
 * @author otorradomiguez
 */
public class EjemploDatagramSocketEmisorReceptor {

    public static void main(String[] args) {
        try {
            System.out.println("Creando socket datagrama");

            InetSocketAddress addr = new InetSocketAddress("10.0.6.24", 5555);
            DatagramSocket datagramSocket = new DatagramSocket(addr);

            System.out.println("Recibiendo mensaje");

            byte[] mensaje = new byte[25];
            DatagramPacket datagrama1 = new DatagramPacket(mensaje, 25);
            datagramSocket.receive(datagrama1);

            System.out.println("Mensaje recibido: " + new String(mensaje));

            System.out.println("Enviando mensaje");

            InetAddress addr2 = InetAddress.getByName("localhost");
            DatagramPacket datagrama2
                    = new DatagramPacket(mensaje, mensaje.length, addr2, 5555);
            datagramSocket.send(datagrama2);

            System.out.println("Mensaje enviado");

            System.out.println("Cerrando el socket datagrama");

            datagramSocket.close();

            System.out.println("Terminado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
