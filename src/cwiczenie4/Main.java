package cwiczenie4;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) throws Exception {
		printFilesSimple("C:\\");
		System.out.println("\n-----------------------------------------------------\n");
		printFilesDetails("C:\\");
		System.out.println("\n-----------------------------------------------------\n");
		printFiles("C:\\", ".txt");
		System.out.println("\n-----------------------------------------------------\n");
		printTree("C:\\");
	}

	public static void printFilesSimple(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			System.out.println(file.getName());
		}
	}

	public static void printFilesDetails(String path) throws Exception {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		System.out.println(threeColumnsFormatter("nazwa pliku", "DIR lub rozmiar w bajtach", "data stworzenia") + "\n");

		for (File file : listOfFiles) {
			BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
			String name = file.getName();
			String dirOrBytes = basicFileAttributes.isDirectory() ? "DIR" : String.valueOf(basicFileAttributes.size());
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String creationTime = dateFormat.format(basicFileAttributes.creationTime().toMillis());
			System.out.println(threeColumnsFormatter(name, dirOrBytes, creationTime));
		}

	}

	public static void printFiles(String path, String extensionFilter) {
		File folder = new File(path);

		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File directory, String fileName) {
				return fileName.endsWith(extensionFilter);
			}
		};

		File[] listOfFiles = folder.listFiles(filter);

		for (File file : listOfFiles) {
			System.out.println(file.getName());
		}

	}

	public static void printTree(String path) {
		List<String> filesTree = createFilesTree(path, new ArrayList<String>());

		for (String s : filesTree) {
			s = s.substring(path.length());
			System.out.println(s);
		}
	}

	private static List<String> createFilesTree(String path, List<String> filesTree) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isDirectory() && Files.isReadable(file.toPath()) && isNotEmpty(file)) {
				createFilesTree(path + "\\" + file.getName(), filesTree);
			}

			else {
				filesTree.add(file.getAbsolutePath());
			}
		}

		return filesTree;
	}

	private static boolean isNotEmpty(File directory) {
		if (directory.listFiles().length != 0) {
			return true;
		}
		return false;
	}

	private static String threeColumnsFormatter(String s1, String s2, String s3) {
		return String.format("%-40s %-30s %-20s", s1, s2, s3);
	}
}
