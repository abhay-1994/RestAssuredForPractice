package CRUDWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutOperation {

	@Test
	public void updateProject() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "blue");
		jObj.put("projectName", "Red004");
		jObj.put("status", "Created");
		jObj.put("teamSize", 9);
		
		given().contentType(ContentType.JSON).body(jObj)
		.when().put("http://49.249.28.218:8091/project/NH_PROJ_282")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
