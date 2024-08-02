package requestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoUtility.CreatePOJO;
import pojoUtility.EmployeePojo;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostOperation {
	
	@Test
	public void createProjectAndDelete() {
		Random random = new Random();
		int rNo = random.nextInt(50000);
		CreatePOJO pobj=new CreatePOJO("Abc","Violet_"+rNo,"Onging",7);
		
		Response res = given().contentType(ContentType.JSON).body(pobj)
		.when().post("http://49.249.28.218:8091/addProject");
		
		res.then().log().all();
		//Capture the data
		String projectId = res.jsonPath().get("projectId");
		System.out.println(projectId);
		
		given().delete("http://49.249.28.218:8091/project/"+projectId)
		.then().log().all();
		
	}

}
