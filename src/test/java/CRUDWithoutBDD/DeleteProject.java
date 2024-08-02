package CRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {

	
	@Test
	public void deleteOperation() {
		Response res = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_230");
		res.then().log().all();
	}
}
