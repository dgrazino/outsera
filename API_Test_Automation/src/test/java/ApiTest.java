import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    
    @Test
    public void testGetEndpoint() {
        Allure.step("Tarefa 1: Validando o endpoint GET");
        Response response = given()
            .when()
                .get("/posts/1")
            .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("userId", notNullValue())
                .body("title", not(emptyOrNullString()))
                .extract().response();
        
        Allure.addAttachment("Response GET", response.getBody().asString());
    }
    
    @Test
    public void testPostEndpoint() {
        Allure.step("Tarefa 2: Validando o endpoint POST");
        Response response = given()
            .header("Content-Type", "application/json")
            .body("{\"title\": \"Test Post\", \"body\": \"This is a test.\", \"userId\": 1}")
            .when()
                .post("/posts")
            .then()
                .statusCode(201)
                .extract().response();
        
        Allure.addAttachment("Response POST", response.getBody().asString());
    }
    
    @Test
    public void testPutEndpoint() {
        Allure.step("Tarefa 2: Validando o endpoint PUT");
        Response response = given()
            .header("Content-Type", "application/json")
            .body("{\"title\": \"Updated Title\"}")
            .when()
                .put("/posts/1")
            .then()
                .statusCode(200)
                .body("title", equalTo("Updated Title"))
                .extract().response();
        
        Allure.addAttachment("Response PUT", response.getBody().asString());
    }
    
    @Test
    public void testDeleteEndpoint() {
        Allure.step("Tarefa 2: Validando o endpoint DELETE");
        Response response = given()
            .when()
                .delete("/posts/1")
            .then()
                .statusCode(200)
                .extract().response();
        
        Allure.addAttachment("Response DELETE", response.getBody().asString());
    }
}
