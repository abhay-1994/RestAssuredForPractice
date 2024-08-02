package CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateAProject {

	
	@Test
	public void createProject() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Red");
		jObj.put("projectName", "Red002");
		jObj.put("status", "Ongoing");
		jObj.put("teamSize", 6);
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		
		Response res = req.post("http://49.249.28.218:8091/addProject");
		res.then().log().all();
		System.out.println(res.asString());//response body wil print in single line
		
	}
}
