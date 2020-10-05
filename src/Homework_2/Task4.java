package Homework_2;
import java.util.Scanner;
//Task 5.3
/*
 * Напишить програму LongestRun.java що вводить цілі числа  
 * та виводить число яке зустрічається підряд наібільше разів та 
 * скільки саме разів (якщо таких чисел декілька виводиться найбільше з чисел). 
 * Приклад:  1 2 2 1 5 1 1 7 7 7 7 1 1, 
 * виведення Longest run: 4 consecutive 7s.
 */

public class Task4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, array[];
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		array = new int[n];
		
		for (int i = 0; i < array.length; i++)
		{
			array[i] = in.nextInt();
		}
		
		printResults(array);
	}
	
	public static void printResults(int array[])
	{
		int prev = array[0];
		int count = 1;
		int mostFrequent = prev;
		int mostFrequentCount = count;
		
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] == prev)
			{
				count += 1;
			}
			else
			{
				prev = array[i]; 
				count = 1;
			}
				
				
			if (count > mostFrequentCount)
			{
				mostFrequent = array[i];
				mostFrequentCount = count;
			}
			else if (count == mostFrequentCount)
			{
				if (array[i] > mostFrequent)
				{
					mostFrequent = array[i];
					mostFrequentCount = count;
				}
					
			}
		}
		
		System.out.println("Longest run: " + mostFrequentCount + " consecutive " + mostFrequent + "s");
		
	}
}
