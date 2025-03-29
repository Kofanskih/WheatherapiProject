package utils;

import org.aeonbits.owner.ConfigFactory;

public class OwnerReadUrl {
    public static String ownerMainUrl(){
        OwnerConfig ownerConfig = ConfigFactory.create(OwnerConfig.class);
        String main_url = ownerConfig.mainUrl();
        return main_url;
    }

}
