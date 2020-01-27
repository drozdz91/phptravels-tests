package general;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static final Object lock = new Object();
    private static PropertyManager instance;
    private static String propertyFilePath;

    private static String websiteUrl;
    private static String demoUserEmail;
    private static String demoUserPassword;

    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                setDriverPath();
                propertyFilePath = System.getProperty("user.dir") + "/src/main/resources/configuration.properties";
                instance.loadData();
            }
        }
        return instance;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public String getDemoUserEmail() {
        return demoUserEmail;
    }

    public String getDemoUserPassword() {
        return demoUserPassword;
    }

    private void loadData() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found in: " + propertyFilePath);
        }
        websiteUrl = properties.getProperty("websiteUrl");
        demoUserEmail = properties.getProperty("demoUserEmail");
        demoUserPassword = properties.getProperty("demoUserPassword");
    }

    private static void setDriverPath() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")  + "/src/main/resources/drivers/chromedriver.exe");
    }

}
