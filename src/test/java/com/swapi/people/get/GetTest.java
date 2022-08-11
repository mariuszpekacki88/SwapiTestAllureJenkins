package com.swapi.people.get;

import com.swapi.base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetTest extends BaseTest {

    @Test
    public void readAllUsers ()
    {
        Response response = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + "/" + USERS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        List<String> names = json.getList("name");
        assertThat(10).isEqualTo(names.size());
    }
}
