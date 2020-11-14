package Homework_1;
//Task #1.7

public class Task3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int product = 1;
		
		for(int i = 0; i < args.length; i++) {
			product *= Integer.parseInt(args[i]);
		}
		
		System.out.println(product);
	}
}
