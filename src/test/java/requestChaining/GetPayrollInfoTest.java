package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetPayrollInfoTest {

	@Test
	public void payrollInfo() {
		//API1-> Authentication
		
		Response res = given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		res.then().log().all();
		String token = res.jsonPath().get("access_token");
		
		//==>> Api2->getPayroll info
		given().auth().oauth2(token).get("http://49.249.28.218:8091/admin/payrolls").then()
		.log().all();
	}
}
