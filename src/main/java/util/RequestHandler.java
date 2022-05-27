package util;

import common.Constants;
import common.URIs;
import io.restassured.response.Response;

import java.text.MessageFormat;
import java.util.Map;

public class RequestHandler {

    private final RestClient restClient;

    public RequestHandler() {
        restClient = new RestClient(Constants.BASE_URL, Constants.BASE_PATH);
    }

    public Response getCategories(String categoryId, Map<String, String> queryParam) {
        return restClient.send(
              HTTPMethod.GET,
              MessageFormat.format(URIs.GET_CATEGORY, categoryId),
              null,
              HeaderUtil.getCommonHeaders(),
              queryParam);
    }
}
