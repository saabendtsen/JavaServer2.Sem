package Protoco;
import java.util.ArrayList;
import java.util.Random;

public class Joke {

    private String joke;

    private ArrayList<String> jokes = new ArrayList<>();

    public String listAJokes(){
        addJoke();
        StringBuilder st = new StringBuilder();
        Random rnd = new Random();
        int rndIndex = rnd.nextInt(jokes.size());
        st.append(rndIndex + "j:");
        st.append(jokes.get(rndIndex));


        return st.toString();
    }

    private void addJoke(){
        jokes.add("En sort mand har mænd");
        jokes.add("Her er en joke om jokes");
        jokes.add("Her en 3. joke");
    }

}




