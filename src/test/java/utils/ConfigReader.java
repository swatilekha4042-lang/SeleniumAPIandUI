package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ConfigReader {

    private static final Properties prop = new Properties();

    static{
        try(InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties"))
        {
            if(input == null)
            {
                throw new RuntimeException("config.properties not found");
            }

            prop.load(input);
        } catch(IOException e)
        {
            throw new RuntimeException("Failed to load config.properties file",e);
        }
    }

    public static String get(String key)
    {
        return  prop.getProperty(key);
    }
    
}
