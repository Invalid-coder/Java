package Homework_7;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Task 14
/*
* Дано рядок A, що містить послідовність слів. Скласти програми, що визначають:
* а) кількість усіх слів;
* б) кількість слів, що починаються із цифри та вивести їх
* в) кількість слів, що закінчуються з тризначного числа та вивести їх всіх
* г) кількість слів, що починаються й закінчуються одним символом
* ґ) кількість слів, що є електронною поштою
*/
public class Task1 {

	public static void main(String[] args) 
	{
		String s = "  Mr. Smith 98bought a cheapsite@gmail.com 7vova 89  " +
		" for   1.5\n                   " +
		"million dollars, i.e. he paid a lot for it!\n" +
		"Did he mind? Adam shasha777 i666 sdcdc123 Jones Jr. thinks he didn't.\n " +
		"In any case, this chte@gmail.com isn't true...\n" +
		"Well, with a probability of 0.9 it isn't. \n" +
		"Amount: 231.30.\n" +
		"Hello!         ";
		System.out.println(s + "\n");
		System.out.println(countOfWords(s));
		System.out.println();
		System.out.println(startsWithDigit(s));
		System.out.println();
		System.out.println(endsWith3Digits(s));
		System.out.println();
		System.out.println(countOfWordsWithOneCharacter(s));
		System.out.println();
		System.out.println(countOfEmails(s));
	}
	
	public static int countOfWords(String s)
	{
		Pattern p = Pattern.compile("\\b((?:[\\w\\-\\']+\\.?)+)(?<![\\w\\'\\.]{3}\\.)(?:\\s|\\b)");
		Matcher m = p.matcher(s);
		int count = 0;
		while (m.find())
			count++;
		return count;
	}
	
	public static int startsWithDigit(String s)
	{
		Pattern p = Pattern.compile("\\b\\d[A-Za-z0-9._%+-]+\\b");
		Matcher m = p.matcher(s);
		int counter = 0;
		while (m.find())
		{
			System.out.println(m.start()+" "+ m.group());
			counter++;
		}
		
		return counter;
	}
	
	public static int endsWith3Digits(String s)
	{
		Pattern p = Pattern.compile("\\b[A-Za-z0-9._%+-]+\\d\\d\\d\\b");
		Matcher m = p.matcher(s);
		int counter = 0;
		while (m.find())
		{
			System.out.println(m.start()+" "+ m.group());
			counter++;
		}
		
		return counter;
	}
	
	public static int countOfWordsWithOneCharacter(String s)
	{
		Pattern p = Pattern.compile("\\s(\\w)\\s");
		Matcher m = p.matcher(s);
		int counter = 0;
		while (m.find())
		{
			System.out.println(m.start()+" "+ m.group(1));
			counter++;
		}
		
		return counter;
	}
	
	public static int countOfEmails(String s)
	{
		Pattern p = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
		Matcher m = p.matcher(s);
		int counter = 0;
		while (m.find())
		{
			System.out.println(m.start()+" "+ m.group());
			counter++;
		}
		return counter;
	}
	
	
	


}
