package configuration;

import io.cucumber.java.ParameterType;
import utils.endpoints.EndPoints;

public class CustomParams {
    @ParameterType(".*")
    public EndPoints endpoints(String endpoint) {
        return EndPoints.valueOf(endpoint);
    }
}
