import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Kyle Pinto
 * @Author: Kyle Ferreira
 *
 * @Date: June 8th, 2018
 * This class serves to facilitate the creation of room objects.
 * Room objects represent individual rooms in a building. The Room class
 * contains a device object ArrayList that holds all the devices
 * located in the instance of that room. The room class holds a String
 * object that represents the room name. The room class
 * has methods that deal with the calculation for the total energy
 * consumption of that room, the calculation for how many trees are
 * need to balance out that consumption, and a display method That
 * outputs a formatted display to the user for the data in that room.
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class Room
{
	// fields
	private ArrayList<Devices> devices;
	private String name = null;

	// get/set methods
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ArrayList<Devices> getDevices()
	{
		return devices;
	}

	public void setDevices(ArrayList<Devices> devices)
	{
		this.devices = devices;
	}

	// constructors
	Room()
	{
		setName(null);
		setDevices(null);
	}

	Room(String name)
	{
		setName(name);
		setDevices(new ArrayList<Devices>());
	}

	Room(String name, ArrayList<Devices> devices)
	{
		setName(name);
		setDevices(devices);
	}

	// methods
	/*
	 * @Author: Kyle Ferreira
	  * @Date: June 8th. 2018
	  * This method calculates and returns the total
	  * energy consumption of the devices in the room.
	  * @param: N/A
	  * @return: double
	 */
	public double calcRoomEnergy()
	{
		double energyTotal = 0;
		for (int a = 0; a < devices.size(); a++)
		{
			energyTotal = energyTotal + devices.get(a).calcEnergy();
		}
		return energyTotal;
	}

	/*
	* @Author: Kyle Pinto
	 * @Date: June 8th. 2018
	 * This method displays the room data on its
	 * power consumption by device and as a total.
	 * @param: N/A
	 * @return: void
	*/
	public void displayRoomData()
	{
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("                                        ROOM " + getName());
		System.out.println("---------------------------------------------------------------------------------------------");

		if (devices.size() == 0)
		{
			System.out.println("NO DEVICE DATA!");
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.printf("Total Monthly ENERGY CONSUMPTION of Room %s:   N/A\n", getName());
			System.out.printf("TREES Required Monthly to Sustain Room %s:     N/A\n", getName());
			System.out.printf("Total Monthly COST of Energy for Room %s:      N/A\n", getName());
		}
		else
		{
			System.out.printf("%-36s     %-10s     %-14s     %-17s\n", "Device Name", "Quantity", "Device Wattage", "Summative Wattage");
			System.out.println("---------------------------------------------------------------------------------------------");

			for (int a = 0; a < devices.size(); a++)
			{
				System.out.printf("%-36s     %-10d     %-12.2f W     %-15.2f W\n", devices.get(a).getName(), devices.get(a).getQuantity(), devices.get(a).getWattage(), devices.get(a).getWattage() * devices.get(a).getQuantity());
			}

			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.printf("Total Monthly ENERGY CONSUMPTION of Room %s:   %.2f kWh\n", getName(), calcRoomEnergy());
			System.out.printf("TREES Required Monthly to Sustain Room %s:     %.1f trees\n", getName(), calcTreeKillRoom());
			System.out.printf("Total Monthly COST of Energy for Room %s:      $%.2f\n", getName(), calcRoomEnergy() * 0.17);
		}

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	/*
	* @Author: Kyle Ferreira
	 * @Date: June 8th. 2018
	 * This method calculates and returns the total
	 * number of trees needed to counteract the
	 * power consumption of this room (on a monthly basis)
	 * @param: N/A
	 * @return: double
	*/
	public double calcTreeKillRoom()
	{
		return calcRoomEnergy() * (0.18 / 12D);// trees needed per month to balance
	}
} // end of class Room