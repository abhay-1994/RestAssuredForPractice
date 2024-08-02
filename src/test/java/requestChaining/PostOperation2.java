package requestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoUtility.CreatePOJO;
import pojoUtility.EmployeePojo;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostOperation2 {
	
	@Test
	public void addEmployeeWithProjectName() {
		Random random = new Random();
		int rNo = random.nextInt(50000);
		CreatePOJO pobj=new CreatePOJO("Abc","Violet_"+rNo,"Onging",7);
		
		Response res = given().contentType(ContentType.JSON).body(pobj)
		.when().post("http://49.249.28.218:8091/addProject");
		
		res.then().log().all();
		//Capture the data
		String projectName = res.jsonPath().get("projectName");
		System.out.println(projectName);
		
		
		//String designation, String dob, String email, String empName, double experience,
		//String mobileNo, String project, String role, String username
		//=>add enployee to same project
		EmployeePojo empObj= new EmployeePojo("Architect", "24/02/2000", "aman@gmail.com", "user_"+rNo,18, "9988776655",projectName, "ROLE_ADMIN","user_"+rNo);
		given().contentType(ContentType.JSON).body(empObj)
		.when().post("http://49.249.28.218:8091/employees").then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
