package Homework_2;
import java.util.Scanner;
//Task 4.4
/*
 * Задана непорожня послідовність ненульових цілих чисел, 
 * за якою іде 0. Визначити кількість змін знаку в цій послідовності. 
 * Наприклад, у послідовності 1, −34, 8,14, −5, 0 знак змінюється три рази.
 */

public class Task3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		Scanner in = new Scanner(System.in);
		input = in.nextLine();
		
		String[] numbers = input.split("\\s");
		System.out.println(countSignChanges(numbers));
	}
	
	public static int countSignChanges(String[] numbers) {
		int counter = 0;
		boolean isPositive;
		
		if (Integer.parseInt(numbers[0]) > 0) isPositive = true;
		else isPositive = false;
		
		for(int i = 1; i < numbers.length - 1; i++) {
			int x = Integer.parseInt(numbers[i]);
			
			if (x > 0)
			{
				if (!isPositive)
				{
					isPositive = true;
					counter += 1;
				}
			}
			else
			{
				if (isPositive)
				{
					isPositive = false;
					counter += 1;
				}
			}
		}
		
		return counter;
	}
}
