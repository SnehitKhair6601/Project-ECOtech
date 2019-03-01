import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/* =================================================
 * @Author: Kyle Ferreira
 * @Author: Kyle Pinto
 * @Author: Tomasz Cieslak
 * @Author: Snehit Khair
 *
 * @Date: June 8, 2018.
 *
 * This is the main class that composes the database.
 * It contains various functions for sorting and
 * searching, adding and removing, importing and exporting,
 * and displaying the data inside the database.
 * =================================================*/

class School
{
	public static ArrayList<Floor> floors = new ArrayList<Floor>();
	public static String schoolName = "St. Joseph Secondary School";
	public static Scanner userInput = new Scanner(System.in);

	/* ************************************************
	 * @Author: Kyle Pinto
	 * @Date: June 8, 2018.
	 * This method runs the main menu and displays the disclaimer.
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void runDatabase()
	{
		System.out.println();
		System.out.println("----------------------- DISCLAIMER ------------------------");
		System.out.println("T.S.K.K inc. is a non profit organization run by some random");
		System.out.println("programmers who are trying to make a living.  Out of the");
		System.out.println("goodness of their hearts (and also for marks) they have taken");
		System.out.println("the initiative to write a program to determine the power");
		System.out.println("consumption of any building.  Project ECOtech aims to raise");
		System.out.println("awareness of the ridiculous electrical bill that is racked");
		System.out.println("up by modern institutional facilities.  This demo of ECOtech");
		System.out.println("features data collected at St. Joseph Secondary School.  While");
		System.out.println("this data was collected most intricately and meticulously by");
		System.out.println("a bunch of Grade 12 students, its validity and accuracy may");
		System.out.println("be questionable due to their rapidly deteriorating afflictions");
		System.out.println("of senioritis.  As such, T.S.K.K urges that this data be");
		System.out.println("interpreted solely as a rough estimate of the school's power");
		System.out.println("consumption.  Additionally, users should keep in mind that this");
		System.out.println("software is currently in pre-alpha testing and as such the UI");
		System.out.println("looks like it was created in Microsoft Word.  T.S.K.K apologizes");
		System.out.println("in advance but it was the best we could do as our computer");
		System.out.println("storage is limited to a few floppy disks since we're too cheap");
		System.out.println("to buy actual hard drives.  Please note that T.S.K.K is");
		System.out.println("not responsible for any PTSD that may result among users as a");
		System.out.println("result of using our primitive software.  USE AT YOUR OWN RISK.");
		System.out.println("-----------------------------------------------------------");

		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~ Project ECOtech ~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("---------------- presented by T.S.K.K inc. ----------------");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		menu();
	}

	/* ************************************************
	 * @Author: Kyle Pinto
	 * @Date: June 8, 2018.
	 * This method is the main menu.  It allows the user
	 * to select an option from the menu and then proceeds
	 * to call the corresponding function to complete that
	 * action.  The menu will loop until the user chooses
	 * to exit the program.
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void menu()
	{
		int input = 0;
		boolean exit = false;

		do
		{
			System.out.println();
			System.out.println("=======================================================");
			System.out.println("[ -------------------- MAIN MENU -------------------- ]");
			System.out.println("=======================================================");
			System.out.println("| 1.  Load information from file..................... |");
			System.out.println("| 2.  Save information to file....................... |");
			System.out.println("| 3.  Display schoolwide power data.................. |");
			System.out.println("| 4.  Search floor by number......................... |");
			System.out.println("| 5.  Search room by name............................ |");
			System.out.println("| 6.  Add a floor.................................... |");
			System.out.println("| 7.  Add a room to a floor.......................... |");
			System.out.println("| 8.  Add devices to a room.......................... |");
			System.out.println("| 9.  Remove devices from a room..................... |");
			System.out.println("| 10. Remove a room from a floor..................... |");
			System.out.println("| 11. Remove a floor................................. |");
			System.out.println("| 12. Clear all devices from all rooms............... |");
			System.out.println("| 13. Sort floors by power consumption............... |");
			System.out.println("| 14. Sort floors by number.......................... |");
			System.out.println("| 15. Sort all rooms by power consumption............ |");
			System.out.println("| 16. Sort all rooms by number / name................ |");
			System.out.println("| 17. Set name of school building.................... |");
			System.out.println("| 18. Exit program................................... |");
			System.out.println("=======================================================");

			System.out.println("\nPlease enter the INTEGER number corresponding to the menu choice you would like to select:");

			while (true)
			{
				try
				{
					input = Integer.parseInt(userInput.nextLine());

					if (input > 0 && input <= 18)
					{
						break;
					}
					else
					{
						System.out.println("INVALID INPUT - That is not a menu option");
					}
				}
				catch (NumberFormatException invalidInput)
				{
					System.out.println("INVALID INPUT - That is not a menu option");
				}
			}

			if (input == 1)
			{
				System.out.println("PREPARING TO LOAD FILE INFORMATION.....................");
				loadFile();
			}
			else if (input == 2)
			{
				System.out.println("PREPARING TO SAVE INFORMATION TO FILE.....................");
				saveFile();
			}
			else if (input == 3)
			{
				System.out.println("DISLAYING SCHOOLWIDE POWER DATA.....................");
				displaySchoolData();
			}
			else if (input == 4)
			{
				System.out.println("PREPARING TO SEARCH FLOORS....................");
				searchFloor();
			}
			else if (input == 5)
			{
				System.out.println("PREPARING TO SEARCH ROOMS....................");
				searchRoom();
			}
			else if (input == 6)
			{
				System.out.println("PREPARING TO ADD A FLOOR....................");
				addFloor();
			}
			else if (input == 7)
			{
				System.out.println("PREPARING TO ADD A ROOM TO A FLOOR....................");
				addRoom();
			}
			else if (input == 8)
			{
				System.out.println("PREPARING TO ADD DEVICES TO A ROOM....................");
				addDevices();
			}
			else if (input == 9)
			{
				System.out.println("PREPARING TO REMOVE DEVICES FROM A ROOM....................");
				removeDevices();
			}
			else if (input == 10)
			{
				System.out.println("PREPARING TO REMOVE A ROOM FROM A FLOOR....................");
				removeRoom();
			}
			else if (input == 11)
			{
				System.out.println("PREPARING TO REMOVE A FLOOR....................");
				removeFloor();
			}
			else if (input == 12)
			{
				System.out.println("CLEARING ALL DEVICES FROM ALL ROOMS....................");
				clearDevices();
			}
			else if (input == 13)
			{
				System.out.println("SORTING FLOORS BY POWER CONSUMPTION....................");
				sortFloors(true);
			}
			else if (input == 14)
			{
				System.out.println("SORTING FLOORS BY FLOOR NUMBER....................");
				sortFloors(false);
			}
			else if (input == 15)
			{
				System.out.println("SORTING ROOMS BY POWER CONSUMPTION....................");
				sortRooms(true);
			}
			else if (input == 16)
			{
				System.out.println("SORTING ROOMS ALPHANUMERICALLY....................");
				sortRooms(false);
			}
			else if (input == 17)
			{
				System.out.println("PREPARING TO CHANGE NAME OF SCHOOL BUILDING IN DATABASE....................");
				setSchoolName();
			}
			else if (input == 18)
			{
				System.out.println("TERMINATING DATABASE PROGRAM....................");
				System.out.println("Thank you for using the Project ECOtech Database!");
				System.out.println("Goodbye!");
				exit = true;
			}

		}
		while (!exit);

		userInput.close();
	}

	/* ************************************************
	 * @Author: Kyle Pinto
	 * @Date: June 8, 2018.
	 * This method allows the user to set the name of the
	 * school / building.
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void setSchoolName()
	{
		do
		{
			schoolName = userInput.nextLine();

			if (schoolName.length() == 0)
			{
				System.out.println("INVALID INPUT - school name cannot be blank!");
			}
		}
		while (schoolName.length() == 0);

		System.out.printf("Setting name of school to \"%s\"\n", schoolName);
	}

	/* ************************************************
	 * @Author: Kyle Ferreira
	 * @Date: June 8, 2018.
	 * This method imports data from a text file into
	 * the database.
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void loadFile()
	{
		floors.clear();
		System.out.println("Please enter a file name. The .txt extension will be added automatically");
		String newFileName = null;
		Scanner fileInput = null;

		do
		{
			newFileName = userInput.nextLine();

			if (newFileName.length() == 0)
			{
				System.out.println("INVALID INPUT - file name cannot be blank");
			}
		}
		while (newFileName.length() == 0);

		newFileName = newFileName + ".txt";

		File prgFile = new File(newFileName);

		try
		{
			fileInput = new Scanner(prgFile);
			System.out.printf("Loading data from file \"%s\".......\n", newFileName);
			floors.clear();

			schoolName = fileInput.nextLine();
			int numberOfFloors = Integer.parseInt(fileInput.nextLine());

			for (int a = 0; a < numberOfFloors; a++)
			{
				floors.add(new Floor(Integer.parseInt(fileInput.nextLine())));
				int numberOfRooms = Integer.parseInt(fileInput.nextLine());

				for (int b = 0; b < numberOfRooms; b++)
				{
					floors.get(a).addRoom(new Room(fileInput.nextLine()));
					int numberOfDevices = Integer.parseInt(fileInput.nextLine());

					for (int c = 0; c < numberOfDevices; c++)
					{
						String deviceType = fileInput.nextLine();
						if (deviceType.equals("Light"))
						{
							floors.get(a).getRooms().get(b).getDevices().add(new Lights(fileInput.nextLine(), Integer.parseInt(fileInput.nextLine()), Integer.parseInt(fileInput.nextLine()), Double.parseDouble(fileInput.nextLine())));
						}
						else if (deviceType.equals("Computer"))
						{
							floors.get(a).getRooms().get(b).getDevices().add(new Computers(fileInput.nextLine(), Double.parseDouble(fileInput.nextLine()), Integer.parseInt(fileInput.nextLine()), Boolean.parseBoolean(fileInput.nextLine()), Double.parseDouble(fileInput.nextLine()), Double.parseDouble(fileInput.nextLine())));
						}
						else if (deviceType.equals("Appliance"))
						{
							floors.get(a).getRooms().get(b).getDevices().add(new Appliances(fileInput.nextLine(), Double.parseDouble(fileInput.nextLine()), Integer.parseInt(fileInput.nextLine()), Boolean.parseBoolean(fileInput.nextLine()), Integer.parseInt(fileInput.nextLine())));
						}
					}
				}
			}
		}
		catch (FileNotFoundException fileNotFound)
		{
			System.out.printf("The file %s could not be found!", newFileName);
		}
	}

	/* ************************************************
	 * @Author: Kyle Ferreira
	 * @Date: June 8, 2018.
	 * This method saves the database information into a
	 * text file.
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void saveFile()
	{
		System.out.println("Please input the name that you would like your .txt file to be called");
		System.out.println("***NOTE: .txt is added at the end of your file name; adding .txt yourself will result in a file ending in *.txt.txt");

		boolean special = true;
		String fileName = null;

		while (special == true)
		{
			do
			{
				fileName = userInput.nextLine();

				if (fileName.length() == 0)
				{
					System.out.println("INVALID INPUT - file name cannot be empty");
				}
			}
			while (fileName.length() == 0);

			fileName = fileName + ".txt";

			int count = 0;

			for (int a = 0; a < fileName.length(); a++)
			{
				if (fileName.charAt(a) > 64 && fileName.charAt(a) < 91)
				{
					count++;
				}
				else if (fileName.charAt(a) > 96 && fileName.charAt(a) < 123)
				{
					count++;
				}
				else if (fileName.charAt(a) == 45 || fileName.charAt(a) == 46 || fileName.charAt(a) == 95)
				{
					count++;
				}
			}

			if (count == fileName.length())
			{
				special = false;
			}
			else
			{
				System.out.println("Please input a legal file name; no special characters are allowed.");
			}
		}

		PrintWriter printOut = null;

		try
		{
			printOut = new PrintWriter(fileName);
			System.out.println("Creating new data file " + fileName);

			Devices device = null;

			printOut.println(schoolName);
			printOut.println(floors.size());

			for (int a = 0; a < floors.size(); a++)
			{
				printOut.println(floors.get(a).getFloorNumber());
				printOut.println(floors.get(a).getRooms().size());

				for (int b = 0; b < floors.get(a).getRooms().size(); b++)
				{
					printOut.println(floors.get(a).getRooms().get(b).getName());
					printOut.println(floors.get(a).getRooms().get(b).getDevices().size());

					for (int c = 0; c < floors.get(a).getRooms().get(b).getDevices().size(); c++)
					{
						device = floors.get(a).getRooms().get(b).getDevices().get(c);

						if (device instanceof Lights)
						{
							printOut.println("Light");
							printOut.println(((Lights)device).getName());
							printOut.println(((Lights)device).getQuantity());
							printOut.println(((Lights)device).getEmergencyLights());
							printOut.println(((Lights)device).getWattage());
						}
						else if (device instanceof Computers)
						{
							printOut.println("Computer");
							printOut.println(((Computers)device).getName());
							printOut.println(((Computers)device).getWattage());
							printOut.println(((Computers)device).getQuantity());
							printOut.println(((Computers)device).getIsAllInOne());
							printOut.println(((Computers)device).getPCWattage());
							printOut.println(((Computers)device).getMonitorWattage());
						}
						else if (device instanceof Appliances)
						{
							printOut.println("Appliance");
							printOut.println(((Appliances)device).getName());
							printOut.println(((Appliances)device).getWattage());
							printOut.println(((Appliances)device).getQuantity());
							printOut.println(((Appliances)device).getIs24Hour());
							printOut.println(((Appliances)device).getOperationTime());
						}
					}
				}
			}
		}
		catch (IOException ioException)
		{
			System.out.println("The file could not be created");
		}

		printOut.close();
	}

	/* ************************************************
	* @Author: Tomasz Cieslak
	* Date: June 8, 2018.
	* Param: N/A
	* Return: void
	* Method Desc: This method forces the user to input the floor of the room and then the name.
	*************************************************/

