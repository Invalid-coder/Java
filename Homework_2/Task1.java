package Homework_2;
import java.util.Scanner;
//Task 2.3
/*
 * Визначити, скільки разів зустрічається 11 в двійковому поданні 
 * цілого додатнього числа (так, в двійковому поданні 11110111 воно 
 * зустрічається 5 разів).
 */

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, res;
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		System.out.println(Integer.toBinaryString(num));
		res = getAmount(num);
		System.out.println(res);
		
	}
	
	public static int getAmount(int num) {
		int counter = 0;
		int i = 0;
		
		while (num > 0) {
			if ((num & 1) == 1) i += 1;
			else i = 0;
			if (i >= 2) counter += 1;
			
			num >>= 1;
		}
		
		return counter;
	}

}
