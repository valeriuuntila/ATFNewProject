package api.dtos.responses;

import api.dtos.requests.UserData;

public class UserUpdate extends UserData {
    private String updatedAt;
    public UserUpdate() {
    }
    public UserUpdate(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
}
