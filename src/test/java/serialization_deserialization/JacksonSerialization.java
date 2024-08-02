package serialization_deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

class Project{//POJO (Plain Old Java Object) class
	private String createdBy;
	private String projectName;
	private String status;
	private int teamSize;
	public Project(String createdBy, String projectName, String status, int teamSize) {
		super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}
	public Project() {//needed for deserialization
		
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
}
public class JacksonSerialization {
	
	public static void main(String[] args) throws Throwable {
		Project project = new Project("Orange1", "Abhay", "Created", 6);
		ObjectMapper oMap = new ObjectMapper();
		oMap.writeValue(new File("./jackson_ser.json"), project);
		//oMap.writerWithDefaultPrettyPrinter().writeValue(new File("./jackson_ser.json"), project);//it will print into proper json format
		
		System.out.println("======END======");
	}

}
