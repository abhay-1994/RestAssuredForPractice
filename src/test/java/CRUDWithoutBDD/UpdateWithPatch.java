package CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateWithPatch {
//TY_PROJ_10114
	@Test
	public void updateUsingPatch() {
		JSONObject jObj = new JSONObject();

		jObj.put("projectName", "Red004");

		RequestSpecification req = RestAssured.given();
		
		req.contentType(ContentType.JSON);
		req.body(jObj);
		Response res = req.patch("http://49.249.28.218:8091/project/NH_PROJ_230");
		res.then().log().all();
		
	}

}
