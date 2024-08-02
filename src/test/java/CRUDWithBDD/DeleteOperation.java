package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteOperation {

	
	@Test
	public void getAllProject() {
		given()
		.delete("http://49.249.28.218:8091/project/NH_PROJ_280")
		.then()
		.statusCode(200);
		
	
		
		
	}
}
