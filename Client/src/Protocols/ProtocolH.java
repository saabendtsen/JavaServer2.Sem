package Protocols;

public class ProtocolH {


    public String checkP(String input){

        if (input.contains("m:")) {
        Menu menu = new Menu();

        String cmd = menu.mainMenu(input);
        return cmd;

        }


        if(input.contains("j:")){
            Joke j = new Joke();
            return j.jokePrint(input);
        }

        return "";
    }
}
