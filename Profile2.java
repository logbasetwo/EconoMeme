package economeme;

import java.util.ArrayList;
//import java.util.Scanner;

public class Profile{

	private String username;
	private String password;
	public int cash = 100; 
	public ArrayList<MemeStock> memes;
	private static int date;
	private ArrayList<Integer> amounts;
	
	
	public Profile(String username, String password)//int cash, ArrayList<MemeStock> memes, ArrayList<Integer> amounts) 
	{
		this.username = username;
		this.password = password;
                this.cash = cash;
		//this.memes = memes;
		//this.date = date;
		//this.amounts = amounts;
	}
	
        private int getPrice(Integer[] meme, int date){
        return meme[date];
    }
    
    
        public Boolean correctTransaction(Integer[] meme, int day, int userCash, int shares){
            int price = getPrice(meme, day);
            int totalCost = price * shares;
            if(totalCost >= userCash){
                return true;
            }
            else {
                return false;
            }
        }

        public int sellDifference(Integer[] meme, int startDate, int currentDate){
            //could implement a percentage value or total difference in price
            int ogPrice = getPrice(meme, startDate);
            int currentPrice = getPrice(meme, currentDate);

            int difference = currentPrice - ogPrice;
            return difference;
        }
        
	public static void setDate(int today)
	{
		date = today;
	}
	
	private int indexOfMeme(MemeStock other)
	{
		int index = -1;
		for(int i = 0; i < memes.size(); i++)
		{
			boolean jawn = other.equals(memes.get(i));
			if(jawn == true)
			{
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void buy(Integer[] meme, int amount) //MemeStock meme, int amount
	{
		if(indexOfMeme(meme) > -1)
		{
			amounts.set(indexOfMeme(meme), amounts.get(indexOfMeme(meme)) + amount);
		}
		else
		{
			memes.add(meme);
			amounts.add(amount);
		}
		
		cash -= meme.getValue(date)*amount;
	}
	
	public void sell(int index, int amount)
	{
		if(index < 0 || index >= memes.size()) {
			throw new IndexOutOfBoundsException();
		}
		else
		{
			cash += memes.get(index).getValue(date)*amount;
			if(amount < amounts.get(index))
			{
				amounts.set(index, amounts.get(index) - amount);
			}
			else
			{
				memes.remove(index);
				amounts.remove(index);
			}
			
		}
		/**
		else if(amount < amounts.get(index))
		{
			//amountIndex = amounts.get(index);
			amounts.set(index, amounts.get(index) - amount);
			cash += memes.get(index).getValue(date)*amount;
		}
		else 
		{
			
			memes.remove(index);
			amounts.remove(index);
		}
		**/
	}
	
	
	
	public String getLogin()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password; // long term don't store as plain text, but we don't need to worry about that for a demo
	}
	
	public int worth()
	{
		int worth = cash;
		for(int i = 0; i < memes.size(); i++)
		{
			worth += memes.get(i).getValue(date)*amounts.get(i);
		}
		
		return worth;
	}
	/*
	public String toString()
	{
		String memeString = "Meme Stocks:\n";
		for (MemeStock meme: memes)
		{
			memeString += meme;
		}	
		return "Profile for: " + username + "\ncash: " + cash + "\ntotalValue
	}
	*/
	public void printInfo()
	{
		System.out.println("cash: " + cash);
		System.out.println("worth: " + worth());
		System.out.println("********MEME STOCKS********");
		for(int i = 0; i < memes.size(); i++)
		{
			System.out.println("\n" + memes.get(i) + "\n\tshares: " + amounts.get(i));
		}
		System.out.println("****************************\n");

	}
        
        /*
	public static void main(String[] args)
	{
		
		int meme1array[] = {10, 12, 18, 29, 22, 23, 9, 11};
		int meme2array[] = {5, 9, 25, 39, 27, 15, 15, 7};
		int meme3array[] = {30, 20, 18, 24, 10, 5, 8, 22};
		int meme4array[] = {5, 9, 25, 39, 27, 15, 15, 7};
		MemeStock meme1 = new MemeStock("$SP", meme1array);
		MemeStock meme2 = new MemeStock("$DRK", meme2array);
		MemeStock meme3 = new MemeStock("$TOM", meme3array);
		MemeStock meme4 = new MemeStock("$DRK", meme4array);
		ArrayList<MemeStock> memes = new ArrayList<MemeStock>();
		memes.add(meme1);
		memes.add(meme2);
		ArrayList<Integer> amounts = new ArrayList<Integer>();
		amounts.add(4);
		amounts.add(1);
		Profile p = new Profile("dyeh", "dyeh", 200, memes, amounts);
		Profile.setDate(5);
		p.printInfo();
		p.buy(meme3, 3);
		p.printInfo();
		p.sell(2, 3);
		p.printInfo();
		p.buy(meme4, 2);
		p.printInfo();
	}

*/
			
		
}

	
	



