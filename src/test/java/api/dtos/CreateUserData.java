package api.dtos;

public class CreateUserData {
    private String name;
    private String job;
    private String id;

    public CreateUserData() {
    }

    public CreateUserData(String name, String job, String id) {
        this.name = name;
        this.job = job;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getId() {
        return id;
    }
}
