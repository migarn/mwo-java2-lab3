package zadanie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Skynet {
	
	private String login = "Reese";
	private String password = "#Terminate";
		
	public static void main(String args[]) {
		Skynet skynet = new Skynet();
		skynet.run();
	}
	
	public void run() {
		readCredentials();
		printSkyNetLogo();
		runLoginPanel();
	}
	
	private void runLoginPanel() {
		String readLogin;
		String readPassword;
		boolean credentialsOK;
		do {
			readLogin = getTextFromInput("Login");
			readPassword = getTextFromInput("Password");
			credentialsOK = verifyCredentials(readLogin, readPassword); 
			if (!credentialsOK) {
				System.out.println("Wrong login or password. Try again.");
			}
		} while (!credentialsOK);
		System.out.println();
		System.out.println("Welcome to SKYNET...");
	}
	
	private String getTextFromInput(String label) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pass " + label);

		return scanner.nextLine();
	}
	
	private boolean verifyCredentials(String login, String password) {
		return this.login.equals(login) && this.password.equals(password);
	}
	 
	private void readCredentials() {
		File credentials = new File("res/zadanie1/skynet.conf");
		try {
			Scanner scanner = new Scanner(credentials);
			String tempLogin = scanner.nextLine();
			String tempPassword = scanner.nextLine();
			if (tempLogin != null && tempPassword != null) {
				this.login = tempLogin;
				this.password = tempPassword;
			}			
			System.out.println("INFO System reconfigured...");
		} catch (FileNotFoundException e) {
			System.out.println("INFO No valid conf data");
			e.printStackTrace();
		}
	}
	
	private void printSkyNetLogo() {
		
		File logo = new File("res/zadanie1/logo.txt");
		try {
			Scanner scanner = new Scanner(logo);
			
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
