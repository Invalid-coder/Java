package T05_03;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElectricalDevice[] devices = new ElectricalDevice[4];
		devices[0] = new Fridge(1000, 2000, "Samsung");
		devices[1] = new Fridge(1200, 1500, "LG");
		devices[2] = new Teapot(100, 200, "Samsung");
		devices[3] = new Fridge(150, 250, "LG");
		devices[0].PlugIn(100);
		devices[1].PlugIn(200);
		devices[2].PlugIn(150);
		devices[3].PlugIn(50);
		Flat flat = new Flat(devices);
		System.out.println(flat);
		System.out.println(flat.power());
		
		int i = flat.find(100, 200);
		
		if (i != -1)
			System.out.println(devices[i]);
		
		flat.sort();
		System.out.println(flat);
		
		
	}

}
