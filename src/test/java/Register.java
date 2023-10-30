public class Register {
    private String id;
    private String user;

    public Register(String login, String password) {
        this.id = login;
        this.user = password;
    }

    public String getLogin() {
        return id;
    }

    public String getPassword() {
        return user;
    }
}