	public static void addRoom()
	{
		if (floors.size() != 0) //this code will not run if there are no floors in the school
		{
			boolean valid = false;
			int floorNumber = 0;
			int floorIndex = 0;

			System.out.println("Please enter the number of the floor where you wish to add this room:");

			do
			{
				valid = false;

				try
				{
					floorNumber = Integer.parseInt(userInput.nextLine());

					if (floorNumber < 1) //There cannot be a room on floor zero
					{
						System.out.println("INVALID INPUT - Floor cannot be zero!");
					}
					else
					{
						for (int k = 0; k < floors.size(); k++)
						{ //searching if the floor exists
							if (floorNumber == floors.get(k).getFloorNumber())
							{ //breaks out the loop if the floor exits
								floorIndex = k;
								valid = true;
								break;
							}
						}

						if (!valid)
						{ //printout for the non existant floor situation
							System.out.println("That floor does not exist yet.");
							return;
						}

					}

				}
				catch (NumberFormatException notAnInteger)
				{ //situation if the input is not an int
					System.out.println("INVALID INPUT - floor number must be an integer!");
				}
			}
			while (!valid);

			String newRoom;

			do
			{ // forcing String with only letters / numbers
				System.out.println("Please enter a room name for the new room.");

				newRoom = userInput.nextLine();

				if (newRoom.length() == 0)
				{
					System.out.println("INVALID INPUT - Room name cannot be blank!");
				}
				else if (!newRoom.matches("[a-zA-Z0-9\\s\\(\\)\\-]+"))
				{
					System.out.println("That Room number is invalid - only numbers, letters, spaces, round brackets, and dashes are allowed!");
				}

			}
			while (newRoom.matches("[a-zA-Z0-9\\s\\(\\)\\-]+") == false); // end of forcing loop

			newRoom = newRoom.toUpperCase();
			floors.get(floorIndex).addRoom(new Room(newRoom)); //adding the room to the correct floor
			System.out.printf("Room \"%s\" has been added to Floor %d!\n", newRoom, floorNumber);
		}
		else
		{
			System.out.println("You are not able to add a room when there are no floors in the school!");
		}

	}//end of addRoom()

