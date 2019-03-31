/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memelibrary;
//import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ross
 */
public class MemeLibrary {

    
    public static Integer csvReader(int d, int n)
    {
        String fileName = "memeLibrary.csv";
        File file = new File(fileName);   
        int csv = -1;
        String lineClearer = "";
        int numClearer = -1;
        int counter = 0;
        int counter2 = 0;
        String lineTaker = "";
        
        try {
            Scanner reader = new Scanner(file);
            for(int x = 0; x < d; x ++)
            {
                lineClearer = reader.nextLine();
            }
            
            lineTaker = reader.nextLine();
            String[] lineSplit = lineTaker.split(",", 0);
            String number = lineSplit[n];
            Integer result = Integer.valueOf(number);		
            csv = result;      
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MemeLibrary.class.getName()).log(Level.SEVERE, null, ex);
        }
        return csv;
    }
    
    public static Integer readFile(int w, int y)
    {
        String csv1 = "";
        int memeNum = w + 1;
        int date = y + 3;
        int value = -1;
        value = csvReader(date, memeNum);
        return value;
    }
    
    public static Integer dataRetrieval (String w, int y)
    {
        //given meme name and date retrieves value of meme on date

        if (w.equals("$SP"))
            return readFile(0, y);
        else if (w.equals("$DRK"))
            return readFile(1, y);
        else if (w.equals("$TOM"))
            return readFile(2, y);
        else if (w.equals("$DBF"))
            return readFile(3, y);
        else if (w.equals("$KMT"))
            return readFile(4, y);
        else
            {
            System.out.println("Error.");
                return -1;
            }
    }
    
    public static Integer[] updateMeme(Integer[] w, String y)
    {
        for(int x = 0; x < w.length; x++)
        {
            w[x] = dataRetrieval(y, x);
            System.out.print(x + ") ");
            System.out.println(w[x]);
        }
        System.out.println("good");
        return w;
    }
    
    /*
    public static void createProf(){
        
        
        
    } */
    
    public static void main(String[] args) throws FileNotFoundException {
        Integer[] surprisedPikachu = new Integer[29];
        surprisedPikachu = updateMeme(surprisedPikachu, "$SP");
        System.out.println("Pikachu");
        
        Integer[] drakeMeme = new Integer[29];
        drakeMeme = updateMeme(drakeMeme, "$DRK");
        System.out.println("Drake");
        
        Integer[] tomMeme = new Integer[29];
        tomMeme = updateMeme(tomMeme, "$TOM");
        System.out.println("Tom");
        
        Integer[] distractedBoyfriend = new Integer[29];
        distractedBoyfriend = updateMeme(distractedBoyfriend, "$DBF");
        System.out.println("BF");
        
        Integer[] kermitMeme = new Integer[29];
        kermitMeme = updateMeme(kermitMeme, "$KMT");
        System.out.println("Kermit");
        
        
        //createProf();
        
        //ask for user input for this info:
        
        
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a username: ");
        String username = reader.nextLine(); // Scans the next token of the input as an int.
        System.out.println("Enter a password: ");
        String password = reader.nextLine();
        //once finished
        String clear;
        if(reader.hasNext())
            clear = reader.nextLine();
        reader.close();
        
        //String username = "TJ";
        //String password = "42069nice";
        
        
        Profile profile1 = new Profile(username, password);
        
        Scanner scnr = new Scanner(System.in);
        String tickerSym = "";
        int dayNum = -1;
        System.out.println("Enter Meme ticker symbol (ie $SP): ");
        tickerSym = scnr.next();
        System.out.println("Enter day (0-29): ");
        dayNum = scnr.nextInt();
        System.out.println(tickerSym + " is worth " + dataRetrieval(tickerSym, dayNum) + " USD on day " + dayNum);
        
        /*
        THIS WOULD STILL BE SAME 2 VARS, with different user input
        */
        String username2 = "Horn";
        String password2 = "xc4life";
        
        Profile profile2 = new Profile(username2, password2);
        
        /*
        BUYING MEMES
        ask for user input for following info:
        */
        
        
        Integer[] meme = tomMeme;
        int day = 5;
        int amountBuy = 1;
        
        
        if(profile1.correctTransaction(meme, day, cash, totalShares))
        {         
        profile1.buy(meme, amountBuy);
        profile2.buy(meme, 4); 
        }
        
        /*
        SELLING MEMES
        ask for user input for following info:
        */
        
        Integer[] wantToSell = tomMeme;
        //somehow turn this into index variable
        int toSellIndex = 5;
        int amountSell = 1;
        
        profile1.sell(toSellIndex, amountSell);
        //profile1.sell(wantToSell, amountSell);
        
        
        
        
    }
    
}