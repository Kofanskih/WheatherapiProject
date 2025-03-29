package utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:urls.properties",
        "classpath:remote.urls.properties"})

public interface OwnerConfig extends Config {
    @Key("main.url")
    String mainUrl();

    @Key("localhost.remote")
    String remoteUrl();
}
