import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;


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
        Scanner sc = new Scanner(System.in);
        System.out.println("Indtast user");
        String user = sc.nextLine();
        System.out.println("Indtast password");
        String password = sc.nextLine();
        out.writeUTF(user+":"+password);


        String loginRespose = input.readUTF();
        String loginToken;

        System.out.println(loginRespose);

        //Test welcome
        if (loginRespose.contains("w:")){
            loginToken = input.readUTF();
            System.out.println(":" + loginToken);
        }
        if (loginRespose.contains("e:")){
            System.out.println("du sutter");
        }


        String line = "";
        while (!line.equals("Over")) {
            try {
                line = sc.nextLine();
                out.writeUTF(line);
                out.flush();
                System.out.println(input.readUTF());


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

    public static void main(String args[]) throws IOException {
        Client client = new Client("127.0.0.1", 5000);
    }
}
