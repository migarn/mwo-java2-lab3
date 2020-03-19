package zadanie2;

import cwiczenie4.Main;

public class Commander {
	private static UserScanner scanner = new UserScanner();
	private static Main fileViewer = new Main();

	public static void main(String args[]) {
		mainMenu();
	}

	public static void mainMenu() {
		boolean inLoop = true;
		String instruction = "\nType: \n1 - to print simple files view" + "\n2 - to print detailed files view"
				+ "\n3 - to print files with specific extension" + "\n4 - to print files tree" + "\n5 - to exit";

		while (inLoop) {
			int choice = scanner.scanSelectionList(instruction, 1, 2, 3, 4, 5);

			if (choice == 1) {
				simpleView();
			} else if (choice == 2) {
				detailedView();
			} else if (choice == 3) {
				specificExtensionView();
			} else if (choice == 4) {
				treeView();
			} else {
				System.out.println("\nApplication terminated.");
				inLoop = false;
			}
		}
	}

	public static void simpleView() {
		String path = readPathMenu();

		if (path != null) {
			try {
				System.out.println("\nSimple view of " + path + ":\n");
				fileViewer.printFilesSimple(path);
			} catch (Exception e) {
				System.out.println("Path not found");
			}
		}
	}
	
	public static void detailedView() {
		String path = readPathMenu();

		if (path != null) {
			try {
				System.out.println("\nDetailed view of " + path + ":\n");
				fileViewer.printFilesDetails(path);
			} catch (Exception e) {
				System.out.println("Path not found");
			}
		}
	}
	
	public static void specificExtensionView() {
		String path = readPathMenu();
		String extension = readExtension();

		if (path != null && extension != null) {
			try {
				System.out.println("\nList of ." + extension + " files in " + path + ":\n");
				fileViewer.printFiles(path, "." + extension);
			} catch (Exception e) {
				System.out.println("Path not found");
			}
		}
	}
	
	public static void treeView() {
		String path = readPathMenu();

		if (path != null) {
			try {
				System.out.println("\nTree view of " + path + ":\n");
				fileViewer.printTree(path);
			} catch (Exception e) {
				System.out.println("Path not found");
			}
		}
	}

	public static String readPathMenu() {

		while (true) {
			int choice = scanner.scanSelectionList("\nType:\n1 - to type path\n2 - to return", 1, 2);

			if (choice == 1) {
				return scanner.scanString("\nType path (e.g. C:\\\\Windows) and press ENTER:");
			}

			else if (choice == 2) {
				return null;
			}
		}
	}
	
	public static String readExtension() {

		while (true) {
			int choice = scanner.scanSelectionList("\nType:\n1 - to type extension\n2 - to return", 1, 2);

			if (choice == 1) {
				return scanner.scanString("\nType extension (e.g. txt) and press ENTER:");
			}

			else if (choice == 2) {
				return null;
			}
		}
	}
}
