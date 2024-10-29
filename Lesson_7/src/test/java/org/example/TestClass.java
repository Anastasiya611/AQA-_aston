package org.example;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;



class TestClass {

    @Test
    public void getRequest() {
        given()
                .baseUri("https://postman-echo.com")
                .header("Cookie", "sails.sid=s%3AEuxpDH2XPmM6X8icklUmAg63fIqbgVBH.D9tM0QqCa8i5aR04KTDozLODPX2ugdEsdc0MUN1kO4k")
                .header("Host", "postman-echo.com")
                .header("User-Agent", "PostmanRuntime/7.42.0")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .when()
                .get("/get")
                .then()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.cookie",equalTo("sails.sid=s%3AEuxpDH2XPmM6X8icklUmAg63fIqbgVBH.D9tM0QqCa8i5aR04KTDozLODPX2ugdEsdc0MUN1kO4k"))
                .body("headers.x-request-start", startsWith("t=173"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id",  notNullValue())
                .body("headers.user-agent", equalTo("PostmanRuntime/7.42.0"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("https://postman-echo.com/get"));
    }
    @Test
    public void postRawText() {
        String requestBody = "{\"test\": \"value\"}";

               given()
                .baseUri("https://postman-echo.com")
                .header("User-Agent", "PostmanRuntime/7.42.0")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .header("Host", "postman-echo.com")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .assertThat()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t=173"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", equalTo("PostmanRuntime/7.42.0"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("json.test", equalTo("value"));
    }
    @Test
    public void postFormData() {
        String key1 = "foo1";
        String value1 = "bar1";
        String key2 = "foo2";
        String value2 = "bar2";
        String requestBody = String.format("{ \"%s\": \"%s\", \"%s\": \"%s\" }", key1, value1, key2, value2);
        given()
                .baseUri("https://postman-echo.com")
                .header("User-Agent", "PostmanRuntime/7.42.0")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .header("Host", "postman-echo.com")
                .header("Content-Type","application/x-www-form-urlencoded")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .assertThat()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t=173"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", equalTo("PostmanRuntime/7.42.0"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }
    @Test
    public void putRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .baseUri("https://postman-echo.com")
                .header("User-Agent", "PostmanRuntime/7.42.0")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .header("Host", "postman-echo.com")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .assertThat()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t=173"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", equalTo("PostmanRuntime/7.42.0"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("https://postman-echo.com/put"))
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
    @Test
    public void patchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .baseUri("https://postman-echo.com")
                .header("User-Agent", "PostmanRuntime/7.42.0")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .header("Host", "postman-echo.com")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .assertThat()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t=173"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", equalTo("PostmanRuntime/7.42.0"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("https://postman-echo.com/patch"))
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
    @Test
    public void deleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .baseUri("https://postman-echo.com")
                .header("User-Agent", "PostmanRuntime/7.42.0")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .header("Host", "postman-echo.com")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .assertThat()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t=173"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", equalTo("PostmanRuntime/7.42.0"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("https://postman-echo.com/delete"))
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}