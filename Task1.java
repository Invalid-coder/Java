import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a, b;
		float h;
		a = in.nextInt();
		b = in.nextInt();
		System.out.println("Amount of digits: " + 
				Math.round(Math.floor(Math.log10(a + 1))));
		System.out.println("Amount of digits: " + 
				Integer.toString(b).length());
		h = 1 / ((float) 1 / a + (float) 1 / b);
		System.out.printf("Середнє гармонічне: %f", h);
		
	}
}
