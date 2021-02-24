import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try{
            Socket s=new Socket("localhost",6666);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());


            Scanner sc = new Scanner(System.in);
            System.out.println("Hallo prøv lige at skrive tid med stort t");
            String input = sc.nextLine();


            dout.writeUTF(input);
            dout.flush();
            dout.close();
            s.close();
        }catch(Exception e){System.out.println(e);}
    }
}
