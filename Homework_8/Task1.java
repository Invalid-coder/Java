package Homework_8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
//Task 4
/*
* 4)Визначити функцію, що визначає кількість рядків текстового файла, що: 
* а) починаються із заданого символу; 
* б) закінчуються заданим символом; 
* в) починаються й закінчуються одним і тим самим символом; 
* г) складаються з однакових символів.
*/
public class Task1 {
	public static void main(String[] args) 
	{
		System.out.println(f1("input.txt", "output_t01_f1_1.txt", 'a'));
		System.out.println(f2("input.txt", "output_t01_f1_1.txt", 'y'));
		System.out.println(f3("input.txt", "output_t01_f1_1.txt"));
		System.out.println(f4("input.txt", "output_t01_f1_1.txt", 10));
	}
	
	public static int f1(String input, String output, char start)
	{
		Scanner inp = null;
		PrintWriter out = null; // System.out
		int counter = 0;
		
		try
		{
			FileReader fr = new FileReader(input);
			BufferedReader bf = new BufferedReader(fr);
			inp = new Scanner(bf);
			
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			
			while (inp.hasNext())
			{
				String s = inp.nextLine();
				s.trim();
				
				if (startsWith(s, start))
				{
					System.out.println(s);
					counter++;
				}
				
			}
			out.print(counter);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			if (inp != null)
				inp.close();
			if (out != null)
				out.close();
		}
		
		return counter;
		
	}
	
	public static int f2(String input, String output, char end)
	{
		Scanner inp = null;
		PrintWriter out = null; // System.out
		int counter = 0;
		
		try
		{
			FileReader fr = new FileReader(input);
			BufferedReader bf = new BufferedReader(fr);
			inp = new Scanner(bf);
			
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			
			while (inp.hasNext())
			{
				String s = inp.nextLine();
				s.trim();
				
				if (endsWith(s, end))
				{
					System.out.println(s);
					counter++;
				}
				
			}
			out.print(counter);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			if (inp != null)
				inp.close();
			if (out != null)
				out.close();
		}
		
		return counter;
		
	}
	
	public static int f3(String input, String output)
	{
		Scanner inp = null;
		PrintWriter out = null; // System.out
		int counter = 0;
		
		try
		{
			FileReader fr = new FileReader(input);
			BufferedReader bf = new BufferedReader(fr);
			inp = new Scanner(bf);
			
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			
			while (inp.hasNext())
			{
				String s = inp.nextLine();
				s.trim();
				
				if (s.length() == 0)
					continue;
				
				char first = s.charAt(0);
				
				if (endsWith(s, first))
				{
					System.out.println(s);
					counter++;
				}
				
			}
			out.print(counter);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		finally
		{
			if (inp != null)
				inp.close();
			if (out != null)
				out.close();
		}
		
		return counter;
		
	}
	
	public static int f4(String input, String output, int n)
	{
		Path pathInp = Paths.get(input);
		Path pathOut = Paths.get(output);
		int counter = 0;
		
		try
		{
			List<String> lines =  Files.readAllLines(pathInp);
			String base = lines.get(n).trim().toLowerCase();
			HashSet<Character> baseSet = getSet(base.toCharArray());
			
			for (int i = 0; i < lines.size(); i++)
			{
				if (i == n)
					continue;
				
				String str = lines.get(i).trim().toLowerCase();
				HashSet<Character> checkSet = getSet(str.toCharArray());
				
				
				if (baseSet.equals(checkSet))
				{
					System.out.println(str);
					counter++;
				}
			}
			
			Files.write(pathOut, lines);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		
		return counter;
	}
	
	public static HashSet<Character> getSet(char [] chars)
	{
		HashSet<Character> hashSet = new HashSet<Character>();
		
		for (Character character : chars)
		{
	        hashSet.add(character);
	    }
		
		return hashSet;
	}
	
	public static boolean startsWith(String s, char start)
	{
		Pattern p = Pattern.compile("^" + start);
		Matcher m = p.matcher(s);
		
		if (m.find())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean endsWith(String s, char end)
	{
		Pattern p = Pattern.compile(end + "$");
		Matcher m = p.matcher(s);
		
		if (m.find())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
