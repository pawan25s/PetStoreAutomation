package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.*;

//UserEndPoint.java
//For CRUD of request the user API

public class UserEndPoints2 {
	
	
	//Method getting Url from properties file
	static ResourceBundle getUrl()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");//load properties file
		return routes;
	}
	
	public static Response createUser(User payload) {
		
		String posturl=getUrl().getString("post_url");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().post(posturl);
		return response;

	}

	public static Response getUser(String userName) {
		
		String geturl=getUrl().getString("get_Url");
		Response response = given().pathParam("username", userName)

				.when().get(geturl);
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
