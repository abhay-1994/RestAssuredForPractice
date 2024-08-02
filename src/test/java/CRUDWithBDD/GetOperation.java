package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetOperation {

	@Test
	public void getAllProject() {
		given()
		.get("http://49.249.28.218:8091/projects")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
		
	}
}
