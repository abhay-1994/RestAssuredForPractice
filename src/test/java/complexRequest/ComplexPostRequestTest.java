package complexRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoUtility.CreatePOJO;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.Random;

public class ComplexPostRequestTest {

	@Test
	public void postWithPOJOClass() {
		Random r = new Random();
		int rNo = r.nextInt(5000);
		CreatePOJO pojoObj = new CreatePOJO("Abhay", "ABC_"+rNo, "Ongoing", 4);
		given().contentType(ContentType.JSON)
		.body(pojoObj).when()
		.post("http://49.249.28.218:8091/addProject")
		.then().log().all()
		.assertThat().statusCode(201);
	}
	
	@Test
	public void postWithJSONfile() {
		File fileObj = new File("./hrm.json");
		
		given().contentType(ContentType.JSON)
		.body(fileObj).when().post("http://49.249.28.218:8091/addProject")
		.then().log().all().assertThat().statusCode(201);
	}
}
