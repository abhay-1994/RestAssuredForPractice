package mockSolutionUsingSpark;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreditCardPaymentTest {

	@Test
	public void sampleTest() {
		JSONObject jObj = new JSONObject();
		jObj.put("creditCard" ,"1234567891234");
		jObj.put("cvv", "123");
		jObj.put("cardname", "Abhay");
		
		
		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		 .when()
		 .post("http://localhost:8889/creditCard")
		 .then().log().all();
		 
	}
}
