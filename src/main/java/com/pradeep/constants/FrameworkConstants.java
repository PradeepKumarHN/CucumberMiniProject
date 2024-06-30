package com.pradeep.constants;

import lombok.Getter;

public final class FrameworkConstants {
    private FrameworkConstants() {
    }

    @Getter
    private static final String configFilePath = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    @Getter
    private static final String excelDataPath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\controller.xlsx";
    @Getter
    private static final String excelSheetName = "tests";
}
