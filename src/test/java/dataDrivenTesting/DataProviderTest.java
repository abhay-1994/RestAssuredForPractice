package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelUltility.ExcelUtility;
import io.restassured.http.ContentType;
import pojoUtility.CreatePOJO;

import static io.restassured.RestAssured.*;

public class DataProviderTest {

	@Test(dataProvider = "getData")
	public void createProjectUsingDataProvider(String createdBy, String projectName, String status, int teamSize) {
		CreatePOJO pObj = new CreatePOJO(createdBy, projectName, status, teamSize);
		given().contentType(ContentType.JSON).body(pObj).when().post("http://49.249.28.218:8091/addProject")

				.then().log().all();

	}

	@DataProvider
	public Object[][] getData() throws Throwable {

		ExcelUtility eUtil = new ExcelUtility();
		int rownum = eUtil.getTotalRowCount("data");
		System.out.println(rownum);
		Object[][] objArr = new Object[rownum][4];

		for (int i = 0; i <rownum; i++) {
			objArr[i][0] = eUtil.readTheDataFromExcelSheet("data", i, 0);
			objArr[i][1] = eUtil.readTheDataFromExcelSheet("data", i, 1);
			objArr[i][2] = eUtil.readTheDataFromExcelSheet("data", i, 2);
			objArr[i][3] = eUtil.readTheDataFromExcelSheetInt("data", i, 3);
		}
		return objArr;

	}
}
