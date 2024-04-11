package api.dtos;

public class UserUpdateResponse extends UpdateUserData {
    private String updatedAt;

    public UserUpdateResponse() {
    }

    public UserUpdateResponse(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
