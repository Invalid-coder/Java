package Homework_2;
//Task 2.4
import java.util.Scanner;
/*
 * Викреслити i-й біт з двійкового представлення натурального числа 
 * (молодші i-го біти залишаються на місці, старші зсуваються на один розряд вправо).
 * Наприклад, якщо введені 11 і 2, відповіддю буде 7.
 */

public class Task2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, i;
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		i = in.nextInt();
		System.out.println(Integer.toBinaryString(num));
		int left = (num >> i + 1) << i;
		int right = num & ((1 << i) - 1);
		int res = left + right;
		System.out.println(left);
		System.out.println(Integer.toBinaryString(left));
		System.out.println(right);
		System.out.println(Integer.toBinaryString(right));
		System.out.println(Integer.toBinaryString(res));
		System.out.println(res);
		
	}

}
