package Homework_2;
//Task 5.7
import java.util.Scanner;
/*
 * Знайти число, цифри в якому йдуть по зростанню. 
 * Якщо їх декілька, виведіть всі.
 */

public class Task5 {

	public static void main(String[] args) 
	{
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
		int results[] = new int[array.length];
		int i = 0;
		
		for (int x: array)
		{
			if (isIncreasing(x))
			{
				results[i] = x;
				i++;
			}
		}
		
		for (int j = 0; j < i; j++)
		{
			System.out.println(results[j]);
		}
	}
	
	public static boolean isIncreasing(int num)
	{
		int prev = num % 10;
		num /= 10;
				
		while (num > 0)
		{
			if (prev < num % 10)
			{
				return false;
			}
			prev = num % 10;
			num /= 10;
			
		}
		
		return true;
	}
}
