package api.dtos.responses;

import api.dtos.requests.CreateUserData;

public class UserCreate extends CreateUserData {
    private String createdAt;
    private String id;
    public UserCreate() {
    }
    public UserCreate(String name, String job, String id, String createdAt) {
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
