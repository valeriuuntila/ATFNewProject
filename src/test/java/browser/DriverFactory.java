package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum DriverFactory {
    CHROME {
            public DriverManager getDriverManager() {
            return new ChromeDriverManager();
        }
    }
}
