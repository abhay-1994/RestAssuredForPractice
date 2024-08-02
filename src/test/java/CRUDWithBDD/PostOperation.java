package CRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostOperation {
	
	@Test
	public void createProject() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Red");
		jObj.put("projectName", "Red003");
		jObj.put("status", "Ongoing");
		jObj.put("teamSize", 0);
		
		given().contentType(ContentType.JSON).body(jObj)
		.when().post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
