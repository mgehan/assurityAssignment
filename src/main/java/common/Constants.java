package common;

import java.text.MessageFormat;

public class Constants {

    private static final String HOST_PROPERTY = "host";
    private static final String DEFAULT_HOST = "https";
    private static final String BASE_DOMAIN_PROPERTY = "base.domain";
    private static final String DEFAULT_BASE_DOMAIN = "api.tmsandbox.co.nz";
    private static final String BASE_URL_PROPERTY = "base.url";


    public static final String HOST = SystemUtils.getProperty(HOST_PROPERTY, DEFAULT_HOST);
    public static final String BASE_DOMAIN = SystemUtils.getProperty(BASE_DOMAIN_PROPERTY, DEFAULT_BASE_DOMAIN);
    public static final String BASE_URL = System.getProperty(BASE_URL_PROPERTY, MessageFormat.format("{0}://{1}", HOST, BASE_DOMAIN));

    public static final String CONTENT_TYPE_JSON_VALUE = "application/json";

    public static final String BASE_PATH = System.getProperty("base.path", "/v1");



    private Constants() {
    }
}
