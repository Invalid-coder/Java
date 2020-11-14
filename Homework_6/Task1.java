package Homework_6;

import java.util.Scanner;
import java.util.Scanner;
//Task 8a
/*
* В заданий рядок входять тільки цифри та літери. 
* Визначити, чи задовольняє він наступній властивості:
* а) рядок є десятковим записом числа, кратного 9 (6, 4);
*/
public class Task1 {
	public static void main(String[] args) {
		String s;
		Scanner in = new Scanner(System.in);
		System.out.println("s = ");
		s = in.next();
		f(s);
	}
	public static Boolean isNum(String s)
	{
		char ca[] = s.toCharArray();
		
		for (int i = 0; i < ca.length; i++)
		{
			if (Character.isDigit(ca[i]))
				continue;
			else
				return false;
			
		}
		
		return true;
	}
	
	public static void f(String s)
	{
		if (isNum(s))
		{
			char ca[] = s.toCharArray();
			
			int num = Integer.parseInt(s);
			
			if (num % 9 == 0)
			{
				System.out.println("Кратне 9");
			}
			if (num % 6 == 0)
			{
				System.out.println("Кратне 6");
			}
			if (num % 4 == 0)
			{
				System.out.println("Кратне 4");
			}
		}
		else
		{
			System.out.println("Це не число!");
		}
		
		
	}

}
