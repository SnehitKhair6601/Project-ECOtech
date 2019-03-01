import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Kyle Pinto
 * @Author: Kyle Ferreira
 *
 * @Date: June 8th, 2018
 * This class is a subclass of abstract class Devices.  It is used to
 * represent appliances, and stores the operational time of a particular
 * appliance.
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

class Appliances extends Devices
{
	private boolean is24Hour;
	private int operationTime;

	// CONSTRUCTORS //

	Appliances()
	{
		super();
		is24Hour = false;
		operationTime = 0;
	}

	Appliances(String name, double wattage, int quantity, boolean is24Hour, int operationTime)
	{
		super(name, wattage, quantity);
		this.is24Hour = is24Hour;
		this.operationTime = operationTime;
	}

	// GET / SET Methods //
	public boolean getIs24Hour()
	{
		return is24Hour;
	}

	public void setIs24Hour(boolean is24Hour)
	{
		this.is24Hour = is24Hour;
	}

	public int getOperationTime()
	{
		return operationTime;
	}

	public void setOperationTime(int operationTime)
	{
		this.operationTime = operationTime;
	}
	//Methods//
	/* *************************************************
	 * @Author: Kyle Ferreira
	 * @Date: June 8, 2018.
	 * This method calculates the monthly energy consumption 
	 * (in kWh) of all the appliances (of the same type).
	 * If an appliance is 24 hour, 24 is used in the calculation
	 * instead of the operationTime field.
	 * @param: none
	 * @return: monthly energy consumption (double)
	 * *************************************************/

	public double calcEnergy()
	{
		if (is24Hour == true)
		{
			return getWattage() * getQuantity() * 24 * 30 * 0.001;
		}
		else
		{
			return getWattage() * getQuantity() * getOperationTime() * 22 * 0.001;
		}
	}
} // end of class Appliances