package basicHTTPMethod;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginWithStaticPayload {
	public static void main(String[] args) throws IOException {
//		https://reqres.in/api/login
		RestAssured.baseURI = "https://reqres.in";
		String loginResponse = given().header("Content-Type", "application/json")
				.body(new String(Files.readAllBytes(Paths.get("./src/test/java/LoginPayload.json")))).when()
				.post("api/login").then().assertThat().statusCode(200).extract().response().asPrettyString();
		System.out.println(loginResponse);
	}
}