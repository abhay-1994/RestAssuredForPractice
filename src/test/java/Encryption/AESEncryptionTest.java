package Encryption;

import org.testng.annotations.Test;

import EncryptionDecryptionUtility.EncryptAndDecryptUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class AESEncryptionTest {

	@Test
	public void updatePayroll_AES() throws Exception {

		//String jBody = "{ \"employee\": { \"empId\":\"NH_00240\",\"email\": \"abc@gmail.com\", \"empName\": \"user_844\",\"mobileNo\": \"9988776655\", \"project\": \"string\", \"role\": \"ROLE_ADMIN\", \"username\": “user_844” }, \"basicPlusVda\": 0, \"hra\": 0, \"insurance\": 0, \"lta\": 0, \"lwf\": 0, \"netPay\": 0, \"payroll_id\": 0, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": “Active” }";

		String jBody = " { \"employee\": { \"empId\": \"NH_00240\", \"empName\": \"admin\", \"mobileNo\": \"7259229999\", \"email\": \"demoacc@gmail.com\", \"dob\": null }, \"hra\": 5000, \"insurance\": 3000, \"lta\": 5000, \"lwf\": 5000, \"netPay\": 5000, \"payroll_id\": 1, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0 }";
		EncryptAndDecryptUtility ed = new EncryptAndDecryptUtility();
		String encBody = ed.encrypt(jBody, "Ac03tEam@j!tu_#1");
		System.out.println(encBody);
		Response rep = given().body(encBody).log().all()
//		.then().log().all()

				.when().put("http://49.249.28.218:8091/payroll");
		rep.then().log().all();
		String output = ed.decrypt(rep.getBody().asPrettyString(), "Ac03tEam@j!tu_#1");
		
		System.out.println(output);
		
		
		
	}
}
