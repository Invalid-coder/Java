package Classwork_2;
import java.util.Scanner;

/*
 * Ввести ціле число n (однобайтове число) і вивести число, 
 * отримане в результаті циклічного зсуву числа n на один розряд вліво, 
 * тобто старший біт посунутий в позицію молодшого, 
 * а всі інші біти зсуваються на один розряд вліво. 
 * Наприклад, якщо введено 130, відповіддю буде 5.

 */

public class T02_02 {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n, m, i, res;
		// 130: 10000010
		//   5: 00000101
		n = in.nextInt();
		System.out.println(Integer.toBinaryString(n));
		m = 1 << 7; // 10000000
		i = 7;
		while (m > n)
		{
			m >>= 1;
			i--;
		}
		System.out.println(i);
		res = n << 1; // 100000100
		System.out.println(Integer.toBinaryString(res));
		res = res & ((1 << (i + 1)) - 1); // 100000100 & 11111111
		System.out.println(Integer.toBinaryString(res));
		res = res | 1; // 100000101
		System.out.println(Integer.toBinaryString(res));
		System.out.println(res);
	}	
}
