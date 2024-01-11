package api.tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.utilities.DataProviders;
import io.restassured.response.Response;
import api.endpoints.UserEndPoints;
import api.payloads.User;

public class DDTests {
	
	@Test(priority=1 ,dataProvider="Data" ,dataProviderClass=DataProviders.class)
	public void testPostUser(String UserID,String UserName,String FirstName,String LastName,String UserEmail,String Password,String ph)//this must in same order as in sheet
	{
		User userpayload=new User();
		
		userpayload.setId(Integer.parseInt(UserID));
		userpayload.setUsername(UserName);
		userpayload.setFirstName(FirstName);
		userpayload.setLastName(LastName);
		userpayload.setEmail(UserEmail);
		userpayload.setPassword(Password);
		userpayload.setPhone(ph);
		
		Response response = UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

		
	}
	
	@Test(priority=2 ,dataProvider="UserNames" ,dataProviderClass=DataProvider.class)
	public void testDeleteUserByName(String UserName)
	{
		Response response = UserEndPoints.deleteUser(UserName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	

}
