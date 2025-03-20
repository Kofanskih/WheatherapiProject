package utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:urls.properties"})
public interface OwnerConfig extends Config {
    String main_url();
}
