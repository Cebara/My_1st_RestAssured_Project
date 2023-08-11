import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class DemoRestAssured {

    @Test
    public void testGetUsers() {
        RestAssured.baseURI = "https://reqres.in/api";

              given()
               .when()
               .get("/users")
               .then()
               .statusCode(200)
               .body("data[1].first_name" , equalTo("Janet"));
    }

    @Test
    public void testPostUser() {
        RestAssured.baseURI = "https://reqres.in/api";

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("name", "Alejandra");
        map.put("Job", "Customer Success");

        given()
                .log().all()
                .body(map.toString())
                .when()
                .post("/users")
                .then()
                .log().all()
                .statusCode(201);
    }
}