package org.selenium.pom.api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.utils.ConfigLoader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class LoginApi {
    private Cookies cookies;

    public Cookies getCookies() {
        return cookies;
    }

    public Response getLogin() {
        Cookies cookies = new Cookies();
        Response response = given().
                baseUri(ConfigLoader.getInstance().getBaseUrl()).
                cookies(cookies).
                log().all().
                when().
                get("/profile.php").
                then().
                log().all().
                extract().
                response();
        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to fetch the login account, HTTP Status Code: " + response.getStatusCode());
        }
        return response;
    }

    public Response login(User user) {
        Cookies cookies = new Cookies();
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("username", user.getUsername());
        formParams.put("password", user.getPassword());


        Response response = given().
                baseUri(ConfigLoader.getInstance().getBaseUrl()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
                log().all().
                when().
                post("/authenticate.php").
                then().
                log().all().
                extract().
                response();
        if (response.getStatusCode() != 302) {
            throw new RuntimeException("Failed to login the account, HTTP Status Code: " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }

    public Response makeApointment(HomePage homePage) {
        String facility ="Seoul CURA Healthcare Center";
        Cookies cookies = new Cookies();
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("facility", homePage.selectFacility(facility));
        formParams.put("hospital_readmission", homePage.selectButton() );
        formParams.put("programs", homePage.selectRadioButton() );
        formParams.put("visit_date", homePage.clickDate2() );
        formParams.put("comment", homePage.getComment());

        Response response = given().
                baseUri(ConfigLoader.getInstance().getBaseUrl()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
                log().all().
                when().
                post("/appointment.php").
                then().
                log().all().
                extract().
                response();
        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to make the appointment, HTTP Status Code: " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }


}

