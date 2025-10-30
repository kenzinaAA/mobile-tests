package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:emulator.properties",   // локальные настройки
})
public interface EmulatorConfig  extends Config{

    @Key("device")
    String device();

    @Key("osVersion")
    String osVersion();

    @Key("serverUrl")
    String serverUrl();

}

