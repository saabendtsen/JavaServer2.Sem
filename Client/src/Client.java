import Protocols.ProtocolH;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    private String serverRespose;
    private Scanner sc = new Scanner(System.in);
    private ProtocolH ph = new ProtocolH();


    // constructor to put ip address and port
    public Client(String address, int port) throws IOException {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            input = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }


        //Login to server
        if (!loggedIn()) {
            input.close();
            out.close();
            socket.close();
        } else {
            String line = "";
            while (!line.equals("Over")) {
                try {
                    serverRespose = input.readUTF();
                    //System.out.println("Server svarer: " + serverRespose);
                    line = ph.checkP(serverRespose);
                    System.out.println(line);
                    out.writeUTF(line);

                    //line = sc.nextLine();
                    //out.writeUTF(line);
                   // out.flush();
                    //System.out.println(input.readUTF());

                } catch (IOException i) {
                    System.out.println(i);
                }
            }


            try {
                input.close();
                out.close();
                socket.close();
            } catch (IOException i) {
                System.out.println(i);
            }
        }
    }

    public boolean loggedIn() throws IOException {


        System.out.println("Indtast user");
        String user = sc.nextLine();
        System.out.println("Indtast password");
        String password = sc.nextLine();
        out.writeUTF(user + ":" + password);
        serverRespose = input.readUTF();

        if (serverRespose.contains("w:")) {
            System.out.println(serverRespose.split(":")[1]);
            String loginToken = input.readUTF();
            System.out.println("Token: " + loginToken);
            return true;
        }

        if (serverRespose.contains("e:")) {
            System.out.println("du sutter");
            System.out.println(serverRespose.split(":")[1]);
        }
        return false;
    }

    public static void main(String args[]) throws IOException {
        Client client = new Client("127.0.0.1", 5000);
    }
}





