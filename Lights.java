import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Kyle Pinto
 * @Author: Kyle Ferreira
 *
 * @Date: June 8th, 2018
 * This class is a subclass of abstract class Devices.  It is used to
 * represent lights, and stores how many of each type of light are
 * emergency lights.  These lights differ from normal lights, as they
 * do not turn off.
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

class Lights extends Devices
{
	private int emergencyLights;

	// CONSTRUCTORS //

	Lights()
	{
		super();
		emergencyLights = 0;
	}

	Lights(String name, int quantity, int emergencyLights, double wattage)
	{
		super(name, wattage, quantity);
		this.emergencyLights = emergencyLights;
	}

	// GET / SET Methods //

	public int getEmergencyLights()
	{
		return emergencyLights;
	}

	public void setEmergencyLights(int emergencyLights)
	{
		this.emergencyLights = emergencyLights;
	}
	//Methods
	/* *************************************************
	 * @Author: Kyle Ferreira
	 * @Date: June 8, 2018.
	 * This method calculates the monthly energy consumption
	 * (in kWh) of all the lights (of the same type).
	 * @param: none
	 * @return: monthly energy consumption (double)
	 * *************************************************/

	public double calcEnergy()
	{
		return (getEmergencyLights() * getWattage() * 24) * 30 * 0.001 + (getQuantity() * getWattage() * getDURATION()) * 22 * 0.001;
	}
} // end of class Lights