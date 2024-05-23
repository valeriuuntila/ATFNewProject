package utils.faker;


import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;
public class FakeGenerateData {
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());
    public String generateEmail() {
        String email = fakeValuesService.bothify("????##@gmail.com");
        return email;
    }
    public String generateAlphaNumericValues() {
        String alphaNumericString = fakeValuesService.regexify("[a-z1-9]{10}");
        return alphaNumericString;
    }
}
