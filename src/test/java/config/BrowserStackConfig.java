package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:local.properties",   // локальные настройки
        "classpath:remote.properties",  // удалённые настройки
        "system:properties"        // можно переопределить через -D
})
public interface BrowserStackConfig extends Config{

    @Key("browserstack.user")
    String user();

    @Key("browserstack.key")
    String key();

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("osVersion")
    String osVersion();
}
