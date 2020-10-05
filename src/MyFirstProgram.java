import java.util.Scanner;
/**
 * 
 * @author natasha
 * @version 1.0
 *
 */
public class MyFirstProgram {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name;
		System.out.println("Name: ");
		name = in.nextLine();
		System.out.println("Hello, " + name + "!");

	}

}
