

public class MemeStock {

	private String meme;
	private int[] values;
	//private int shares;
	
	
	
	public MemeStock(String meme, int[] values)
	{
		this.meme = meme;
		this.values = values;
		//this.shares = shares;
	}
	
	public String getMeme()
	{
		return meme;
	}
	
	public int getValue(int date)
	{
		return values[date];
	}
	
	public int[] getValues()
	{
		return values;
	}
	/**
	public void setShares(int amount)
	{
		shares = amount;
	}
	
	public int getShares()
	{
		return shares;
	}
	
	public int valueChangePerShare(int dateBought, int currentDate)
	{
		return values[currentDate] - values[dateBought];
	}
	
	**/
	public boolean equals(Object other)
	{
		return meme.equals(((MemeStock) other).getMeme());
				//values.equals(((MemeStock) other).getValues()) && meme.equals(((MemeStock) other).getMeme());
	}
	
	
	
	public String toString()
	{
		String numString = "{";
		for(int num: values)
		{
			numString = numString.concat(num + " ");
		}
		numString = numString.concat("}");
		return "\tmeme: " + meme + "\n\tprice: " + numString;
	}
	
	
}
