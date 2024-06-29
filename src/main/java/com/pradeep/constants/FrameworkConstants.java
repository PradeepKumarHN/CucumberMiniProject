package com.pradeep.constants;

import lombok.Getter;

public final class FrameworkConstants {
    private FrameworkConstants() {
    }

    @Getter
    private static final String configFilePath=System.getProperty("user.dir")+"/src/test/resources/config/config.properties";

}
