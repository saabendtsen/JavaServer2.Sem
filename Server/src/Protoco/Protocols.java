package Protoco;

public class Protocols {


    public String checkP(String input){

        if (input.contains("c:")){
            System.out.println(input);
        }

        if (input.contains("j:")) {
            Joke j = new Joke();
            return j.listAJokes();
        }

        if(input.equals("are you here")){
            return ("im listning");
        }
        return "";
    }
}
