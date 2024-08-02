package MicroWebServiceTesting;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

public class CreateOrderWithPaymentNimbbl {

	
	
	//Nimbbl Application
	@Test
	public void crateOrder() {
		baseURI="https://api.nimbbl.tech";
	String accesskey= "access_key_pKx7rWVgVpbXQvq2";
	String accesssecret= "access_secret_DX3w55VKAkXbx7aB";
	String authorizationRequestBody="{\"access_key\":\""+accesskey+"\",\"access_secret\":\""+accesssecret+"\"}";
	Response authResponseBody = given().body(authorizationRequestBody)
			.contentType(ContentType.JSON)
			.post("api/v3/generate-token");
	
	authResponseBody.then().log().all();
	String authToken = authResponseBody.jsonPath().get("token");
	
	
	RequestSender r = when();

	}
}
