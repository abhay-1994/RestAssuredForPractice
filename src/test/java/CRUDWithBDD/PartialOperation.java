package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PartialOperation {
	
	
	@Test
	public void partialUpdatedateProject() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Red");
		
		
		given().contentType(ContentType.JSON).body(jObj)
		
		.when().patch("http://49.249.28.218:8091/project/NH_PROJ_282")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}

}