	/* ************************************************
	 * @Author: Tomasz Cieslak
	 * @Date: June 8, 2018.
	 * This method adds a floor to the database.  The floor
	 * can only have an integer number as a name
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void addFloor()
	{
		boolean exists = false;
		int newFloorNumber = 0;

		System.out.println("Please enter an integer floor number for the new floor:");

		do
		{
			try
			{
				newFloorNumber = Integer.parseInt(userInput.nextLine());

				if (newFloorNumber < 1)
				{
					System.out.println("INVALID INPUT - floor number must be greater than zero");
					exists = true;
				}
				else
				{
					exists = false;

					for (int i = 0; i < floors.size(); i++)
					{
						if (newFloorNumber == floors.get(i).getFloorNumber())
						{
							System.out.println("That floor already exists in the database!");
							exists = true;
							break;
						}
					}
				}
			}
			catch (NumberFormatException invalidInput)
			{
				System.out.println("INVALID INPUT - only integers are permitted");
				exists = true;
			}
		}
		while (exists);

		System.out.println("Adding Floor " + newFloorNumber + " to database.......");
		floors.add(new Floor(newFloorNumber));
	}

	/* ************************************************
	 * @Author: Kyle Pinto
	 * @Date: June 8, 2018.
	 * This method adds devices to a room if that room
	 * exists in the database.
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void addDevices()
	{
		int floorNumber = 0;
		int floorIndex = 0;
		String roomName = null;
		int roomIndex = 0;
		int newDeviceType = 0;
		boolean valid = false;

		System.out.println("Please enter the FLOOR number of the room that you wish to add devices to:");

		do
		{
			valid = false;

			try
			{
				floorNumber = Integer.parseInt(userInput.nextLine());

				if (floorNumber < 1)
				{
					System.out.println("INVALID INPUT - floor number must be greater than 0!");
				}
				else
				{
					for (int k = 0; k < floors.size(); k++)
					{
						if (floorNumber == floors.get(k).getFloorNumber())
						{
							floorIndex = k;
							valid = true;
							break;
						}
					}

					if (!valid)
					{
						System.out.printf("Floor %d does not exist!\n", floorNumber);
						return;
					}

				}

			}
			catch (NumberFormatException notAnInteger)
			{
				System.out.println("INVALID INPUT - floor number must be an integer!");
			}
		}
		while (!valid);

		System.out.printf("Please enter the name of the room on Floor %d that you wish to add devices to:\n", floorNumber);

		do
		{
			valid = false;
			roomName = userInput.nextLine();

			if (roomName.length() == 0)
			{
				System.out.println("INVALID INPUT - room name cannot be blank!");
			}
			else
			{
				roomName = roomName.toUpperCase();

				for (int i = 0; i < floors.get(floorIndex).getRooms().size(); i++)
				{
					if (roomName.equalsIgnoreCase(floors.get(floorIndex).getRooms().get(i).getName()))
					{
						roomIndex = i;
						valid = true;
						break;
					}
				}

				if (!valid)
				{
					System.out.printf("Room %s does not exist on Floor %d!\n", roomName, floorNumber);
					return;
				}

			}
		}
		while (!valid);

		System.out.printf("Please select what type of device you are adding to Room %s on Floor %d:\n", roomName, floorNumber);
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println("1. Light         Required information: name, quantity, wattage, number of emergency / 24h lights (if applicable)");
		System.out.println("2. Computer      Required information: name, quantity, wattage of PC and/or MONITOR");
		System.out.println("3. Appliance     Required information: name, quantity, wattage, operation time");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println("4. ABORT and return to main menu");
		System.out.println("----------------------------------------------------------------------------------------------------------------");

		do
		{
			valid = false;

			try
			{
				newDeviceType = Integer.parseInt(userInput.nextLine());

				if (newDeviceType != 1 && newDeviceType != 2 && newDeviceType != 3 && newDeviceType != 4)
				{
					System.out.println("That is not an option!");
				}
				else
				{
					valid = true;
				}

			}
			catch (NumberFormatException notAnInteger)
			{
				System.out.println("INVALID INPUT - floor number must be an integer!");
			}
		}
		while (!valid);

		String name = null;
		double wattage = 0.0;
		int quantity = 0;

		if (newDeviceType == 4)
		{
			System.out.println("ABORTING ADD DEVICE OPERATION - RETURNING TO MAIN MENU");
		}
		else if (newDeviceType == 1)
		{
			System.out.println("Add LIGHTS:");

			System.out.println("Please enter the NAME of the lights:");

			while (true)
			{
				name = userInput.nextLine();

				if (name.length() == 0)
				{
					System.out.println("Name cannot be blank!");
				}
				else
				{
					break;
				}
			}

			System.out.println("Please enter the wattage of ONE SINGLE light:");

			while (true)
			{
				try
				{
					wattage = Double.parseDouble(userInput.nextLine());
					break;
				}
				catch (NumberFormatException notADouble)
				{
					System.out.println("INVALID INPUT - must be a decimal number!");
				}
			}

			System.out.println("Please enter the quantity these lights:");

			while (true)
			{
				try
				{
					quantity = Integer.parseInt(userInput.nextLine());
					break;
				}
				catch (NumberFormatException notAnInteger)
				{
					System.out.println("INVALID INPUT - must be an integer number!");
				}
			}

			System.out.println("How many of these lights are emergency lights (24 hour lights)?");
			int emergencyLights = 0;

			while (true)
			{
				try
				{
					emergencyLights = Integer.parseInt(userInput.nextLine());
					break;
				}
				catch (NumberFormatException notAnInteger)
				{
					System.out.println("INVALID INPUT - must be an integer number!");
				}
			}

			floors.get(floorIndex).getRooms().get(roomIndex).getDevices().add(new Lights(name, quantity, emergencyLights, wattage));
			System.out.printf("The lights have been added to Room %s on Floor %d!\n", roomName, floorNumber);
		}
		else if (newDeviceType == 2)
		{
			System.out.println("Add COMPUTERS:");

			System.out.println("Please enter the NAME of the computers:");

			while (true)
			{
				name = userInput.nextLine();

				if (name.length() == 0)
				{
					System.out.println("Name cannot be blank!");
				}
				else
				{
					break;
				}
			}

			System.out.println("Do these computers have SEPARATE monitor and PC units? (Y/N)");
			boolean isAllInOne = false;
			String response = null;

			while (true)
			{
				response = userInput.nextLine();

				if (response.length() == 1)
				{
					if (response.equalsIgnoreCase("Y"))
					{
						isAllInOne = false;
						break;
					}
					else if (response.equalsIgnoreCase("N"))
					{
						isAllInOne = true;
						break;
					}
					else
					{
						System.out.println("INVALID INPUT - Please select either Y (yes) or N (no)");
					}
				}
				else
				{
					System.out.println("INVALID INPUT - Please select either Y (yes) or N (no)");
				}
			}

			double monitorWattage = 0.0;
			double pcWattage = 0.0;

			if (!isAllInOne)
			{
				System.out.println("Please enter the wattage of ONE of the computers' monitor units:");

				while (true)
				{
					try
					{
						monitorWattage = Double.parseDouble(userInput.nextLine());
						break;
					}
					catch (NumberFormatException notADouble)
					{
						System.out.println("INVALID INPUT - must be a decimal number!");
					}
				}

				System.out.println("Please enter the wattage of ONE of the computers' PC tower units:");

				while (true)
				{
					try
					{
						pcWattage = Double.parseDouble(userInput.nextLine());
						break;
					}
					catch (NumberFormatException notADouble)
					{
						System.out.println("INVALID INPUT - must be a decimal number!");
					}
				}

				wattage = pcWattage + monitorWattage;
			}
			else
			{
				System.out.println("Please enter the wattage of ONE of the computers:");

				while (true)
				{
					try
					{
						wattage = Double.parseDouble(userInput.nextLine());
						break;
					}
					catch (NumberFormatException notADouble)
					{
						System.out.println("INVALID INPUT - must be a decimal number!");
					}
				}
			}

			System.out.println("Please enter the quantity these computers:");

			while (true)
			{
				try
				{
					quantity = Integer.parseInt(userInput.nextLine());
					break;
				}
				catch (NumberFormatException notAnInteger)
				{
					System.out.println("INVALID INPUT - must be an integer number!");
				}
			}

			floors.get(floorIndex).getRooms().get(roomIndex).getDevices().add(new Computers(name, wattage, quantity, isAllInOne, pcWattage, monitorWattage));
			System.out.printf("The computers have been added to Room %s on Floor %d!\n", roomName, floorNumber);
		}
		else if (newDeviceType == 3)
		{

			System.out.println("Add APPLIANCES:");

			System.out.println("Please enter the NAME of the appliance(s):");

			while (true)
			{
				name = userInput.nextLine();

				if (name.length() == 0)
				{
					System.out.println("Name cannot be blank!");
				}
				else
				{
					break;
				}
			}

			System.out.println("Is this appliance connected to power 24 hours a day? (Y/N)");
			boolean is24Hour = false;
			String response = null;

			while (true)
			{
				response = userInput.nextLine();

				if (response.length() == 1)
				{
					if (response.equalsIgnoreCase("Y"))
					{
						is24Hour = true;
						break;
					}
					else if (response.equalsIgnoreCase("N"))
					{
						is24Hour = false;
						break;
					}
					else
					{
						System.out.println("INVALID INPUT - Please select either Y (yes) or N (no)");
					}
				}
				else
				{
					System.out.println("INVALID INPUT - Please select either Y (yes) or N (no)");
				}
			}

			int operationTime = 0;

			if (is24Hour)
			{
				operationTime = 24;
			}
			else
			{
				System.out.println("Please enter the amount of time (hours / day) that this device is connected to power / being used:");

				while (true)
				{
					try
					{
						operationTime = Integer.parseInt(userInput.nextLine());

						if (operationTime > 0 && operationTime < 24)
						{
							break;
						}
						else
						{
							System.out.println("The operation time must be GREATER than 0 hours and LESS than 24 hours!");
						}
					}
					catch (NumberFormatException notAnInteger)
					{
						System.out.println("INVALID INPUT - must be a integer number!");
					}
				}
			}

			System.out.println("Please enter the quantity these appliances:");

			while (true)
			{
				try
				{
					quantity = Integer.parseInt(userInput.nextLine());
					break;
				}
				catch (NumberFormatException notAnInteger)
				{
					System.out.println("INVALID INPUT - must be an integer number!");
				}
			}

			System.out.println("Please enter the wattage of ONE of the appliances:");

			while (true)
			{
				try
				{
					wattage = Double.parseDouble(userInput.nextLine());
					break;
				}
				catch (NumberFormatException notADouble)
				{
					System.out.println("INVALID INPUT - must be a decimal number!");
				}
			}

			floors.get(floorIndex).getRooms().get(roomIndex).getDevices().add(new Appliances(name, wattage, quantity, is24Hour, operationTime));
			System.out.printf("The appliances have been added to Room %s on Floor %d!\n", roomName, floorNumber);
		}
	}

	/* *************************************************
	 * @Author: Kyle Pinto
	 * @Date: June 8, 2018.
	 * This method removes items from a room if that room
	 * exists in the database.
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void removeDevices()
	{
		int floorNumber = 0;
		int floorIndex = 0;
		String roomName = null;
		int roomIndex = 0;
		boolean valid = false;

		System.out.println("Please enter the FLOOR number of the room that you wish to remove devices from:");

		do
		{
			valid = false;

			try
			{
				floorNumber = Integer.parseInt(userInput.nextLine());

				if (floorNumber < 1)
				{
					System.out.println("INVALID INPUT - floor number must be greater than 0!");
				}
				else
				{
					for (int k = 0; k < floors.size(); k++)
					{
						if (floorNumber == floors.get(k).getFloorNumber())
						{
							floorIndex = k;
							valid = true;
							break;
						}
					}

					if (!valid)
					{
						System.out.printf("Floor %d does not exist!\n", floorNumber);
						return;
					}

				}

			}
			catch (NumberFormatException notAnInteger)
			{
				System.out.println("INVALID INPUT - floor number must be an integer!");
			}
		}
		while (!valid);

		System.out.printf("Please enter the name of the room on Floor %d that you wish to remove devices from:\n", floorNumber);

		do
		{
			valid = false;
			roomName = userInput.nextLine();

			if (roomName.length() == 0)
			{
				System.out.println("INVALID INPUT - room name cannot be blank!");
			}
			else
			{
				roomName = roomName.toUpperCase();

				for (int i = 0; i < floors.get(floorIndex).getRooms().size(); i++)
				{
					if (roomName.equalsIgnoreCase(floors.get(floorIndex).getRooms().get(i).getName()))
					{
						roomIndex = i;
						valid = true;
						break;
					}
				}

				if (!valid)
				{
					System.out.printf("Room %s does not exist on Floor %d!\n", roomName, floorNumber);
					return;
				}

			}
		}
		while (!valid);

		System.out.printf("These are the devices currently listed in Room %s on Floor %d:\n", roomName, floorNumber);
		System.out.println("Please select the number corresponding to the type of device you would like to remove:");
		System.out.println("---------------------------------------------------------------------------------------");

		if (floors.get(floorIndex).getRooms().get(roomIndex).getDevices().size() == 0)
		{
			System.out.println("NO DEVICE DATA!");
		}
		else
		{
			for (int a = 0; a < floors.get(floorIndex).getRooms().get(roomIndex).getDevices().size(); a++)
			{
				System.out.printf("%d. \"%s\"\n", (a + 1), floors.get(floorIndex).getRooms().get(roomIndex).getDevices().get(a).getName());
			}

		}

		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("0. ABORT and return to main menu");
		System.out.println("---------------------------------------------------------------------------------------");

		int response = 0;

		while (true)
		{
			try
			{
				response = Integer.parseInt(userInput.nextLine());

				if (response < 0 || response > (floors.get(floorIndex).getRooms().get(roomIndex).getDevices().size()))
				{
					System.out.println("That is not an option!");
				}
				else
				{
					break;
				}

			}
			catch (NumberFormatException notAnInteger)
			{
				System.out.println("INVALID INPUT - floor number must be an integer!");
			}
		}

		if (response == 0)
		{
			System.out.println("ABORTING REMOVE DEVICE OPERATION - RETURNING TO MAIN MENU");
			return;
		}
		else
		{
			System.out.printf("Removing \"%s\" devices from database (quantity removed: %d)\n", floors.get(floorIndex).getRooms().get(roomIndex).getDevices().get(response - 1).getName(), floors.get(floorIndex).getRooms().get(roomIndex).getDevices().get(response - 1).getQuantity());

			floors.get(floorIndex).getRooms().get(roomIndex).getDevices().remove(response - 1);
		}
	}

	/* ************************************************
	* @Author: Tomasz Cieslak
	* @Date: June 8, 2018.
	* Param: N/A
	* Return: void
	* Method Desc: This method asks the user for the room they wish to delete, then the method will search and remove the appropiate room
	* if not, the method will exit out.
	*************************************************/
	public static void removeRoom()
	{
		if (floors.size() != 0)
		{ // code will not run if there are no floors
			String room = null;

			do
			{ // forcing String with only letters / numbers
				System.out.println("Please enter a valid room number for the room you wish to remove:");

				room = userInput.nextLine();

				if (room.length() == 0)
				{
					System.out.println("INVALID INPUT - Room name cannot be blank!");
				}
				else if (!room.matches("[a-zA-Z0-9\\s\\(\\)\\-]+"))
				{
					System.out.println("That Room number is invalid - only numbers, letters, spaces, round brackets, and dashes are allowed!");
				}

			}
			while (room.matches("[a-zA-Z0-9\\s\\(\\)\\-]+") == false); // end of forcing loop

			room = room.toUpperCase();

			for (int a = 0; a < floors.size(); a++)
			{ // floor loop
				for (int b = 0; b < floors.get(a).getRooms().size(); b++)
				{ //room loop
					if (floors.get(a).getRooms().get(b).getName().equals(room))
					{ //if the room exits this will run
						System.out.printf("Removing Room \"%s\" on Floor %d\n", room, floors.get(a).getFloorNumber());
						floors.get(a).getRooms().remove(b); //removing room
						return; //returns method
					}

				}

			}

			System.out.println("That room does not exist!");
		}
		else
		{
			System.out.println("You are not able to remove a room as there are no floors in the school database!");
		}

	}//end of removeRoom()

