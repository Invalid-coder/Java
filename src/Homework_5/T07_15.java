package Homework_5;

public class T07_15 {
	public static void main(String[] args) {
		DrawingNotebook n = new DrawingNotebook("My notebook", "First line,");
		n.write("Second line");
		n.print();
	}
}

interface Paper
{
	void write(String text);
}

abstract class Notebook implements Paper
{
	private String title;
	private String text;
	
	Notebook(String title, String text)
	{
		this.title = title;
		this.text = text;
	}
	
	public void write(String text)
	{
		this.text += text;
	}
	
	public void print()
	{
		System.out.print(title + ":" + text + "\n");
	}
	
}

final class DrawingNotebook extends Notebook
{
	DrawingNotebook(String title, String text)
	{
		super(title, text);
	}
}

