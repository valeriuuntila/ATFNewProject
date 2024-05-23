package utils.endpoints;

public enum EndPoints {
     UNKNOWN("api/unknown"),
    USERS("api/users"),
    LOGIN("api/login"),
    UPDATE_USER("/api/users/2");


    private final String endPoint;

    EndPoints(String value) {
        this.endPoint = value;
    }
    public String getValue() {
        return endPoint;
    }
}
