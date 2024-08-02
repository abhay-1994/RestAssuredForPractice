package mockingSolutions;

import org.mockito.Mockito;

class PANCard{
	public  String isValid(String panCard) {
		if (panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true){
			return "Is Valid PAN";
		}
		return "Is Valid not PAN";
	}
	
		
		
	public static PANCard getMockObject() {
	
		
		PANCard mockObj = Mockito.mock(PANCard.class);
		Mockito.when(mockObj.isValid("ABCDE1234A")).thenReturn("Valid PAN card;");
		Mockito.when(mockObj.isValid("ABCDE1234B")).thenReturn("Valid PAN card;");
		Mockito.when(mockObj.isValid("ZBCDE1234C")).thenReturn("Invalid PAN card;");
		return mockObj;

	}
}

public class MockingServerTest {

	public static void main(String[] args) {
		PANCard pobJ = PANCard.getMockObject();
System.out.println(pobJ.isValid("ZBCDE1234C"));
		
	}

}
