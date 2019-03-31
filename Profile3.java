import java.util.ArrayList;

public class Profile3 {

	private String username;
	private String password;
	public int cash = 200;
	public ArrayList<Integer[]> memes = new ArrayList<Integer[]>();
	private static int date;
	public ArrayList<Integer> amounts = new ArrayList<Integer>();
	
	
	public Profile3(String username, String password)//, int cash, ArrayList<MemeStock> memes, ArrayList<Integer> amounts) 
	{
		this.username = username;
		this.password = password;
		//this.cash = cash;
		//this.memes = memes;
		//this.date = date;
		//this.amounts = amounts;
	}
	
	public ArrayList<Integer[]> getMemeList()
	{
		return memes;
	}
	
	public ArrayList<Integer> getAmounts()
	{
		return amounts;
	}
	
	
	public static void setDate(int today)
	{
		date = today;
	}
	
	private static boolean equalValues(Integer[] array1, Integer[] array2)
	{
		for(int i = 0; i < array1.length; i++)
		{
			//System.out.println(array1[i]);
			//System.out.println(array2[i]);
			//Integer arr1 = array[i];
			//Integer arr2 = array
			int arr1 = array1[i].intValue();
			int arr2 = array2[i].intValue();
			if(arr1 != arr2)
			{
				return false;
			}
			else
			{
				continue;
			}
		}
		return true;
	}
	
	
	private int indexOfMeme(Integer[] other)
	{
		int index = -1;
		for(int i = 0; i < memes.size(); i++)
		{
			
			if(Profile3.equalValues(other, memes.get(i)))
			{
				index = i;
				break;
			}
			else
			{
				continue;
			}
		}
		return index;
	}
	
	public void buy(Integer[] meme, int amount)
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
		
		//cash -= meme.getValue(date)*amount;
		cash -= meme[date]*amount;
	}
	
	public void sell(int index, int amount)
	{
		if(index < 0 || index >= memes.size()) {
			throw new IndexOutOfBoundsException();
		}
		else
		{
			//cash += memes.get(index).getValue(date)*amount;
			Integer[] meme = memes.get(index);
			cash += meme[date]*amount;
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
        
	public String getLogin()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public int worth()
	{
		int worth = cash;
		for(int i = 0; i < memes.size(); i++)
		{
			Integer[] meme = memes.get(i);
			worth += meme[date]*amounts.get(i);
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
	private static String toStr(Integer[] meme)
	{
		String numString = "{";
		for(int num: meme)
		{
			String str = Integer.toString(num);
			numString += str + " ";
		}
		numString += "}";

		return numString;
	}
	public void printInfo()
	{
		System.out.println("cash: " + cash);
		System.out.println("worth: " + worth());
		System.out.println("********MEME STOCKS********");
		for(int i = 0; i < memes.size(); i++)
		{

			System.out.println("\n\tmeme: " + Profile3.toStr(memes.get(i)) + "\n\tshares: " + amounts.get(i));
		}
		System.out.println("****************************\n");

	}
	
	
	public static void main(String[] args)
	{
		
		Integer[] meme1array = {10, 12, 18, 29, 22, 23, 9, 11};
		Integer[] meme2array = {5, 9, 25, 39, 27, 15, 15, 7};
		Integer[] meme3array = {30, 20, 18, 24, 10, 5, 8, 22};
		Integer[] meme4array = {5, 9, 25, 39, 27, 15, 15, 7};
		//MemeStock meme1 = new MemeStock("$SP", meme1array);
		//MemeStock meme2 = new MemeStock("$DRK", meme2array);
		//MemeStock meme3 = new MemeStock("$TOM", meme3array);
		//MemeStock meme4 = new MemeStock("$DRK", meme4array);
		//ArrayList<MemeStock> memes = new ArrayList<MemeStock>();
		//memes.add(meme1);
		//memes.add(meme2);
		//ArrayList<Integer> amounts = new ArrayList<Integer>();
		//amounts.add(4);
		//amounts.add(1);
		Profile3 p = new Profile3("dyeh", "dyeh");
		Profile3.setDate(5);
		//p.buy(meme1array, 4);
		p.buy(meme1array, 4);
		p.printInfo();
		p.buy(meme2array, 1);
		p.printInfo();
		p.buy(meme3array, 3);
		p.printInfo();
		p.sell(2, 3);
		p.printInfo();
		p.buy(meme4array, 2);
		p.printInfo();
		p.sell(0, 2);
		p.printInfo();
	}
	
	
			

}
