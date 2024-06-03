package api.dtos.responses;

import api.dtos.requests.UserData;

public class User extends UserData {
    private String createdAt;
    private String id;
    public User() {
    }
    public User(String name, String job, String id, String createdAt) {
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
