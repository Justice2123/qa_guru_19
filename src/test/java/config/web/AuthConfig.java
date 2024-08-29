package config.web;

import org.aeonbits.owner.Config;


@Config.Sources({
        "file:/tmp/auth.properties",
        "classpath:auth.properties"
})


public interface AuthConfig extends Config {

    @Key("username")
    String userName();

    @Key("password")
    String password();

}
