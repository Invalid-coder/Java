package Homework_1;
import java.util.Scanner;
//Task #1.4

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float C, F;
		Scanner in = new Scanner(System.in);
		System.out.println("Введіть число градусів Цельсія: ");
		C = in.nextFloat();
		F = 9 * C / 5 + 32;
		System.out.printf("'F=%.1f", F);
	}

}
