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
		String instruction = "\nType: \n1 - to print simple files view" + 
				"\n2 - to print detailed files view" + 
				"\n3 - to print files with specific extension" + 
				"\n4 - to print files tree" + 
				"\n5 - to exit";
		
		while (inLoop) {
			int choice = scanner.scanSelectionList(instruction, 1, 2, 3, 4, 5);
			
			if (choice == 1) {
				simpleView();
			}
			else if (choice == 2) {
				//detailed files view
			}
			else if (choice == 3) {
				// files view with extension
			}
			else if (choice == 4) {
				//files tree
			}
			else {
				System.out.println("\nApplication terminated.");
				inLoop = false;
			}
		}
	}
	
	public static boolean simpleView() {
		
	}
	
	public static String readPathMenu() {
		
		while (true) {
			int choice = scanner.scanSelectionList("\nType:\n1 - to type path\n2 - to return", 1, 2);
			
			if (choice == 1) {
				return scanner.scanString("Type path (e.g. C:\\Windows) and press ENTER:");
			}

			else if (choice == 2) {
				return null;
			}
		}
	}
}
