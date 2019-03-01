import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Kyle Pinto
 * @Author: Kyle Ferreira
 *
 * @Date: June 8th, 2018
 * This class is an abstract class that defines the basic characteristics
 * of a power-consuming device, including its name and wattage. It also
 * stores the quantity of the device and defines the standard operation
 * time as a constant 9 hours (8:00 AM to 5:00 PM)
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
abstract class Devices
{
	private final int DURATION = 9;
	private String name;
	private double wattage;
	private int quantity;

	// CONSTRUCTORS //

	Devices()
	{
		name = null;
		wattage = 0.0;
		quantity = 0;
	}

	Devices(String name, double wattage, int quantity)
	{
		this.name = name;
		this.wattage = wattage;
		this.quantity = quantity;
	}

	// GET / SET Methods //

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getWattage()
	{
		return wattage;
	}

	public void setWattage(double wattage)
	{
		this.wattage = wattage;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public int getDURATION()
	{
		return DURATION;
	}

	/* @Author: Kyle Ferreira
	 * @Date: June 8, 2018.
	 * This method is an abstract method
	 * that should be implemented to calculate
	 * the monthly energy consumption (in kWh) of the devices
	 * @param: none
	 * @return: monthly energy consumption (double)
	 * */
	public abstract double calcEnergy();

} // end of abstract class Devices