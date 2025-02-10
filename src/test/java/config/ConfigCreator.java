package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigCreator {
    public static ProjectConfig remoteConfig = ConfigFactory.create(ProjectConfig.class, System.getProperties());
}
