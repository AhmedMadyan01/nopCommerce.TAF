package utilities.properties_reader;

public class ConfigUtils {
    private static final String CONFIG_PROPERTIES_FILE_PATH = "/src/main/resources/Config.properties";
    private static String URl;

    private static void setConfigProperties() {
        URl = PropertiesDataManager.getProperty("nopCommerce_URL", CONFIG_PROPERTIES_FILE_PATH);
    }

    public static String getURL() {
        setConfigProperties();
        return URl;
    }
}