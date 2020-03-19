package cwiczenie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		readChars("res/cwiczenie1/poem.txt");
	}
	
	private static void scanFile(String filename, String keyword) throws Exception {
	
		File poemFile = new File(filename);
		Scanner scanner = new Scanner(poemFile);
		int count = 0;
		while (scanner.hasNext()) {
			String token = scanner.next();
			if(token.contains(keyword)) {
				count++;
				System.out.println(token);
			}
		}
		System.out.println("----------------------\nFound tokens: " + count);
		System.out.println("File path: " + poemFile.getPath());
		System.out.println("Free space: " + (poemFile.getFreeSpace() / 1024 / 1024) + " MB");
		System.out.println("Free space: " + (poemFile.getFreeSpace() / 1024 / 1024 / 1024) + " GB");
		scanner.close();
	}
	
	private static void readFile(String filename, String... keywords) {
		File poemFile = new File(filename);
		try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
		    String line = null;
		    int lineIndex = 0;
		    while ((line = reader.readLine()) != null) {
		    	lineIndex++;
		    	
		    	for (String keyword : keywords) {
		    		if (line.contains(keyword)) {
		    			System.out.println("Line number " + lineIndex + ": " + line);
		    			break;
		    		}	        
		    	}
		    	
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s", x);
		}
	}
	
	private static void readChars(String filename) {
		File poemFile = new File(filename);
		try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
		    int readByte;
		    while ((readByte = reader.read()) != -1) {
		    	System.out.print((char)readByte);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s", x);
		}
	}

}
