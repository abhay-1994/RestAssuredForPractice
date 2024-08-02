package serialization_deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonDeSerialization {

	public static void main(String[] args) throws Throwable, JsonMappingException, IOException {
		ObjectMapper oMap = new ObjectMapper();
		Project pObj = oMap.readValue(new File("./jackson_ser.json"), Project.class);
		System.out.println(pObj.getCreatedBy());
		System.out.println(pObj.getProjectName());
		System.out.println(pObj.getStatus());
		System.out.println(pObj.getTeamSize());

	}

}
