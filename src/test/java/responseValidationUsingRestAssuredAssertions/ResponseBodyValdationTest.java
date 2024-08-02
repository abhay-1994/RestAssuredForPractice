package responseValidationUsingRestAssuredAssertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class ResponseBodyValdationTest {

	@Test
	public void responseBodyValidationJsonPath() {
		Response res = given().get("http://49.249.28.218:8091/projects-paginated");
		//res.then().log().all();

		res.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
       /*
		int data1 = res.jsonPath().get("numberOfElements");
		System.out.println("numberOfElements " + data1);

		String data2 = res.jsonPath().get("content[10].projectId");
		System.out.println(data2);

		boolean data3 = res.jsonPath().get("pageable.sort.unsorted");
		System.out.println(data3);
		*/
		
		ArrayList<String> data2 = res.jsonPath().get("content.projectName");
		System.out.println(data2);
		
		
	}

}
