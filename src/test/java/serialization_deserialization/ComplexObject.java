package serialization_deserialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(
	value  =  {"ProjectName",
			"ProjectStatus",
			"TeamSize",
			"TeamMember",
			"ProjectManager"
			}
)
class Project1 {

	
	String ProjectName;
	String ProjectStatus;
	int TeamSize;
	List<String> TeamMember;
	ProjectManager ProjectManager;

	public Project1(String projectName, String projectStatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		ProjectName = projectName;
		ProjectStatus = projectStatus;
		TeamSize = teamSize;
		TeamMember = teamMember;
		ProjectManager = projectManager;
	}

	public Project1() {
	}

	public void setProjectName(String ProjectName) {
		this.ProjectName = ProjectName;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectStatus(String ProjectStatus) {
		this.ProjectStatus = ProjectStatus;
	}

	public String getProjectStatus() {
		return ProjectStatus;
	}

	public void setTeamSize(int TeamSize) {
		this.TeamSize = TeamSize;
	}

	public int getTeamSize() {
		return TeamSize;
	}

	public void setTeamMember(List<String> TeamMember) {
		this.TeamMember = TeamMember;
	}

	public List<String> getTeamMember() {
		return TeamMember;
	}

	public void setProjectManager(ProjectManager ProjectManager) {
		this.ProjectManager = ProjectManager;
	}

	public ProjectManager getProjectManager() {
		return ProjectManager;
	}

}

class ProjectManager {
	String name;
	String empId;

	public ProjectManager(String name, String empId) {
		super();
		this.name = name;
		this.empId = empId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpId() {
		return empId;
	}

}

public class ComplexObject {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		List<String> list= new ArrayList<String>();
		list.add("John");
		list.add("David");
		list.add("Steve");
		
		ProjectManager proMan = new ProjectManager("Sagar", "Tp01");
		
		Project1 pobj = new Project1("Orange", "Ongoing", 5, list, proMan);
		ObjectMapper omap = new ObjectMapper();
		omap.writerWithDefaultPrettyPrinter().writeValue(new File("./complex.json"), pobj);
		System.out.println("=========End============");

	}

}
