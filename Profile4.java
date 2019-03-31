import java.util.ArrayList;

public class Profile4 {

	private String username;
	private String password;
	public int cash = 200;
	public ArrayList<Integer[]> memes = new ArrayList<Integer[]>();
	private static int date;
	public ArrayList<Integer> amounts = new ArrayList<Integer>();
	
	
	public Profile4(String username, String password)
	{
		this.username = username;
		this.password = password;

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
			
			if(Profile4.equalValues(other, memes.get(i)))
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
		
		cash -= meme[date]*amount;
	}
	
	public void sell(int index, int amount)
	{
		if(index < 0 || index >= memes.size()) {
			throw new IndexOutOfBoundsException();
		}
		else
		{
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

			System.out.println("\n\tmeme: " + Profile4.toStr(memes.get(i)) + "\n\tshares: " + amounts.get(i));
		}
		System.out.println("****************************\n");

	}
	
	
	public static void main(String[] args)
	{
		
		Integer[] meme1array = {10, 12, 18, 29, 22, 23, 9, 11};
		Integer[] meme2array = {5, 9, 25, 39, 27, 15, 15, 7};
		Integer[] meme3array = {30, 20, 18, 24, 10, 5, 8, 22};
		Integer[] meme4array = {5, 9, 25, 39, 27, 15, 15, 7};
		Profile4 p = new Profile4("dyeh", "dyeh");
		Profile4.setDate(5);
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
