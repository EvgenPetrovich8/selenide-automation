package com.hillel.selenide.automation;

import com.hillel.selenide.automation.config.UserConfig;
import com.hillel.selenide.automation.config.UserConfiguration;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

public class TestPropertiesExample {

    private UserConfiguration userConfiguration = ConfigFactory.create(UserConfiguration.class);

   
    @Test
    public void readUserNamePropertyTest() {
        String userName= userConfiguration.name();
        System.out.println(userName);

    }

    @Test
    public void readUserEmailPropertyTest() {
        String userEmail= userConfiguration.email();
        System.out.println(userEmail);

    }

    @Test
    public void readUserPasswordPropertyTest() {
        String userPassword= userConfiguration.password();
        System.out.println(userPassword);

    }


}
