package serialization_deserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class JavaDeserializationTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fIn = new FileInputStream("./serialization.txt");//read the file
		
		ObjectInputStream objIn = new ObjectInputStream(fIn);
		NFSGame userObj=(NFSGame)objIn.readObject();
		System.out.println(userObj.name);
		System.out.println(userObj.level);
		System.out.println(userObj.life);
		System.out.println(userObj.score);
		
		

	}

}
