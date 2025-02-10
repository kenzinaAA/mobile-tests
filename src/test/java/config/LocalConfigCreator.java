package config;

import org.aeonbits.owner.ConfigFactory;

public class LocalConfigCreator {
    public static LocalConfig localConfig = ConfigFactory.create(LocalConfig.class, System.getProperties());
}
