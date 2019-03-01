/* =================================================
 * @Author: Kyle Ferreira
 * @Author: Kyle Pinto
 * @Author: Tomasz Cieslak
 * @Author: Snehit Khair
 *
 * @Date: June 8, 2018.
 *
 * This program is a database that stores data regarding
 * the energy consumption of an entire school building.
 * This is accomplished using a multi-level data structure
 * that represents all aspects of the building.  At the
 * core, data about specific power-consuming devices
 * is stored in separate ArrayLists for each room in the
 * building.  These are contained within Room classes,
 * each representing a single room.  Similarly, ArrayLists
 * of room types are stored in separate Floor classes,
 * each representing a single floor in the building.
 * Concluding this data structure is a main School class,
 * containing an ArrayList of Floor objects.  The main
 * School class also contains functions for sorting and
 * searching, additions and deletions, file saving and
 * loading, and the display of data.
 * =================================================*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Kyle Ferreira
 * @Author: Kyle Pinto
 * @Author: Tomasz Cieslak
 * @Author: Snehit Khair
 *
 * @Date: June 8, 2018.
 *
 * This is the class containing the main method.  It
 * runs the database by calling the static method
 * runDatabase() from the School class.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

class ECOtech
{
	public static void main(String [] arg)
	{
		School.runDatabase();
	}
}