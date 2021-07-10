package adapters;
import com.google.gson.Gson;
import constants.Constants;
import static io.restassured.RestAssured.given;

public class BaseAdapter implements Constants {

    Gson converter = new Gson();

    /**
     * get response
     * @param url
     * @return
     */
    public String  get(String url) {
        return
        given()
                .header(TOKEN, TOKEN_VALUE)
                .header(CONTENT_TYPE,CONTENT_TYPE_VALUE)
        .when()
                .get(BASE_URL + url)
        .then()
                .log().all()
                .extract().body().asString();
    }

    /**
     * post request and get response
     * @param url
     * @param body
     * @return
     */
    public String post(String url, String body) {
        return
        given()
                .header(TOKEN, TOKEN_VALUE)
                .header(CONTENT_TYPE,CONTENT_TYPE_VALUE)
                .body(body)
        .when()
                .post(BASE_URL + url)
        .then()
                .log().all()
                .extract().asString();
    }

    /**
     * delete request and get response
     * @param url
     * @return
     */
    public String delete(String url) {
        return
        given()
                .header(TOKEN, TOKEN_VALUE)
                .header(CONTENT_TYPE,CONTENT_TYPE_VALUE)
        .when()
                .delete(BASE_URL + url)
        .then()
                .log().all()
                .extract().asString();
    }
}
