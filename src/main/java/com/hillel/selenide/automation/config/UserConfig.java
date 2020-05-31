package com.hillel.selenide.automation.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class UserConfig {

    private String result = "";
    private InputStream inputStream;
    private Properties prop;

    private static UserConfig instance;

    public UserConfig() {
        try {
            initProp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserConfig getInstance() {
        if (instance==null) {
            instance = new UserConfig();
            return instance;
        }
        return instance;
    }

    private String initProp() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "test.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            }
            else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }



            String user = prop.getProperty("user.name");
            String email = prop.getProperty("user.email");
            String password = prop.getProperty("user.password");

            result = "User = " + user + ", " + email + ", "+ password;

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
         return result;
    }

    public String userName() {
        return prop.getProperty("user.name");
    }

//    public String getPropValues() {
//    }
}
