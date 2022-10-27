package basicHTTPMethod;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequest {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		Response deleteUserResponse =given().log().all().when().delete("api/users/2").then().assertThat().statusCode(204).extract().response();
		String serverHeader = deleteUserResponse.header("Server");
		System.out.println(serverHeader);
	}
}