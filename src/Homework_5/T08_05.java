package Homework_5;
import java.util.Vector;

public class T08_05 {
	public static void main(String[] args) {
		Department d = new Department();
		d.append("Director", "Vova");
		d.append("Manager", "Dima");
		d.append("Cleaner", "Sasha");
		d.append("Acountant", "Pasha");
		System.out.println(d);
	}
}

class Department
{
	class Employee
	{
		private String position;
		private String name;
		
		Employee(String position, String name)
		{
			this.position = position;
			this.name = name;
		}
		
		public String toString()
		{
			return position + ": " + name; 
		}
	}
	
	private Vector<Employee> employees = new Vector<Employee>();
	
	public void append(String position, String name)
	{
		employees.addElement(new Employee(position, name));
	}
	
	public String toString()
	{
		return employees.toString();
	}
	
	public void clear()
	{
		employees.clear();
	}
}