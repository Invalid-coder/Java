package Homework_3;
import java.util.Scanner;
//Task #2.4
/*
 * Визначите клас Поліном ступеня n. 
 * Оголосити масив / список / множину із m полиномов 
 * і визначить суму поліномів масиву.
 */

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("m = ");
		int m = in.nextInt();
		Polinom[] array = new Polinom[m];
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.println("n = ");
			int n = in.nextInt();
			array[i] = new Polinom(n);
			array[i].inputCoef();
			System.out.println(array[i]);
		}
		
		Polinom sum = Polinom.sum(array);
		System.out.println("Sum = " + sum);
	}
}

class Polinom{
	private int n;
	private int[] coef;
	
	Polinom(int n)
	{
		this.n = n;
		this.coef = new int[n + 1];
	}
	
	public void inputCoef()
	{
		Scanner in = new Scanner(System.in);
		
		for (int i = 0; i < this.coef.length; i++)
		{
			System.out.println("p_"+ i + " = ");
			this.coef[i] = in.nextInt();
		}
	}
	
	public Polinom add(Polinom x)
	{
		int n = Math.min(this.n, x.n) + 1;
		int m = Math.max(this.n, x.n) + 1;
		Polinom res = new Polinom(m);
		int[] coef = new int[m];
		
		for (int i = 0; i < n; i++)
		{
			coef[i] = getCoef(i) + x.getCoef(i);
		}
		
		int[] remaining;
		
		if (n == x.n)
			remaining = x.getCoefList();
		else
			remaining = getCoefList();
		
		for (int i = n; i < res.n; i++)
		{
			coef[i] = remaining[i];
		}
		
		res.setCoef(coef);
		
		return res;
	}
	
	public int[] getCoefList()
	{
		return this.coef;
	}
	
	public int getCoef(int i)
	{
		return this.coef[i];
	}
	
	public void setCoef(int[] coef)
	{
		if (coef.length == this.n)
		{
			this.coef = coef;
		}
	}
	
	public static Polinom sum(Polinom[] array)
	{
		Polinom sum = array[0];
		
		for (int i = 1; i < array.length; i++)
		{
			sum = sum.add(array[i]);
		}
		
		return sum;
	}
	
	public String toString()
	{
		String s = "";
		
		for (int i = this.coef.length - 1; i > -1; i--)
		{
			if (i > 0)
				s += getCoef(i) + "*x^" + i + "+";
			else
				s += getCoef(i);
		}
		
		return s;
	}
}