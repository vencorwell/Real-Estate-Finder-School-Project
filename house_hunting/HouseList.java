package house_hunting;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Integer;

/**
 * Contains an ArrayList of House objects. 
 * Reads the data from a file called house.txt and adds them to the array list.
 * Allows for searching of houses that satisfy criteria.
 * 
 * @author V. Corwell
 * @version September 24, 2025
 */

public class HouseList 
{
	// House objects retrieved from the file data
	ArrayList<House> houseList = new ArrayList<>();
	
	//-------------------------------------------------------
	
	public HouseList(String fileName)
	{
		// Read file
		try
		{
			File myFile = new File(fileName);
			Scanner fileReader = new Scanner(myFile);
			while(fileReader.hasNextLine())
			{
				// store data of line being read
				String data = fileReader.nextLine();
				
				// The file is formated address_price_area_bedrooms so split it
				String[] dataSplit = data.trim().split("\\s+");
				
				// Create House objects and add them to the instance variable 'houseList'
				// index 0 = address, index 1 = price, index 2 = area, index 3 = number of bedrooms
				houseList.add(new House(dataSplit[0], Integer.parseInt(dataSplit[1]), Integer.parseInt(dataSplit[2]), Integer.parseInt(dataSplit[3])));
				
			}
			fileReader.close();
		} catch (FileNotFoundException e) 
		{
			System.out.println("Could not find file: " + fileName);
			
			// Where the system is looking for the inputed file
			System.out.println("The system is looking for the text file in this directory: ");
			System.out.println(new File(".").getAbsolutePath());
		}
		
	}
	
	//-------------------------------------------------------
	/**
	 * Print all the houses that satisfy the criterion 'c'
	 * @param c: a Criteria object
	 */
	public void printHouses(Criteria c)
	{
		
		System.out.print("\nThese houses have matched the criteria: \n" + getHouses(c));
	}
	
	//-------------------------------------------------------
	/**
	 * Retrieves all the houses that meet the criteria 
	 * @param c
	 * @return ArrayList: an array list of all houses that satisfy the criterion 'c'.
	 */
	public ArrayList<House> metCriteriaList(Criteria c)
	{
		ArrayList<House> matchedHouses = new ArrayList<>();
		
		// Search all the houses for those that meet the criteria
		for(House h : houseList)
		{
			// If the house meets the criteria, add the house's details to the string to be returned
			if(h.satisfies(c))
			{
				matchedHouses.add(h);	
			}
		}
		
		return matchedHouses;
	}
	/**
	 * Retrieves all the houses that meet the criteria and concatenates their details into a string
	 * @param c
	 * @return String: a concatenated string of the details of all houses that satisfy the criterion 'c'.
	 */
	public String getHouses(Criteria c)
	{
		String metCriteria = "";
		
		// Search all the houses for those that meet the criteria
		for(House h : houseList)
		{
			// If the house meets the criteria, add the house's details to the string to be returned
			if(h.satisfies(c))
			{
				metCriteria += h.toString();	
			}
		}
		
		// If no houses' details were added to the string to be returned, let the user know.
		if(metCriteria == "")
		{
			metCriteria = "None\n";
		}
		
		return metCriteria;
	}
}
