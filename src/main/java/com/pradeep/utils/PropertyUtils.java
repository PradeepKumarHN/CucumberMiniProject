package com.pradeep.utils;

import com.pradeep.constants.FrameworkConstants;
import com.pradeep.enums.PropertyType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class PropertyUtils {
    private PropertyUtils() {
    }
    private static final Properties properties=new Properties();
    static{
        try(FileInputStream fis=new FileInputStream(FrameworkConstants.getConfigFilePath())){
            properties.load(fis);
        }catch (FileNotFoundException e){
            throw new RuntimeException("File not found at location \"src/test/resources/config/config.properties\"");
        } catch (IOException e) {
            throw new RuntimeException("Some I/o Exception occured while reading the file at location \"src/test/resources/config/config.properties\"");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(PropertyType property){
        return properties.getProperty(property.toString().toLowerCase());
    }
}
