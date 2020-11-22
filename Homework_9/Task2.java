package Homework_9;

import java.io.*;
import java.util.Vector;
import java.util.Arrays;

//Task 2в
/*
* )Серіалізація: Дано файл,  який містить  відомості  про  іграшки:  указано  назву 
* іграшки (напр., м'яч,  лялька,  конструктор  тощо),  її  вартість  у  гривнях  і 
* вікові межі для дітей, яким  іграшка призначається (напр., для дітей від 
* двох до п'яти років). Скласти процедуру
* пошуку назв найдорожчих іграшок (ціна яких відрізняється від ціни 
* найдорожчої іграшки не більш ніж на 50 грн); 
*/

public class Task2
{

	public static void main(String[] args) 
	{
		Toy[] toys =
			{
					new Toy("Toy1", 200, 2, 5),
					new Toy("Toy2", 100, 5, 10),
					new Toy("Toy3", 150, 3, 12),
					new Toy("Toy4", 10, 3, 12),
					new Toy("Toy5", 170, 3, 12),
					new Toy("Toy6", 180, 3, 12)
			};
		
		save("input.toys", toys);
		
		toys = null;
		
		toys = loadToys("input.toys");
		String[] names = findMostExpensiveToyNames(toys);
		
		for(String name: names)
			System.out.println(name);
		
	}
	
	public static void 
	save(String filename, Toy[] toys)
	{
		FileOutputStream fos;
		BufferedOutputStream bos;
		ObjectOutputStream oos;
		
		try
		{
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			for (int i = 0; i < toys.length; i++)
				oos.writeObject(toys[i]);
			
			oos.close();
		}
		catch (IOException e) {System.out.println(e);}
	}
	
	public static Toy[]
	loadToys(String filename)
	{
		FileInputStream fis;
		BufferedInputStream bis;
		ObjectInputStream ois;
		
		try
		{
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			Vector<Toy> v = new Vector<Toy>();
			
			try
			{
				while (true)
				{
					Toy p;
					p = (Toy) ois.readObject();
					v.add(p);
				}
			}
			catch (EOFException e)
			{
				ois.close();
				Toy[] array = new Toy[v.size()];
				for (int i = 0; i < array.length; i++)
					array[i] = v.get(i);
				return array;
			}
			catch (ClassNotFoundException e)
			{System.out.println(e);}
		}
		catch (IOException e) {System.out.println(e);}
		return null;
	}
	

	public static int findMaxPrice(Toy[] toys)
	{
		int maxPrice = toys[0].price;
		
		for (int i = 1; i < toys.length; i++)
		{
			if (toys[i].price > maxPrice)
				maxPrice = toys[i].price;
		}
		
		return maxPrice;
	}
	
	public static String[]
			findMostExpensiveToyNames(Toy[] toys)
	{
		int maxPrice = findMaxPrice(toys);
		String[] temp = new String[toys.length];
		int i = 0;
		
		for (Toy toy: toys)
		{
			if (maxPrice - toy.price <= 50)
				temp[i++] = toy.name;
		}
		String[] ans = new String[i];
		
		for(int j = 0; j < i; j++)
			ans[j] = temp[j];
		
		return ans;
	}

}

class Toy implements Serializable
{
	private static final long serialVersionUID = 1L;
	public int price;
	public int from;
	public int to;
	public String name;
	
	Toy(String name, int price, int from, int to)
	{
		this.price = price;
		this.name = name;
		this.from = from;
		this.to = to;
	}
	
	public String toString()
	{
		return name + " " + price + " from " + from + " to " + to;
	}
}