	/* ************************************************
	 * @Author: Tomasz Cieslak
	 * @Date: June 8, 2018.
	 * This method removes a floor from the database
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void removeFloor()
	{
		boolean exists = false;
		int number = 0;

		System.out.println("Please enter the number of the floor that you wish to delete:");

		do
		{
			try
			{
				number = Integer.parseInt(userInput.nextLine());

				if (number < 1)
				{
					System.out.println("INVALID INPUT - floor number must be greater than zero");
					exists = false;
				}
				else
				{
					for (int i = 0; i < floors.size(); i++)
					{
						if (number == floors.get(i).getFloorNumber())
						{
							System.out.println("Removing floor " + floors.get(i).getFloorNumber() + " from database.......");
							floors.remove(i);
							exists = true;
							break;
						}
					}

					if (!exists)
					{
						System.out.println("That floor does not exist in the database!");
						exists = true;
					}
				}
			}
			catch (NumberFormatException invalidInput)
			{
				System.out.println("INVALID INPUT - only integers are permitted");
				exists = false;
			}
		}
		while (!exists);
	}

	/* *************************************************
	 * @Author: Kyle Ferreira
	 * @Date: June 8, 2018.
	 * This method removes all devices from all rooms
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void clearDevices()
	{
		for (int a = 0; a < floors.size(); a++)
		{
			for (int b = 0; b < floors.get(a).getRooms().size(); b++)
			{
				floors.get(a).getRooms().get(b).getDevices().clear();
			}
		}
	}

	/* *************************************************
	 * @Author: Snehit Khair
	 * @Date: June 8, 2018.
	 * This method searches for the floor that the user
	 * enters.  Uses a linear search.
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void searchFloor()
	{
		int floorNumberSearch = 0;
		boolean valid = false;

		do
		{
			try
			{
				System.out.println("Please enter a floor number");
				floorNumberSearch = Integer.parseInt(userInput.nextLine());

				if (floorNumberSearch < 1)
				{
					System.out.println("Floor numbers cannot be lower than 1");
				}
				else
				{
					valid = true;
				}
			}
			catch (NumberFormatException e)
			{
				valid = false;
				System.out.println("Wrong Data Type Detected... Please Try Again - floors can only be integer numbers");
			}
		}
		while (!valid);

		System.out.println("Searching for Floor " + floorNumberSearch + " .....................");

		for (int i = 0; i < floors.size(); i++)
		{
			if (floors.get(i).getFloorNumber() == floorNumberSearch)
			{
				floors.get(i).displayFloorData();
				return;
			}
		}

		System.out.println("Floor " + floorNumberSearch + " does not exist!");

	}// end of search floor by number method

	/* *************************************************
	 * @Author: Snehit Khair
	 * @Date: June 8, 2018.
	 * This method searches for the room that the user
	 * enters.  Uses Floor.searchByRoomName() to search
	 * each floor
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void searchRoom()
	{
		String roomNameSearch = null;

		while (true)
		{
			System.out.println("Enter the designated number/name of the room you would like to search for");
			roomNameSearch = userInput.nextLine();

			if (roomNameSearch.length() == 0)
			{
				System.out.println("INVALID INPUT - cannot search for blank room name");
			}
			else
			{
				break;
			}
		}

		System.out.println("Searching for Room " + roomNameSearch.toUpperCase() + " .....................");

		for (int i = 0; i < floors.size(); i++)
		{
			if (floors.get(i).searchByRoomName(roomNameSearch) == true) // if room is found
			{
				return;
			}
		} // goes through all floors for searching room number

		System.out.printf("Room \"%s\" cannot be found!\n", roomNameSearch);

	}// end of collective search of all floors for room methods

	/* *************************************************
	 * @Author: Snehit Khair
	 * @Date: June 8, 2018.
	 * This method sorts all the floors in the database.
	 * The method can sort ascending or descending and by energy
	 * consumption or floor number. The sorted list of floors
	 * is displayed at the end via the displaySchoolData() method.
	 * @param: what to sort by (boolean)   true = by energy, false = alphanumeric
	 * @return: none (void)
	 * *************************************************/

