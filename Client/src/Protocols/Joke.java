package Protocols;

import java.util.Scanner;

public class Joke {

    Scanner scn = new Scanner(System.in);

    public String jokePrint(String s){
        System.out.println(s.split(":")[1]);
        return askForComment();

    }


    public String askForComment(){
        System.out.println("Please give me a comment om my joke");
        String comment = scn.nextLine();
        return "c:" + comment;
    }
}
