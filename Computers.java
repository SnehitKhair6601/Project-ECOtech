import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Kyle Pinto
 * @Author: Kyle Ferreira
 *
 * @Date: June 8th, 2018
 * This class is a subclass of abstract class Devices.  It is used to
 * represent Computers, and records whether or not the computer have a
 * Separate monitor and PC unit or if they are "all in one", e.g., iMacs.
 * If not all in one, the monitor wattage and PC wattage are recorded separately.
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

class Computers extends Devices
{
	private boolean isAllInOne;
	private double pcWattage;
	private double monitorWattage;

	// CONSTRUCTORS //

	Computers()
	{
		super();
		isAllInOne = false;
		pcWattage = 0.0;
		monitorWattage = 0.0;
	}

	Computers(String name, double wattage, int quantity, boolean isAllInOne, double pcWattage, double monitorWattage)
	{
		super(name, wattage, quantity);
		this.isAllInOne = isAllInOne;
		this.pcWattage = pcWattage;
		this.monitorWattage = monitorWattage;

		if (!isAllInOne)
		{
			setWattage(getPCWattage() + getMonitorWattage());
		}
	}

	// GET / SET Methods //

	public boolean getIsAllInOne()
	{
		return isAllInOne;
	}

	public void setIsAllInOne(boolean isAllInOne)
	{
		this.isAllInOne = isAllInOne;
	}

	public double getPCWattage()
	{
		return pcWattage;
	}

	public void setPCWattage(double pcWattage)
	{
		this.pcWattage = pcWattage;
	}

	public double getMonitorWattage()
	{
		return monitorWattage;
	}

	public void setMonitorWattage(double monitorWattage)
	{
		this.monitorWattage = monitorWattage;
	}

	/* *************************************************
	 * @Author: Kyle Ferreira
	 * @Date: June 8, 2018.
	 * This method calculates the monthly energy consumption
	 * (in kWh) of all the computers (of the same type).
	 * @param: none
	 * @return: monthly energy consumption (double)
	 * *************************************************/

	public double calcEnergy()
	{
		return getWattage() * getQuantity() * getDURATION() * 30 * 0.001;// 24 or constant??
	}
} // end of class Computers