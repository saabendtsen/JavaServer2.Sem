import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

public class MyServer {
    public static void main(String[] args){
        try{
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();//establishes connection
            DataInputStream dis=new DataInputStream(s.getInputStream());
            String str=(String)dis.readUTF();

            if (str.equals("Tid")){
                System.out.println(LocalDateTime.now());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());

                LocalDateTime dateout =LocalDateTime.now();
                //dout.writeByte(dateout);

            } if (str.equals("Q")){
                ss.close();
            }
            System.out.println("message= "+str);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}