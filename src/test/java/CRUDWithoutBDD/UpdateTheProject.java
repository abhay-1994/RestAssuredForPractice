package CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateTheProject {
//TY_PROJ_10112
	@Test
	public void updateProj() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Orange");
		jObj.put("projectName", "Orange001");
		jObj.put("status", "Created");
		jObj.put("teamSize", 7);
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		
		Response res = req.put("http://49.249.28.218:8091/project/NH_PROJ_230");
		res.then().log().all();
	}
}
