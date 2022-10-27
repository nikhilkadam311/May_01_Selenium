package serialization;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import pojo.RegisterUserData;

public class RegisterUser {
	public static void main(String[] args) {
		RegisterUserData data = new RegisterUserData();
		data.setEmail("eve.holt@reqres.in");
		data.setPassword("Test@123");

//		https://reqres.in/api/register
		RestAssured.baseURI = "https://reqres.in";
		given().log().all().header("Content-Type", "application/json").body(data).when().post("api/register").then()
				.log().all().assertThat().statusCode(200);
	}
}
