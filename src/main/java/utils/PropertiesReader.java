package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    public static Properties readPropFile(String fileName){
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(System.getProperty("user.dir")+"/configuration/" + fileName + ".properties")) {
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }
}
