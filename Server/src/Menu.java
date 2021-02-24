public class Menu {

    StringBuilder st = new StringBuilder();

    public String mainMenu(){
        //m = Menu protocol
        st.append("m:");

        st.append("Main Menu;");
        st.append("1. Hear a joke;");
        return st.toString();
    }
}
