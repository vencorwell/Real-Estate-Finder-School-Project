package house_hunting;

/**
 * Represents the details of a house for sale
 * 
 * @author V. Corwell
 * @version September 24, 2025
 */

public class House 
{
	// Address of a house
	private String address;
	// Price of a house
	private int price;
	// Area of a house
	private int area;
	// Number of bedrooms a house has
	private int numBedrooms;
	
	//-------------------------------------------------------
	
	/*House()
	{
		
	}
	*/
	
	//-------------------------------------------------------
	/**
	 * The constructor
	 * @param address: A String object
	 * @param price: An integer value
	 * @param area: An integer value
	 * @param numBedrooms: An integer value
	 */
	House(String address, int price, int area, int numBedrooms)
	{
		this.address = address;
		this.price = price;
		this.area = area;
		this.numBedrooms = numBedrooms;
	}
	
	//-------------------------------------------------------
	
	public String getAddress()
	{
		return address;
	}
	
	//-------------------------------------------------------
	
	public int getPrice()
	{
		return price;
	}
	
	//-------------------------------------------------------
	
	public int getArea()
	{
		return area;
	}
	
	//-------------------------------------------------------
	
	public int getNumBedrooms()
	{
		return numBedrooms;
	}
	
	//-------------------------------------------------------
	/**
	 * Returns whether or not the house meets the criteria specified by c
	 * @param c: A Criteria object
	 * @return boolean: result of whether or not the criteria is met
	 */
	public boolean satisfies(Criteria c)
	{
		if(price < c.getMinimumPrice() || price > c.getMaximumPrice())
		{
			return false;
		}
		
		if(area < c.getMinimumArea() || area > c.getMaximumArea())
		{
			return false;
		}
		
		if(numBedrooms < c.getMinimumNumberOfBedrooms() || numBedrooms > c.getMaximumNumberOfBedrooms())
		{
			return false;
		}
		
		return true;
	}
	
	//-------------------------------------------------------
	/**
	 * Creates a nice printable string describing the House data
	 * @return String: A single String of all of a house's data
	 */
	@Override
	public String toString()
	{
		String info = "Address: " + address + "\nPrice: " + price + "\nArea: " + area + "\nBedrooms: " + numBedrooms + "\n\n";
		return info;
	}

}
