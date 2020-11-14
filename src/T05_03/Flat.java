package T05_03;

import java.util.Arrays;


public class Flat 
{
	private ElectricalDevice[] devices;
	
	Flat(ElectricalDevice[] devices)
	{
		this.devices = devices;
	}
	
	public double power()
	{
		double s = 0;
		for (ElectricalDevice device: devices)
			s += device.getPower();
		return s;
	}
	
	public int find(double length, double width)
	{
		for (int i =0; i < devices.length; i++)
		{
			if (length == devices[i].getLength() &&
				devices[i].getWidth() == width)
				return i;
		}
		return -1;
	}
	
	public String toString()
	{
		return Arrays.toString(devices);
	}
	
	public void sort()
	{
		Arrays.sort(devices);
	}
}
