package DataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import Enums.DriverType;
import Enums.EnvironmentType;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String propertyFilePath = "config/conf.properties";

        try {
            fileReader = new FileReader(propertyFilePath);
            bufferedReader = new BufferedReader(fileReader);
            properties = new Properties();

            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("conf.properties file is not found at " + propertyFilePath);
        }
    }

    public String getUrl() {
        String url = properties.getProperty("url");

        if (url != null) {
            return url;
        }else
            throw new RuntimeException("url is not defined.");
    }

    public long getTime() {
        String timeout = properties.getProperty("timeout");

        if (timeout != null) {
            return Long.parseLong(timeout);
        } else {
            throw new RuntimeException("timeout is not defined.");
        }
    }

    public DriverType getBrowser()  {
        String browserName = properties.getProperty("browser");

        switch (browserName) {
            case "chrome":
                return DriverType.CHROME;
            default:
                throw new RuntimeException("browser " + browserName + "is not defined ");
        }
    }

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");

        switch (environmentName) {
            case "local":
                return EnvironmentType.LOCAL;
            default:
                throw new RuntimeException("Environment type: " + environmentName + " - is not setup to run");
        }
    }
}
