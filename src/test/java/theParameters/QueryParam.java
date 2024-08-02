package theParameters;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class QueryParam {
	@Test
	public void useOfQueryParameter() {
		given()
		.queryParam("teamSize", 10)
//		.when().get("http://49.249.28.218:8091/project/?teamSize=10").then()//this one we can use without query parameter method
		//in query parameter the data will be attached in the url that's why we are usinhg formparamater
		.when().get("http://49.249.28.218:8091/project").then()
				.log().all();

	}

}
