package cwiczenie5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException {
		  try {
		         FileOutputStream fileOut =
		         new FileOutputStream("res/cwiczenie5/dane.ser");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(String.valueOf("jakas nazwa"));
		         out.writeObject(Integer.valueOf(5));
		         out.close();
		         fileOut.close();
		    } catch(IOException i) {
		         i.printStackTrace();
		    }
				
		try {
			FileInputStream fileIn = new FileInputStream("res/cwiczenie5/dane.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			System.out.println(in.readObject());
			System.out.println(in.readObject());

			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

}