	public static void sortFloors(boolean byEnergy)
	{
		int order = 0;
		boolean valid = true;

		do
		{
			valid = true;

			try
			{
				System.out.println("OPTIONS--");
				System.out.println("1.) Ascending Order");
				System.out.println("2.) Descending Order");
				order = Integer.parseInt(userInput.nextLine());
				valid = true;

				if (order != 1 && order != 2)
				{
					valid = false;
					System.out.println("Not an Option--");
				}

			}
			catch (NumberFormatException e)
			{
				valid = false;
				System.out.println("Improper Response");
			}

		}
		while (!valid);

		if (byEnergy)
		{

			if (order == 1)
			{
				for (int n = 0; n < floors.size(); n++)
				{// outer loop for iterations
					for (int i = 0; i < floors.size() - 1 - n; i++)
					{// inner loop for swapping items
						if (floors.get(i + 1).calcFloorEnergy() < floors.get(i).calcFloorEnergy())
						{
							Floor holdObj = floors.get(i);
							floors.set(i, floors.get(i + 1));
							floors.set(i + 1, holdObj);
						} // end of swap

					} // end of inner loop

				} // end of outer loop

			} // end of ascending order sort
			else if (order == 2)
			{
				for (int n = 0; n < floors.size(); n++)
				{// outer loop for iterations
					for (int i = 0; i < floors.size() - 1 - n; i++)
					{// inner loop for swapping items
						if (floors.get(i + 1).calcFloorEnergy() > floors.get(i).calcFloorEnergy())
						{
							Floor holdObj = floors.get(i);
							floors.set(i, floors.get(i + 1));
							floors.set(i + 1, holdObj);
						} // end of swap

					} // end of inner loop

				} // end of outer loop

			} // end of descending order sort

		}
		else
		{

			if (order == 1)
			{
				for (int n = 0; n < floors.size(); n++)
				{// outer loop for iterations
					for (int i = 0; i < floors.size() - 1 - n; i++)
					{// inner loop for swapping items
						if (floors.get(i + 1).getFloorNumber() < floors.get(i).getFloorNumber())
						{
							Floor holdObj = floors.get(i);
							floors.set(i, floors.get(i + 1));
							floors.set(i + 1, holdObj);
						} // end of swap

					} // end of inner loop

				} // end of outer loop

			} // end of ascending order sort
			else if (order == 2)
			{
				for (int n = 0; n < floors.size(); n++)
				{// outer loop for iterations
					for (int i = 0; i < floors.size() - 1 - n; i++)
					{// inner loop for swapping items
						if (floors.get(i + 1).getFloorNumber() > floors.get(i).getFloorNumber())
						{
							Floor holdObj = floors.get(i);
							floors.set(i, floors.get(i + 1));
							floors.set(i + 1, holdObj);
						} // end of swap

					} // end of inner loop

				} // end of outer loop

			} // end of descending order sort

		}

		displaySchoolData();

	}// end of sort floor by total energy / room number method

