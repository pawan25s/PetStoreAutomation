package api.endpoints;

/*Swagger URI-https://petstore.swagger.io/v2
 * 
 * CreateUser(post)-https://petstore.swagger.io/v2/user
 * Get user(get)-https://petstore.swagger.io/v2/{username}
 * Update user(put)-https://petstore.swagger.io/v2/{username}
 * Delete User(delete)-https://petstore.swagger.io/v2/{username}
 */

public class Routes {
	
	public static String base_Url="https://petstore.swagger.io/v2";
	
	//User Module
	public static String post_Url=base_Url+"/user";
	public static String get_Url=base_Url+"/{username}";
	public static String put_Url=base_Url+"/{username}";
	public static String delete_Url=base_Url+"/{username}";
	
	//Store Module
	


}
