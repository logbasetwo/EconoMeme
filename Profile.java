import java.util.ArrayList;
import java.util.Scanner;

public class Profile {

	private String username;
	private String password;
	private double cash = 100;
	private ArrayList<MemeStock> memes;
	
	public Profile(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public void buy(MemeStock meme, int amount)
	{
		meme.setShares(amount);
		memes.add(meme);
		cash -= meme.getValue()*amount;
	}
	
	public void sell(int index, int amount)
	{
		if(index < 0 || index >= memes.size()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			cash += memes.get(index).getValue()*amount;
			memes.remove(index);
		}
	}
	
	public String getLogin()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	public double worth()
	{
		double worth = cash;
		for(MemeStock meme: memes)
		{
			worth += meme.getValue()*meme.getShares();
		}
		return worth;
	}
	
	
	
}


