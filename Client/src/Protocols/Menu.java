package Protocols;

import java.util.Scanner;

public class Menu{


    public String mainMenu(String s) {

            for (int i = 1; i < s.split(";").length; i++) {
                System.out.println(s.split(";")[i]);
        }
        Scanner scn = new Scanner(System.in);
        System.out.println("Vælg et menu punkt");
        String cmd = scn.nextLine();
        return cmd;
    }
}
