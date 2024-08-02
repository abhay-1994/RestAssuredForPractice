package serialization_deserialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable {
	String name;
	int level;
	long score;
	int life;

	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}

}

public class JavaSerializationTest {

	public static void main(String[] args) throws Throwable {
		NFSGame userObj = new NFSGame("Abhay", 19, 60000, 2);
		FileOutputStream fOut = new FileOutputStream("./serialization.txt");// java representation of physical file
		ObjectOutputStream objOut = new ObjectOutputStream(fOut);// convert java object to binary
		objOut.writeObject(userObj);
		System.out.println("========end=======");
	}
}
