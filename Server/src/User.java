public class User {

    private String username;
    private String passwork;
    private int  userId;

    public User(String username, String passwork, int userId) {
        this.username = username;
        this.passwork = passwork;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public int getUserId() {
        return userId;
    }
}
