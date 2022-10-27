package basicHTTPMethod;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostRequest {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
				Response createUserResponse = given().header("Content-Type", "application/json")
				.body("{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"leader\"\r\n"
						+ "}").log().all().when().post("api/users").then().assertThat()
				.statusCode(201).extract().response();
		String createUserResponseBody = createUserResponse.asPrettyString();
		System.out.println(createUserResponseBody);
	}
}