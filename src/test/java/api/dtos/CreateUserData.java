package api.dtos;

public class CreateUserData {
    private String name;
    private String job;

    public CreateUserData() {
    }

    public CreateUserData(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

}
