package api.dtos;

public class UserCreateResponse extends CreateUserData {
    private String createdAt;
    private String id;

    public UserCreateResponse() {
    }

    public UserCreateResponse(String name, String job, String id, String createdAt) {
        super(name, job);
        this.createdAt = createdAt;
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

}
