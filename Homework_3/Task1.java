package Homework_3;
import java.util.Scanner;

//Task #1.4
/*
 * Abiturient: id, Прізвище, Ім'я, По батькові, адресу, телефон, 
 * Оцінки. Створити масив об'єктів. Вивести:
 *  a) список абітурієнтів, що мають незадовільні оцінки; 
 *  b) список абітурієнтів, укоторих сума балів вище заданої; 
 *  c) вибрати заданий число n абітурієнтів, що мають найвищу суму балів 
 *  (вивести також повний список абітурієнтів, що мають напівпрохідну суму).
 */

public class Task1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Abiturient[] abiturients = new Abiturient[5];
		int[] grades1 = {10, 2, 9, 10};
		abiturients[0] = new Abiturient(1, "vova", "aaa","sv", "",
										"", grades1);
		int[] grades2 = {11, 12, 9, 10};
		abiturients[1] = new Abiturient(2, "sasha", "bbb","sv", "",
										"", grades2);
		int[] grades3 = {7, 5, 9, 10};
		abiturients[2] = new Abiturient(3, "dima", "ccc","sv", "",
										"", grades3);
		int[] grades4 = {5, 2, 1, 4};
		abiturients[3] = new Abiturient(4, "misha", "ddd","sv", "",
										"", grades4);
		int[] grades5 = {8, 2, 9, 8};
		abiturients[4] = new Abiturient(5, "dasha", "fff","sv", "",
										"", grades5);
		
		System.out.println("Lowest grade: ");
		int lowest_grade = in.nextInt();
		System.out.println("Abiturients with bad grades: ");
		
		for (Abiturient abiturient: getByLowestGrades(abiturients, lowest_grade))
		{
			System.out.println(abiturient);
		}
		
		System.out.println("sum: ");
		int sum = in.nextInt();
		System.out.println("Abiturients with sum of grades greater than " + sum);
		for (Abiturient abiturient: getBySumOfGrades(abiturients, sum))
		{
			System.out.println(abiturient);
		}
		
		System.out.println("n: ");
		int n = in.nextInt();
		System.out.println(n + " abiturients with greatest sum of grades" );
		for (Abiturient abiturient: getByHighestSum(abiturients, n))
		{
			System.out.println(abiturient);
		}
	}
	
	public static Abiturient[] getByLowestGrades(Abiturient[] abiturients,
											  int lowest_grade)
	{
		Abiturient[] searched;
		int nums[] = new int[abiturients.length];
		int count = 0;
		
		for (int i = 0; i < nums.length; i++)
		{
			if (includeLowGrades(abiturients[i].getGrades(), lowest_grade))
				nums[count++] = i;
		}
		
		searched = new Abiturient[count];
		
		for (int i = 0; i < searched.length; i++)
		{
			searched[i] = abiturients[nums[i]];
		}
		
		return searched;
	}
	
	public static boolean includeLowGrades(int[] grades, int lowest_grade)
	{
		for (int i = 0; i < grades.length; i++)
		{
			if (grades[i] <= lowest_grade)
				return true;
		}
		
		return false;
	}
	
	public static Abiturient[] getBySumOfGrades(Abiturient[] abiturients, 
												int sum)
	{
		Abiturient[] searched;
		int[] nums = new int[abiturients.length];
		int count = 0;
		
		for (int i = 0; i < nums.length; i++)
		{
			if (getGradesSum(abiturients[i].getGrades()) > sum)
				nums[count++] = i;
		}
		
		searched = new Abiturient[count];
		
		for (int i = 0; i < searched.length; i++)
		{
			searched[i] = abiturients[nums[i]];
		}
		
		return searched;
	}
	
	public static int getGradesSum(int [] grades)
	{
		int sum = 0;
		
		for (int i = 0; i < grades.length; i++)
		{
			sum += grades[i];
		}
		
		return sum;
	}
	
	public static Abiturient[] getByHighestSum(Abiturient[] abiturients, 
											   int n)
	{
		int count = 0;
		int len = abiturients.length;
		Abiturient[] searched = new Abiturient[n];
		sortByGradesSum(abiturients);
		
		for (int i = len - n; i < len; i++)
		{
			searched[count++] = abiturients[i];
		}
		
		return searched;
	}
	
	public static void sortByGradesSum(Abiturient[] abiturients)
	{
		int n = abiturients.length;
		
		for (int i = n - 1; i > -1; i--)
		{
			boolean isSorted = true;
			
			for (int j = 0; j < i; j++)
			{
				if (getGradesSum(abiturients[j].getGrades()) > getGradesSum(abiturients[j + 1].getGrades()))
				{
					Abiturient temp = abiturients[j];
					abiturients[j] = abiturients[j + 1];
					abiturients[j + 1] = temp;
					isSorted = false;
				}
			}
			
			if (isSorted)
				break;
		}
		
	}
}

class Abiturient{
	private int id;
	private String name;
	private String surname;
	private String by_father;
	private String adress;
	private String phone_number;
	private int[] grades;
	
	Abiturient(int id, String name, String surname, String by_father, 
					   String adress, String phone_number, int[] grades)
	{
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.by_father = by_father;
		this.adress = adress;
		this.phone_number = phone_number;
		this.grades = grades;
	}
	
	Abiturient(int id, String name, String surname, String by_father, int[] grades)
	{
		this(id, name, surname, by_father, "", "", grades);
	}
	
	public String toString()
	{
		return this.id + " " + this.surname + " " + this.name + " " + this.by_father; 
	}
	
	public int getId() {return this.id;}
	public String getName() {return this.name;}
	public String getSurname() {return this.surname;}
	public String getByFather() {return this.by_father;}
	public String getAdress() {return this.adress;}
	public String getPhoneNumber() {return this.phone_number;}
	public int[] getGrades() {return this.grades;}
	
}