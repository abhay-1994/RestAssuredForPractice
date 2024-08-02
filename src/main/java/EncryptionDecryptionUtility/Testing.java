package EncryptionDecryptionUtility;

public class Testing {

	public static void main(String[] args) throws Exception {
		EncryptAndDecryptUtility ed = new EncryptAndDecryptUtility();
		System.out.println(ed.encrypt("Abhay", "AcO3tEam@j!tu_#1"));
		
		
		
		String dec = ed.decrypt("JLeDEX+u0CaEIo8bGsFlAg==", "AcO3tEam@j!tu_#1");
		System.out.println(dec);
	}
}
