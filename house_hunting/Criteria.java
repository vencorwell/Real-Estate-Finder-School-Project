package house_hunting;

/**
 * This contains the criteria specified by the user to select houses.
 * 
 * @author V. Corwell
 * @version September 24, 2025
 */
public class Criteria 
{
	// The minimum price entered by the user
	private int minimumPrice;
	// The maximum price entered by the user
	private int maximumPrice;
	// The minimum area entered by the user
	private int minimumArea;
	// The maximum area entered by the user
	private int maximumArea;
	// The minimum amount of bedrooms entered by the user
	private int minimumNumberOfBedrooms;
	// The maximum amount of bedrooms entered by the user
	private int maximumNumberOfBedrooms;
	
	//-------------------------------------------------------
	
	Criteria()
	{
		
	}
	
	//-------------------------------------------------------
	/**
	 * The constructor
	 * @param minPrice: An integer value
	 * @param maxPrice: An integer value
	 * @param minArea: An integer value
	 * @param maxArea: An integer value
	 * @param minBed: An integer value
	 * @param maxBed: An integer value
	 */
	
	Criteria(int minPrice, int maxPrice, int minArea, int maxArea, int minBed, int maxBed)
	{
		this.minimumPrice = minPrice;
		this.maximumPrice = maxPrice;
		this.minimumArea = minArea;
		this.maximumArea = maxArea;
		this.minimumNumberOfBedrooms = minBed;
		this.maximumNumberOfBedrooms = maxBed;
	}
	
	//-------------------------------------------------------
	
	public int getMinimumPrice()
	{
		return minimumPrice;
	}
	
	//-------------------------------------------------------
	
	public int getMaximumPrice()
	{
		return maximumPrice;
	}
	
	//-------------------------------------------------------
	
	public int getMinimumArea()
	{
		return minimumArea;
	}
	
	//-------------------------------------------------------
	
	public int getMaximumArea()
	{
		return maximumArea;
	}
	
	//-------------------------------------------------------
	
	public int getMinimumNumberOfBedrooms()
	{
		return minimumNumberOfBedrooms;
	}
	
	//-------------------------------------------------------
	
	public int getMaximumNumberOfBedrooms()
	{
		return maximumNumberOfBedrooms;
	}
	
}
