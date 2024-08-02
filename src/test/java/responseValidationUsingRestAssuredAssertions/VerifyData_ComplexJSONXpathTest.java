package responseValidationUsingRestAssuredAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class VerifyData_ComplexJSONXpathTest {

	@Test
	public void jsonXpath() {
		Response res = given().get("http://49.249.28.218:8091/projects-paginated");
		 res.then().log().all();
		ArrayList<String> list = JsonPath.read(res.asString(), "content[*].projectId");
		System.out.println(list);

		/* We are using JsonPath class because we can put condition without if else
		 condition, we can use JsonXpath based on condition*/
		//If project name is cobra2 capture the project id--->>>>>>>
		List<String>list1=JsonPath.read(res.asString(), ".content[*].[?(@.projectName=='ABB_92413')].projectId");
		System.out.println(list1.get(0));
		
		Assert.assertEquals(list1.get(0), "NH_PROJ_584");
	}
}
