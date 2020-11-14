package T05_03;

public class Fridge extends ElectricalDevice
{
	Fridge(double length, double width, String name)
	{
		super(length, width, name);
	}
	
	public void PlugIn(double duration)
	{
		this.power += 900 * duration;
	}
	
	public String toString()
	{
		return "Fridge. " + super.toString();
	}
}
