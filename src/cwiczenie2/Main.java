package cwiczenie2;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String input;

		while(true) {
			input = scanner.nextLine();
			if (input.equals("exit")) {
				break;
			}
			System.out.println(input);
		}
		
		scanner.close();
	}

}
