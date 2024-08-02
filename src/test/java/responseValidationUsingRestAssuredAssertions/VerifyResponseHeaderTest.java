package responseValidationUsingRestAssuredAssertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseHeaderTest {

	@Test
	public void verifyHeader() {
		Response res = given().get("http://49.249.28.218:8091/projects");
		res.then().log().all();
		res.then().assertThat().statusCode(200);
		res.then().assertThat().statusLine("HTTP/1.1 200 ");
		res.then().assertThat().header("Transfer-Encoding", "chunked");
		System.out.println(res.time());
		System.out.println(res.timeIn(TimeUnit.SECONDS));
		
		res.then().time(Matchers.lessThan(2000l), TimeUnit.MILLISECONDS);
		
		res.then().time(Matchers.both(Matchers.lessThan(3000l)).and(Matchers.greaterThan(900l)));
	}
}
