package util;

import exceptions.CategoryException;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RestClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestClient.class);
    private static final String LOG_ENTRY_SEPARATOR = "\n*********\n\n";

    public final String apiHost;
    public final String basePath;

    public RestClient(String host, String basePath) {
        this.apiHost = host;
        this.basePath = basePath;
    }

    public Response send(HTTPMethod requestMethod, String uri, String bodyString, Map<String, String> headers, Map<String, String> queryParameters) {
        LOGGER.info("\n\nHEADERS\n{}{}", headers, LOG_ENTRY_SEPARATOR);
        LOGGER.info("\n\nREQUEST_URL\n{}{}/{}{}", apiHost, basePath, uri, LOG_ENTRY_SEPARATOR);
        RequestSpecification requestSpecification = getRequestSpec(headers, bodyString);
        LOGGER.info("\n\nREQUEST_BODY\n{}{}", bodyString, LOG_ENTRY_SEPARATOR);
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = RestAssured.given().spec(requestSpecification);
        String completeUri = setQueryParameters(uri, queryParameters);
        Response response = execute(requestMethod, requestSpecification, completeUri);
        String responseBody = response.getBody().asPrettyString();
        LOGGER.info("\n\nRESPONSE\n{}{}", responseBody, LOG_ENTRY_SEPARATOR);
        LOGGER.info("\n\nRESPONSE_STATUS_CODE\n{}{}", response.getStatusCode(), LOG_ENTRY_SEPARATOR);
        return response;
    }

    public static Response execute(HTTPMethod method, RequestSpecification requestSpec, String uri) {
        RequestSpecification requestSpecification =
              RestAssured.given(requestSpec)
                    .config(RestAssured.config().encoderConfig(
                          EncoderConfig.encoderConfig()
                                .appendDefaultContentCharsetToContentTypeIfUndefined(false)));

        switch (method) {
            case GET:
                return requestSpecification.expect().when().get(uri);
            case POST:
                return requestSpecification.expect().when().post(uri);
            case PUT:
                return requestSpecification.expect().when().put(uri);
            case DELETE:
                return requestSpecification.expect().when().delete(uri);
            case PATCH:
                return requestSpecification.expect().when().patch(uri);
            default:
                throw new CategoryException("Provided HTTP method not supported");
        }
    }

    private RequestSpecification getRequestSpec(Map<String, String> headers, String body) {
        RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
        reqSpecBuilder.setBaseUri(apiHost);
        reqSpecBuilder.setBasePath(basePath);
        if (headers != null) {
            reqSpecBuilder.addHeaders(headers);
        }

        if (body != null && !body.isEmpty()) {
            reqSpecBuilder.setBody(body);
        }

        return reqSpecBuilder.build();
    }

    public static String setQueryParameters(String url, Map<String, String> queryParameters) {
        if (queryParameters != null && !queryParameters.isEmpty()) {
            String completeUrl = url.concat("?");

            for (Map.Entry<String, String> queryParameter : queryParameters.entrySet()) {
                completeUrl = completeUrl.concat(queryParameter.getKey().concat("=").concat(queryParameter.getValue())).concat("&");
            }
            //removing last &
            return completeUrl.substring(0, completeUrl.length() - 1);

        } else {
            return url;
        }
    }
}
