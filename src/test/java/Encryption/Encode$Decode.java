package Encryption;

import java.util.Base64;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Encode$Decode {

	@Test
	public void base64EncodingDecoding() {
		String encrData = new String(Base64.getEncoder().encode("rmgyantra:rmgy@9999".getBytes()));
		System.out.println(encrData);
		String decrData = new String(Base64.getDecoder().decode(encrData.getBytes()));
		System.out.println(decrData);
		
		given()
		.auth()
		.digest("rmgyantra", "rmgy@9999").log().all()
		.when().get("http://49.249.28.218:8091/projects");
	}
}
