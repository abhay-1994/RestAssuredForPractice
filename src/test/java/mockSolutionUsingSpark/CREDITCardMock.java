package mockSolutionUsingSpark;

import org.apache.commons.lang3.StringUtils;

import com.jayway.jsonpath.JsonPath;


import spark.Spark;

public class CREDITCardMock {

	public static void main(String[] args) {
		Spark.port(8889);
		Spark.post("/creditCard", (req,res)->{
			String response="";
			String card=JsonPath.read(req.body().toString(), "$.creditCard");
			if(StringUtils.equalsAny(card, "1234567891234", "123456784321","1234567890123")) {
				response="{\"status\":\"Payment successful\"}";
				res.status(200);
			}
			else {
				response="{\"status\":\"Payment Failed\"}";
				res.status(404);
			}
			
			res.type("Application/json");
			return response;
		});
		System.out.println("========Running on port 8889===========");
		

	}

}
