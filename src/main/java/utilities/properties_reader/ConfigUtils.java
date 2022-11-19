package utilities.properties_reader;

public class ConfigUtils {
    private static final String CONFIG_PROPERTIES_FILE_PATH = "/src/main/resources/Config.properties";
    private static String URI;

    private static void setConfigProperties() {
        URI = PropertiesDataManager.getProperty("nopCommerce_URL", CONFIG_PROPERTIES_FILE_PATH);
    }

    public static String get_URI() {
        setConfigProperties();
        return URI;
    }
}