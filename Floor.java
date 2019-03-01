import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Kyle Pinto
 * @Author: Kyle Ferreira
 * @Author:
 * @Author:
 * @Date: June 8th, 2018
 * This class serves to facilitate the creation of floor objects.
 * Floor objects represent floors in buildings. The Floor class contains
 * a room object ArrayList that holds all the rooms pertaining to a
 * a certain floor. The floor class holds a int variable that represents
 * what floor number it is(ex. the 14th floor is 14). The floor class
 * has methods that deal with adding and removing rooms from a floor
 * instance, the sorting of rooms in the ArrayList by power consumption
 * or by alphanumeric value, the searching of a room name, the calculation
 * of total floor energy consumption, the calculation of trees needed
 * to balance the consumption, and the formatted display of the floor data.
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class Floor
{
	// fields
	private ArrayList<Room> rooms;
	private int floorNumber;

	// get/set methods
	public ArrayList<Room> getRooms()
	{
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms)
	{
		this.rooms = rooms;
	}

	public int getFloorNumber()
	{
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber)
	{
		this.floorNumber = floorNumber;
	}

	// constructors
	Floor()
	{
		setRooms(new ArrayList<Room>());
		setFloorNumber(0);
	}

	Floor(int floorNumber)
	{
		setRooms(new ArrayList<Room>());
		setFloorNumber(floorNumber);
	}

	Floor(int floorNumber, ArrayList<Room> rooms)
	{
		setRooms(rooms);
		setFloorNumber(floorNumber);
	}

	// methods

	/* ***************************************************************************
	* @Author: Tomasz Cieslak
	* @Date: June 8th, 2018
	* Param: String
	* Return: void
	* Method Desc: This method will search for the room and remove it appropriately
	* ****************************************************************************/
	public void removeRoom(String roomToRemove)
	{
		for (int i = 0; i < rooms.size(); i++)
		{
			if (roomToRemove.equalsIgnoreCase(rooms.get(i).getName()))
			{
				rooms.remove(i); //room removed
				System.out.printf("Room: %s has been removed!", roomToRemove);
				return; //ends method
			}
		}

		System.out.printf("Room: %s cannot be located!", roomToRemove);
	} //end of removeRoom()

	/* *********************************************************
	* @Author: Kyle Ferreira
	 * @Date: June 8th. 2018
	 * This method calculates and returns the total
	 * monthly energy consumption of the floor.
	 * @param: N/A
	 * @return: double
	* *********************************************************/
	public double calcFloorEnergy()
	{
		double totalFloorEnergy = 0;
		for (int a = 0; a < rooms.size(); a++)
		{
			totalFloorEnergy = totalFloorEnergy + rooms.get(a).calcRoomEnergy();
		}
		return totalFloorEnergy;
	}//end of calcFloorEnergy
	/* *********************************************************
	* @Author: Snehit Khair
	 * @Date: June 8th. 2018
	 * This method returns a boolean value if the
	 * inputted room name matches a room in the floor
	 * @param: String
	 * @return: Boolean
	* *********************************************************/

	public boolean searchByRoomName(String roomNameSearch)
	{
		for (int i = 0; i < rooms.size(); i++)
		{
			if (roomNameSearch.equalsIgnoreCase(rooms.get(i).getName()))
			{
				rooms.get(i).displayRoomData();
				return true;
			}
		} // goes through list of rooms

		return false;

	}// end of search by room name method

	/* *************************************************
	 * @Author: Snehit Khair
	 * @Date: June 8, 2018.
	 * This method sorts all the rooms within the instance
	 * of the floor class (all rooms on ONE floor).  The
	 * rooms are sorted ascending or descending by ENERGY
	 * COMSUMPTION
	 * @param: order (int)   1 = ascending, 2 = descending
	 * @return: none (void)
	 * *************************************************/

	public void sortRoomsEnergy(int order)
	{
		if (order == 1)
		{
			for (int n = 0; n < rooms.size(); n++)
			{// outer loop for iterations
				for (int i = 0; i < rooms.size() - 1 - n; i++)
				{// inner loop for swapping items
					if (rooms.get(i + 1).calcRoomEnergy() < rooms.get(i).calcRoomEnergy())
					{
						Room holdObj = rooms.get(i);
						rooms.set(i, rooms.get(i + 1));
						rooms.set(i + 1, holdObj);
					} // end of swap
				} // end of inner loop
			} // end of outer loop
		} // end of ascending order sort
		else if (order == 2)
		{
			for (int n = 0; n < rooms.size(); n++)
			{// outer loop for iterations
				for (int i = 0; i < rooms.size() - 1 - n; i++)
				{// inner loop for swapping items
					if (rooms.get(i + 1).calcRoomEnergy() > rooms.get(i).calcRoomEnergy())
					{
						Room holdObj = rooms.get(i);
						rooms.set(i, rooms.get(i + 1));
						rooms.set(i + 1, holdObj);
					} // end of swap
				} // end of inner loop
			} // end of outer loop
		} // end of descending order sort

	}// end of room energy sort method

	/* *************************************************
	 * @Author: Snehit Khair
	 * @Date: June 8, 2018.
	 * This method sorts all the rooms within the instance
	 * of the floor class (all rooms on ONE floor).  The
	 * rooms are sorted ascending or descending by ROOM
	 * NUMBER
	 * @param: order (int)   1 = ascending, 2 = descending
	 * @return: none (void)
	 * *************************************************/

	public void sortRoomsNumber(int order)
	{
		if (order == 1)
		{
			for (int n = 0; n < rooms.size(); n++)
			{// outer loop for iterations
				for (int i = 0; i < rooms.size() - 1 - n; i++)
				{// inner loop for swapping items
					if (rooms.get(i + 1).getName().compareTo(rooms.get(i).getName()) < 0)
					{
						Room holdObj = rooms.get(i);
						rooms.set(i, rooms.get(i + 1));
						rooms.set(i + 1, holdObj);

					} // end of swap

				} // end of inner loop

			} // end of outer loop

		} // end of ascending order sort
		else if (order == 2)
		{
			for (int n = 0; n < rooms.size(); n++)
			{// outer loop for iterations
				for (int i = 0; i < rooms.size() - 1 - n; i++)
				{// inner loop for swapping items
					if (rooms.get(i + 1).getName().compareTo(rooms.get(i).getName()) > 0)
					{
						Room holdObj = rooms.get(i);
						rooms.set(i, rooms.get(i + 1));
						rooms.set(i + 1, holdObj);
					} // end of swap

				} // end of inner loop

			} // end of outer loop

		} // end of descending order sort

	}// end of sort room number method

	/* ***************************************************
	* @Author: Tomasz Cieslak
	* @Date: June 8th, 2018
	* This method  adds a room the room ArrayList.
	* @Param:Room Object
	* @Return: void
	******************************************************/
	public void addRoom(Room newRoom)
	{
		rooms.add(newRoom);
	}//end of addRoom()

	/* *************************************************
	 * @Author: Kyle Pinto
	 * @Date: June 8, 2018.
	 * This method displays the energy consumption breakdown
	 * of the floor and lists all the rooms and their associated
	 * energy data.
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public void displayFloorData()
	{
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("                                        FLOOR " + getFloorNumber());
		System.out.println("---------------------------------------------------------------------------------------------");

		if (getRooms().size() == 0)
		{
			System.out.println("NO ROOM DATA!");
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.printf("Total Monthly ENERGY CONSUMPTION of Floor %s:   N/A\n", getFloorNumber());
			System.out.printf("TREES Required Monthly to Sustain Floor %s:     N/A\n", getFloorNumber());
			System.out.printf("Total Monthly COST of Energy on Floor %s:       N/A\n", getFloorNumber());
		}
		else
		{
			System.out.println("************** All data values are calculated and reported as a MONTHLY value ***************");
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.printf("%-30s   %-18s   %-14s     %-19s\n", "Room Name", "Energy Consumption", "Trees Consumed", "Cost of Energy Used");
			System.out.println("---------------------------------------------------------------------------------------------");

			for (int a = 0; a < rooms.size(); a++)
			{
				System.out.printf("%-30s   %-14.2f kWH   %-14.2f     %-19s\n", rooms.get(a).getName(), rooms.get(a).calcRoomEnergy(), rooms.get(a).calcTreeKillRoom(), String.format("$%.2f", rooms.get(a).calcRoomEnergy() * 0.17));
			}

			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.printf("Total Monthly ENERGY CONSUMPTION of Floor %s:           %.2f kWh\n", getFloorNumber(), calcFloorEnergy());
			System.out.printf("TREES Required Monthly to Sustain Floor %s:             %.1f trees\n", getFloorNumber(), calcTreeKillFloor());
			System.out.printf("Total Monthly COST of Energy on Floor %s:               $%.2f\n", getFloorNumber(), calcFloorEnergy() * 0.17);

		}

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	/*
	 * @Author: Kyle Ferreira
	 * @Date: June 8th. 2018
	 * This method calculates and returns the total
	 * number of trees needed to counteract power consumption
	 * of this floor on a monthly basis.
	 * @param: N/A
	 * @return: double
	 */
	public double calcTreeKillFloor()
	{
		return calcFloorEnergy() * (0.18 / 12D);// trees needed per month to balance
	}

} // end of class Floor