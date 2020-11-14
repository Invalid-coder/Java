package T05_03;

public class Teapot extends ElectricalDevice
{
	Teapot(double length, double width, String name)
	{
		super(length, width, name);
	}
	
	public void PlugIn(double duration)
	{
		this.power += 400 * duration;
	}
	
	public String toString()
	{
		return "Teapot. " + super.toString();
	}
}

