package basicHTTPMethod;

import static io.restassured.RestAssured.given;

import Utils.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequestAutomate extends Payload  {
	public static Response main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		String userName = "Smith";
		String job = "SDET";
		Response createUserResponse = given().header("Content-Type", "application/json")
				.body(Payload.createUser(userName, job)).log().all().when().post("api/users").then().assertThat()
				.statusCode(201).extract().response();
		System.out.println(createUserResponse.asPrettyString());
		JsonPath js = new JsonPath(createUserResponse.asPrettyString());
		System.out.println(js.getString("name").equals(userName));
		System.out.println(js.getString("job").equals(job));
		return createUserResponse;
	}
}