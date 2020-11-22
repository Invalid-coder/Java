package Homework_9;
import java.io.*;
import java.util.Vector;
import java.util.Arrays;
import java.nio.ByteBuffer;
//Task 2в
/*
* Дано файл, компоненти якого є цілими числами. Скласти підпро
* грами для обчислення: 
* різниці між найбільшим парним і найменшим непарним числами 
* компонент
*/

public class Task1
{
	public static void main(String[] args) 
	{
		int[] a = {2, 3, -4, 8, 1};
		int[] b;
		
		writeIntArray("input.int", a);
		b = readIntArray("input.int");
		System.out.println(Arrays.toString(b));
		System.out.println(func(b));
	}
	
	public static void 
	writeIntArray(String filename, int[] array)
	{
		FileOutputStream fos;
		BufferedOutputStream bos;
		DataOutputStream dos;
		
		try
		{
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			
			for (int i = 0; i < array.length; i++)
				dos.writeInt(array[i]);
			
			dos.close();
		}
		catch (IOException e) {System.out.println(e);}
	}
	
	public static int[]
	readIntArray(String filename)
	{
		FileInputStream fis;
		BufferedInputStream bis;
		DataInputStream dis;
		
		try
		{
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			Vector<Integer> v = new Vector<Integer>();
			
			try
			{
				while (true)
				{
					int d = dis.readInt();
					v.add(d);
				}
			}
			catch (EOFException e)
			{
				dis.close();
				int[] array = new int[v.size()];
				for (int i = 0; i < array.length; i++)
					array[i] = (int) v.get(i);
				return array;
			}
		}
		catch (IOException e) {System.out.println(e);}
		return null;
	}
	
	public static int findMaxPairedNumber(int[] array)
	{
		int ans = array[0];
		
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] % 2 == 0)
			{	
				if (array[i] > ans || ans % 2 == 1)
					ans = array[i];
			}
		}
		
		if (ans % 2 == 0)
		{
			return ans;
		}
		else
			return 0;
	}
	
	public static int findMinUnPairedNumber(int[] array)
	{
		int ans = array[0];
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] % 2 == 1)
			{
				if (array[i] < ans || ans % 2 == 0)
					ans = array[i];
			}
		}
		
		if (ans % 2 == 1)
		{
			return ans;
		}
		else
			return 0;
	}
	
	public static int func(int[] array)
	{
		return findMaxPairedNumber(array) - findMinUnPairedNumber(array);
	}
}