	/* *************************************************
	 * @Author: Kyle Ferreira
	 * @Date: June 8, 2018.
	 * This method calculates the monthly energy consumption
	 * of the entire school in kWh
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static double calcSchoolEnergy()
	{
		double totalSchoolEnergy = 0;

		for (int a = 0; a < floors.size(); a++)
		{
			totalSchoolEnergy = totalSchoolEnergy + floors.get(a).calcFloorEnergy();
		}

		return totalSchoolEnergy;
	}

	/* *************************************************
	 * @Author: Snehit Khair
	 * @Date: June 8, 2018.
	 * This method sorts all the rooms across all the floors.
	 * The method can sort ascending or descending and by energy
	 * consumption or name (alphanumeric).
	 * A sorted list of the floors is displayed at the end.
	 * @param: what to sort by (boolean)   true = by energy, false = alphanumeric
	 * @return: none (void)
	 * *************************************************/

	public static void sortRooms(boolean byEnergy)
	{
		// gets order
		int order = 0;
		boolean valid = true;

		do
		{
			valid = true;

			try
			{
				System.out.println("OPTIONS--");
				System.out.println("1.) Ascending Order");
				System.out.println("2.) Descending Order");
				order = Integer.parseInt(userInput.nextLine());
				if (order != 1 && order != 2)
				{
					valid = false;
					System.out.println("Not an Option--");
				}
			}
			catch (NumberFormatException e)
			{
				valid = false;
				System.out.println("Improper Response");
			}

		}
		while (!valid);

		// note* argument represents which characteristic to sort by
		// the order is asked in previously in this method

		for (int i = 0; i < floors.size(); i++)
		{
			if (byEnergy)
			{
				floors.get(i).sortRoomsEnergy(order);// sorts rooms by energy on each floor separately
			}
			else
			{
				floors.get(i).sortRoomsNumber(order);// sorts rooms by energy on each floor separately
			}

		} // sorts rooms on every floor separately

		ArrayList<Room> sortRoomCollective = new ArrayList<Room>();

		for (int a = 0; a < floors.size(); a++)
		{
			for (int b = 0; b < floors.get(a).getRooms().size(); b++)
			{
				sortRoomCollective.add(floors.get(a).getRooms().get(b));
			}
		}

		if (byEnergy)
		{
			if (order == 1)
			{
				for (int n = 0; n < sortRoomCollective.size(); n++)
				{// outer loop for iterations
					for (int i = 0; i < sortRoomCollective.size() - 1 - n; i++)
					{// inner loop for swapping items
						if (sortRoomCollective.get(i + 1).calcRoomEnergy() < sortRoomCollective.get(i).calcRoomEnergy())
						{
							Room holdObj = sortRoomCollective.get(i);
							sortRoomCollective.set(i, sortRoomCollective.get(i + 1));
							sortRoomCollective.set(i + 1, holdObj);
						} // end of swap
					} // end of inner loop
				} // end of outer loop
			} // end of ascending order sort
			else if (order == 2)
			{
				for (int n = 0; n < sortRoomCollective.size(); n++)
				{// outer loop for iterations
					for (int i = 0; i < sortRoomCollective.size() - 1 - n; i++)
					{// inner loop for swapping items
						if (sortRoomCollective.get(i + 1).calcRoomEnergy() > sortRoomCollective.get(i).calcRoomEnergy())
						{
							Room holdObj = sortRoomCollective.get(i);
							sortRoomCollective.set(i, sortRoomCollective.get(i + 1));
							sortRoomCollective.set(i + 1, holdObj);
						} // end of swap
					} // end of inner loop
				} // end of outer loop
			} // end of descending order sort
		}
		else
		{
			if (order == 1)
			{
				for (int n = 0; n < sortRoomCollective.size(); n++)
				{// outer loop for iterations
					for (int i = 0; i < sortRoomCollective.size() - 1 - n; i++)
					{// inner loop for swapping items
						if (sortRoomCollective.get(i + 1).getName().compareTo(sortRoomCollective.get(i).getName()) < 0)
						{
							Room holdObj = sortRoomCollective.get(i);
							sortRoomCollective.set(i, sortRoomCollective.get(i + 1));
							sortRoomCollective.set(i + 1, holdObj);

						} // end of swap

					} // end of inner loop

				} // end of outer loop

			} // end of ascending order sort
			else if (order == 2)
			{
				for (int n = 0; n < sortRoomCollective.size(); n++)
				{// outer loop for iterations
					for (int i = 0; i < sortRoomCollective.size() - 1 - n; i++)
					{// inner loop for swapping items
						if (sortRoomCollective.get(i + 1).getName().compareTo(sortRoomCollective.get(i).getName()) > 0)
						{
							Room holdObj = sortRoomCollective.get(i);
							sortRoomCollective.set(i, sortRoomCollective.get(i + 1));
							sortRoomCollective.set(i + 1, holdObj);
						} // end of swap

					} // end of inner loop

				} // end of outer loop

			} // end of descending order sort
		}

		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.printf("%-30s   %-22s        %-18s\n", "Room Name", "Monthly Energy Consumption", "Trees Consumed Monthly");
		System.out.println("---------------------------------------------------------------------------------------------");

		if (sortRoomCollective.size() != 0)
		{
			for (int s = 0; s < sortRoomCollective.size(); s++)
			{
				System.out.printf("%-30s   %-22.2f kWH        %-18.2f\n", sortRoomCollective.get(s).getName(), sortRoomCollective.get(s).calcRoomEnergy(), sortRoomCollective.get(s).calcTreeKillRoom());
			}
		}
		else
		{
			System.out.println("NO ROOM DATA!");
		}

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}// end of collective sort of all room lists method

