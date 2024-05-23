package api.dtos.responses;

public class UnSuccessLogin {
    private String error;
    public UnSuccessLogin() {
    }
    public UnSuccessLogin(String error) {
        this.error = error;
    }
    public String getError() {
        return error;
    }
}