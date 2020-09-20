package Homework_1;
import java.util.Scanner;
//Task #1.3

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input;
		
		Scanner in = new Scanner(System.in);
		input = in.nextLine();
		
		String[] numbers = input.split("\\s");
		
		float a, b, geometryAverage;
		
		a = Float.parseFloat(numbers[0]);
		b = Float.parseFloat(numbers[1]);
		geometryAverage = (float)Math.sqrt(a * b); 
		
		System.out.printf("%f", geometryAverage);
		System.out.println();
		System.out.printf("%e", geometryAverage);
	}
	

}