	/* *************************************************
	 * @Author: Kyle Pinto
	 * @Date: June 8, 2018.
	 * This method displays the schoolwide power consumption,
	 * including breakdowns for each floor and their room lists.
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static void displaySchoolData()
	{
		System.out.println("=============================================================================================");
		System.out.println("                         Project ECOtech - SCHOOLWIDE POWER DATABASE                         ");
		System.out.println("=============================================================================================");
		System.out.printf("School NAME:                        %s\n", schoolName);
		System.out.println("---------------------------------------------------------------------------------------------");

		if (floors.size() == 0)
		{
			System.out.printf("Schoolwide Monthly ENERGY COMSUMPTION:      N/A\n");
			System.out.printf("TREES Required Monthly to Sustain School:   N/A\n");
			System.out.printf("Total Monthly COST of School Energy:        N/A\n");
			System.out.printf("=============================================================================================\n");

			System.out.println("NO DATA!");
		}
		else
		{
			System.out.printf("Schoolwide Monthly ENERGY COMSUMPTION:      %.2f kWh\n", calcSchoolEnergy());
			System.out.printf("TREES Required Monthly to Sustain School:   %.1f trees\n", calcTreeKillSchool());
			System.out.printf("Total Monthly COST of School Energy:        $%.2f\n", calcSchoolEnergy() * 0.17);
			System.out.printf("=============================================================================================\n");

			for (int a = 0; a < floors.size(); a++)
			{
				floors.get(a).displayFloorData();
			}
		}

		System.out.printf("=============================================================================================\n");
	}

	/* *************************************************
	 * @Author: Kyle Ferreira
	 * @Date: June 8, 2018.
	 * This method calculates the quantity of trees required
	 * to sustain the school energy consumption for ONE month.
	 * @param: none
	 * @return: none (void)
	 * *************************************************/

	public static double calcTreeKillSchool()
	{
		return calcSchoolEnergy() * (0.18 / 12D);// trees needed per month to balance
	}

} // end of class School