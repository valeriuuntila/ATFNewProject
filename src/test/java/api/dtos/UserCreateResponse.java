package api.dtos;

public class UserCreateResponse extends CreateUserData{
    private String createdAt;

    public UserCreateResponse() {
    }

    public UserCreateResponse(String name, String job, String id, String createdAt) {
        super(name, job, id);
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

}
