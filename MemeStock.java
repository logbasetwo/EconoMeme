
public class MemeStock {

	private String meme;
	private double worth;
	private int shares;
	
	public MemeStock(String meme, double worth, int shares)
	{
		this.meme = meme;
		this.worth = worth;
		this.shares = shares;
	}
	
	public double getValue()
	{
		return worth;
	}
	
	public void setShares(int amount)
	{
		shares = amount;
	}
	
	public int getShares()
	{
		return shares;
	}
	

}
