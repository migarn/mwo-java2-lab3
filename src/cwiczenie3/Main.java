package cwiczenie3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static String[] stringsToBeWritten = { "Joh Woo 001", "Robert Duval 002", "James Bond 007" };

	public static void main(String args[]) {
		saveStrings(stringsToBeWritten, "res/cwiczenie3/special-agents.txt");
		saveAgents(stringsToBeWritten, "res/cwiczenie3/special-agents.txt");
		modifyStrings("Added line", "Another added line", "res/cwiczenie3/special-agents.txt");
		createDirectoriesStructure();
		copyFile("res/cwiczenie3/special-agents.txt", "res/cwiczenie3/agents/active-agents/special-agents.txt");
		deleteDirectory("res/cwiczenie3/agents/missing-agents");
	}

	private static void saveAgents(String[] agents, String filename) {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File(filename), true));

			for (String string : agents) {
				pw.append(string);
				pw.println();
			}
			pw.close();
			System.out.println("File has been overwritten");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static void saveStrings(String[] strings, String filename) {
		try {
			PrintWriter newFile = new PrintWriter(filename, "UTF-8");

			for (String string : strings) {
				newFile.println(string);
			}
			newFile.close();
			System.out.println("File has been written");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private static void modifyStrings(String firstNewLine, String secondNewLine, String filename) {
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw");
			randomAccessFile.seek(0);
			randomAccessFile.writeBytes(firstNewLine);
			randomAccessFile.seek(randomAccessFile.length() / 2);
			randomAccessFile.writeBytes(secondNewLine);
			randomAccessFile.close();
			System.out.println("File has been modified");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void createDirectoriesStructure() {
		new File("res/cwiczenie3/agents/active-agents").mkdirs();
		try {
			Files.createDirectories(Paths.get("res/cwiczenie3/agents/missing-agents"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Folders have been created");

	}

	private static void copyFile(String sourcePathString, String destinationPathString) {
		Path sourcePath = Paths.get(sourcePathString);
		Path destinationPath = Paths.get(destinationPathString);

		try {
			Files.copy(sourcePath, destinationPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("File has been copied");
	}

	private static void deleteDirectory(String pathString) {
		Path path = Paths.get(pathString);
		try {
			Files.delete(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Directory has been deleted");
	}
}
