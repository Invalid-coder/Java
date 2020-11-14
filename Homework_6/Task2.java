package Homework_6;
import java.util.Scanner;
//Task 17
/*
* Скласти  програму, яка за рядком А та символом S будує новий рядок, 
* отриманий заміною кожного символу, слідуючого за S, 
* заданим символом С.
*/
public class Task2 {
	public static void main(String[] args) {
		String a, s, c;
		Scanner in = new Scanner(System.in);
		System.out.println("a = ");
		a = in.nextLine();
		System.out.println("s = ");
		s = in.next();
		System.out.println("c = ");
		c = in.next();
		String res = f(a, s.charAt(0), c.charAt(0));
		System.out.println(res);
	}
	
	public static String f(String a, char s, char c)
	{
		char rez[] = a.toCharArray();
		
		for (int i = 0; i < rez.length - 1; i++)
		{
			if (rez[i] == s)
				rez[i + 1] = c;
		}
		
		return new String(rez);
	}
}
