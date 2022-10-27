package HTTPMethod;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class MapAPI {
	private static final io.restassured.path.json.JsonPath New = null;

	public static void main (String[] args) throws InterruptedException	 {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123")
				.header("Content-Type", "application/json")
				.body
				("{\r\n" + "    \"location\": {\r\n"	+ "        \"lat\": -38.383494,\r\n"+ "        \"lng\": 33.427362\r\n"
						+ "    },\r\n" + "    \"accuracy\": 50,\r\n" + "    \"name\": \"FrontLine House\",\r\n"
						+ "	\"phone_number\": \"(+91) 983 893 3937\",\r\n"
						+ "    \"address\": \"29, side layout, cohen 09\",\r\n"
						+ "    \"types\": [\r\n"
						+ "        \"shoe park\",\r\n"
						+ "        \"shop\"\r\n"
						+ "    ],\r\n"
						+ "    \"website\": \"http://google.com\",\r\n"
						+ "    \"language\": \"French-IN\"\r\n"
						+ "}")
				.when().post("maps/api/place/add/json").then().assertThat().statusCode(200).extract().response()
				.asPrettyString();
		System.out.println(response);

		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println(placeId);

		String updateAddress = "140, Shivaji Nagar, Pune";
		String putResponse = given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId)
				.header("Content-Type", "application/json")
				.body("{\r\n"
						+ "    \"place_id\":\"" + placeId + "\",\r\n"
						+ "    \" +address\"" + updateAddress + ",\r\n"
						+ "    \"key\":\"qaclick123\"\r\n"
						+ "}").when().put("maps/api/place/update/json").then().assertThat().statusCode(200).extract().response()
				.asPrettyString();
		System.out.println(putResponse);
		Thread.sleep(3000);

		String getResponse = given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId)
				.when().get("maps/api/place/get/json").then().assertThat().statusCode(200).extract().response()
				.asPrettyString();
		System.out.println(getResponse);
		JsonPath js1 = new JsonPath(response);
		String updatedAddress = js.getString("place_id");
		System.out.println(updateAddress.equals(updatedAddress));

	}

	private static io.restassured.path.json.JsonPath JsonPath(String response) {
		return null;
		// TODO Auto-generated method stub

	}
}