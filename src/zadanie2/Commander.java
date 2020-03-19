package zadanie2;

public class Commander {
	private static UserScanner scanner = new UserScanner();
	
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
				//simple files view
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
}
