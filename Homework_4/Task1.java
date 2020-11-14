package Homework_4;
import java.util.Arrays;
//Task 4.4
/*
 * Створити об'єкт класу Держава, використовуючи класи 
 * Область, Район, Місто. Методи: вивести на консоль столицю, 
 * кількість областей, площа, обласні центри.
 */

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		City[] arr1 = new City[2];
		arr1[0] = new City("City1", 100);
		arr1[1] = new City("City2", 150);
		City[] arr2 = new City[2];
		arr2[0] = new City("City3", 200);
		arr2[1] = new City("City4", 250);
		City[] arr3 = new City[2];
		arr3[0] = new City("City5", 150);
		arr3[1] = new City("City6", 140);
		City[] arr4 = new City[2];
		arr4[0] = new City("City7", 280);
		arr4[1] = new City("City8", 120);
		District[] districts1 = new District[2];
		districts1[0] = new District(arr1, "Distrcit1");
		districts1[1] = new District(arr2, "Distrcit2");
		District[] districts2 = new District[2];
		districts2[0] = new District(arr3, "Distrcit3");
		districts2[1] = new District(arr4, "Distrcit4");
		Region[] regions = new Region[2];
		regions[0] = new Region(districts1, "Region1", arr1[1]);
		regions[1] = new Region(districts2, "Region2", arr4[0]);
		Country country = new Country(regions, "Country", arr1[0]);
		System.out.println(country);
		country.printCapital();
		country.printRigeonsAmount();
		country.printRegionCentres();
		System.out.println("Square of country: " + country.getSquare());
	}

}

class City extends Object{
	private String name;
	private int square;
	
	City(String name, int square) 
	{
		this.name = name; 
		this.square = square;
	}
	
	public String toString() { return this.name;}
	
	public boolean equals(Object obj)
	{
		if (!(obj instanceof City))
			return false;
		else
			return this.name.equals(((City) obj).name);
	}
	
	public int hashCode() {return this.name.hashCode();}
	
	public int getSquare() {return this.square;}
}

class District
{
	private City[] cities;
	private String name;
	
	District(City[] cities, String name) 
	{
		this.cities = cities; 
		this.name = name;
	}
	
	public String toString() 
	{
		String s = this.name + "\n";
		
		for (int i = 0; i < this.cities.length; i++)
			s += this.cities[i] + " ";
		
		return s;
		//return Arrays.toString(this.words);
	}
	
	public boolean equals(Object obj)
	{
		if (!(obj instanceof District))
			return false;
		return Arrays.equals(this.cities, ((District) obj).cities);
	}
	
	public int hashCode()
	{
		return Arrays.hashCode(this.cities) + this.name.hashCode();
	}
	
	public void addCity(City newcity)
	{
		City[] newcities = new City[this.cities.length + 1];
		int i = 0;
		for (; i < this.cities.length; i++)
			newcities[i] = this.cities[i];
		newcities[i] = newcity;
		this.cities = newcities;
	}
	
	public int getSquare()
	{
		int square = 0;
		
		for (int i = 0; i < this.cities.length; i++)
		{
			square += this.cities[i].getSquare();
		}
		
		return square;
	}
}

class Region
{
	private District[] districts;
	private String name;
	private City centre;
	
	Region(District[] districts, String name, City centre) 
	{
		this.districts = districts; 
		this.name = name;
		this.centre = centre;
	}
	
	public String getName() { return this.name;}
	
	public String toString() 
	{
		String s = this.name + "\n";
		
		for (int i = 0; i < this.districts.length; i++)
			s += this.districts[i] + "\n";
		
		return s;
		//return Arrays.toString(this.words);
	}
	
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Region))
			return false;
		return Arrays.equals(this.districts, ((Region) obj).districts);
	}
	
	public int hashCode()
	{
		return Arrays.hashCode(this.districts) + this.name.hashCode();
	}
	
	public void addDistrict(District newdistrict)
	{
		District[] newdistricts = new District[this.districts.length + 1];
		int i = 0;
		for (; i < this.districts.length; i++)
			newdistricts[i] = this.districts[i];
		newdistricts[i] = newdistrict;
		this.districts = newdistricts;
	}
	
	public String getCentre()
	{
		return this.centre.toString();
	}
	
	public int getSquare()
	{
		int square = 0;
		
		for (int i = 0; i < this.districts.length; i++)
		{
			square += this.districts[i].getSquare();
		}
		
		return square;
	}
}

class Country
{
	private Region[] regions;
	private String name;
	private City capital;
	
	Country(Region[] regions, String name, City capital)
	{
		this.regions = regions;
		this.name = name;
		this.capital = capital;
	}
	
	public String toString()
	{
		String s = this.name + ".\n";
		s += "Capital: " + this.capital + ".\n\n";
		
		for (int i = 0; i < this.regions.length; i++)
			s += this.regions[i] + "\n";
		return s;
		//return Arrays.toString(this.sentences);
	}
	
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Country))
			return false;
		return (this.name == ((Country) obj).name && 
				this.capital == ((Country) obj).capital &&
				Arrays.equals(this.regions, ((Country) obj).regions));
	}
	
	public int hasshCode()
	{
		return Arrays.hashCode(this.regions) + this.name.hashCode();
	}
	
	public void addRegion(Region newregion)
	{
		Region[] newregions = new Region[this.regions.length + 1];
		int i = 0;
		for (; i < this.regions.length; i++)
			newregions[i] = this.regions[i];
		newregions[i] = newregion;
		this.regions = newregions;
	}
	
	public void printCapital()
	{
		System.out.println("Capital: " + this.capital);
	}
	
	public void printRigeonsAmount()
	{
		System.out.println("Amount of regions: " + this.regions.length);
	}
	
	public void printRegionCentres()
	{
		for (int i = 0; i < this.regions.length; i++)
		{
			System.out.println("Centre of " + this.regions[i].getName() +
								": " + this.regions[i].getCentre());
		}
	}
	
	public int getSquare()
	{
		int square = 0;
		
		for (int i = 0; i < this.regions.length; i++)
		{
			square += this.regions[i].getSquare();
		}
		
		return square;
	}
}