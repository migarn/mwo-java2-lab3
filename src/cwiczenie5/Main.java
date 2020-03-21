package cwiczenie5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Main {

	public static void main(String args[]) throws Exception {
		
		
		Bureau bureau = initBureau();
		printBureau(bureau);
		saveBureau(bureau, "mi6.ser");
		Bureau loadedBureau = loadBureau("mi6.ser");
		printBureau(loadedBureau);
		
	}

	private static void saveBureau(Bureau bureau, String filename) throws Exception {
		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(bureau);
			out.close();
			fileOut.close();
			
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	private static Bureau loadBureau(String filename) throws Exception {
		 try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Bureau bureau = (Bureau) in.readObject();
			in.close();
			fileIn.close();
			return bureau;
			
		} catch (IOException i) {
			i.printStackTrace();
		}
		return null;
	}

	private static Bureau initBureau() {
		Bureau bureau = new Bureau("MI6");
		Agent agent007 = new Agent("James", "Bond", 35, "007");
		bureau.addAgent(agent007);

		Task task = new Task("darkMamba", "infiltrate, spy, destroy");
		agent007.addTask(task);
		
		Agent agentX = new Agent("Jerzy", "Malina", 85, "123");
		bureau.addAgent(agentX);
		
		Task task2 = new Task("Secret Mission", "To be secret");
		agentX.addTask(task2);
		
		Task task3 = new Task("More Secret Mission", "To be more secret");
		agentX.addTask(task3);

		return bureau;
	}
	
	private static void printBureau(Bureau bureau) {
		System.out.println("\nBureau name: " + bureau.getName());
		List<Agent> agents = bureau.getAgents();
		
		for (Agent agent : agents) {
			System.out.println("\nAgent " + agent.getName() + " " + agent.getSurname() + " " + agent.getNumber());
			List<Task> tasks = agent.getTasks();
			System.out.println("Tasks:");
			for (Task task : tasks) {
				System.out.println(task.getName());
			}
		}
	}
}
