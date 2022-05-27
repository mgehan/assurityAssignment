package util;

import java.util.HashMap;
import java.util.Map;

import static common.Constants.CONTENT_TYPE_JSON_VALUE;

public class HeaderUtil {

    private HeaderUtil() {
    }

    public static Map<String, String> getCommonHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", CONTENT_TYPE_JSON_VALUE);
        headers.put("Accept", CONTENT_TYPE_JSON_VALUE);
        return headers;
    }

    public static Map<String, String> getCommonSecurityHeaders(String accessToken) {
        Map<String, String> headers = getCommonHeaders();
        headers.put("Authorization", "Bearer " + accessToken);
        return headers;
    }
}
