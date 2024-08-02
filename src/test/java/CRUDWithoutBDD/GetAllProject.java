package CRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProject {
	@Test
	public void getAllProjects() {
		Response resp = RestAssured.get("http://106.51.90.215:8084/projects");
		resp.then().assertThat().statusCode(200);
		resp.then().log().all();
	}

}
