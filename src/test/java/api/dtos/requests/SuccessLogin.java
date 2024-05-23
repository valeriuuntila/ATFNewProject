package api.dtos.requests;

public class SuccessLogin {
    private String email;
    private String password;
    public SuccessLogin() {
    }

    public SuccessLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
