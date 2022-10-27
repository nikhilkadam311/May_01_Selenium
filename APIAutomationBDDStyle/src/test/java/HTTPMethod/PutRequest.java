package HTTPMethod;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PutRequest {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		Response putRespone = given().header("Content-Type", "application/json").log().all()
				.body("{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"zion resident\"\r\n"
						+ "}").when()
				.put("api/users/2").then().assertThat().statusCode(200).extract().response();
		 
//		print the response body
		String putResponseBody = putRespone.asPrettyString();
		System.out.println(putResponseBody);
	}

}