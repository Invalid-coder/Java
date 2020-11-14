package T05_03;

public abstract class ElectricalDevice implements Comparable<ElectricalDevice>
{
	protected double length;
	protected double width;
	protected double power;
	protected String name;
	
	ElectricalDevice(double length, double width,String name)
	{
		this.length = length;
		this.width = width;
		this.name = name;
		this.power = 0;
	}
	
	public double getLength() {return length;}
	public double getWidth() {return width;}
	public double getPower() {return power;}
	abstract public void PlugIn(double duration);
	
	public String toString()
	{
		return ("Електроприлад." + 
				"Назва: " + name + ". " +
 				"Довжина приладу:" + length + ". " +
				"Ширина приладу: " + width + ". " +
				"Споживана потужність: " + getPower() + ".\n");
	}
	
	public int compareTo(ElectricalDevice f)
	{
		if (getPower() > f.getPower())
			return 1;
		else if (getPower() == f.getPower())
			return 0;
		else
			return -1;
	}
}
