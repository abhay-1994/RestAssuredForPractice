package theParameters;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

public class PathParameters {
	
	@Test
	public void useOfPathParameter() {
		given().pathParam("projectId", "NH_PROJ_826")
		.when()
		.get("http://49.249.28.218:8091/project/{projectId}")
		.then()
		.log().all();
		
		
		
	}

}
