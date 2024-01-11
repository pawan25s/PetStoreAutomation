package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.*;

//UserEndPoint.java
//For CRUD of request the user API

public class UserEndPoints {
	
	public static Response createUser(User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().post(Routes.post_Url);
		return response;

	}

	public static Response getUser(String userName) {
		Response response = given().pathParam("username", userName)

				.when().get(Routes.get_Url);
		return response;

	}

	public static Response updateUser(String userName, User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(payload).body(payload)

				.when().put(Routes.put_Url);
		return response;

	}

	public static Response deleteUser(String userName) {
		Response response = given().pathParam("username", userName)

				.when().delete(Routes.get_Url);
		return response;

	}

}
