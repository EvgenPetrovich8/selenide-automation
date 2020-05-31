package com.hillel.selenide.automation.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:test.properties"})
public interface UserConfiguration extends Config {


    @DefaultValue("default_Name")
    @Key("user.name")
    String name();
    @Key("user.email")
    String email();
    @Key("user.password")
    String password();


}
