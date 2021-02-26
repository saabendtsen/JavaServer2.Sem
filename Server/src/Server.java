import Protoco.Protocols;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    private ArrayList<User> users = new ArrayList<User>();
    private Menu menu = new Menu();
    private Protocols ph = new Protocols();

    public Server(int port) {

        //Fake user creation

        users.add(new User("bob","123",100));
        users.add(new User("kim","123",101));
        users.add(new User("ha","123",102));


        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
            int counter = 0;

            //String tmpLoginData = "bob:123";
            String tmpLoginData = in.readUTF();

            if(checklogin(tmpLoginData.split(":")[0],tmpLoginData.split(":")[1]) == 0){
                //du har tastet forkert
                //Du forkert
                out.writeUTF("e:Forkert user eller password!");
                socket.close();
                in.close();
                out.close();
                System.exit(0);
            } else {
                //du er inde
                int token = checklogin(tmpLoginData.split(":")[0],tmpLoginData.split(":")[1]);
                out.writeUTF("w:Velkommen til "+ tmpLoginData.split(":")[0]);
                out.writeUTF("t:" + token);
                out.writeUTF(menu.mainMenu());

            }





            String ClientLine = "";
            String response= "";
            while (!ClientLine.equalsIgnoreCase(("Over"))) {
                try {
                    //ClientLine = in.readUTF();
                    ClientLine = in.readUTF();
                    //System.out.println("Client siger: " +ClientLine);
                    response = ph.checkP(ClientLine);
                    out.writeUTF(response);

                   // out.writeUTF(ClientLine);
                    // out.flush();


                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            socket.close();
            in.close();
            out.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public int checklogin(String username, String password){
        for (User u : users){
            if(u.getUsername().equals(username) && u.getPasswork().equals(password)){
                return u.getUserId();
            } else {
                continue;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        Server server = new Server(5000);

    }
}
