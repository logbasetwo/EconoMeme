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
        //System.out.println(d);

        try {
            Scanner reader = new Scanner(file);
            for(int x = 0; x < d; x ++)
            {
                lineClearer = reader.nextLine();
                //System.out.println(lineClearer);
            }
            
            lineTaker = reader.nextLine();
            //System.out.println(lineTaker);
            String[] lineSplit = lineTaker.split(",", 0);
            //System.out.println(lineSplit[0]);
            //System.out.println(lineSplit[0]);
            //csv = Integer.parseInt(lineSplit[n]);
            String number = lineSplit[n];
            Integer result = Integer.valueOf(number);		
            //System.out.println(result);
            csv = result;
            //System.out.println(lineSplit[n]);
            //System.out.println(csv);
            
            
            
            /*for(int x = 0; x < lineTaker.length(); x++)
            {
                if(lineTaker.charAt(x) > 48 || lineTaker.charAt(x) < 57)
                {
                    line[x] = true;
                    counter++;
                }
                else
                    line[x] = false;
            }
            for(int x = 0; x < 8; x++)
            {
                if(line[x])
                    counter2++;
            }
            csv = 
            
            
            /*for(int x = 0; x < n; x++)
                numClearer = reader.nextInt();
            csv = reader.nextInt();*/            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MemeLibrary.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(csv);
        //System.out.println("a;lksdhfas;dlkf");
        return csv;
    }
    
    public static Integer readFile(int w, int y)
    {
        String csv1 = "";
        int memeNum = w + 1;
        int date = y + 3;
        int value = -1;
        value = csvReader(date, memeNum);
        //System.out.println(csv1);
        //System.out.println(value);
        return value;
    }
    
    public static Integer dataRetrieval (String w, int y)
    {
        //given meme name and date retrieves value of meme on date
        //System.out.println("a;lskdfj;lkajsd;lfk");
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
        
        //for (int x = 0; x < 30; x++)
            //System.out.println(surprisedPikachu[x]);
    }
    
}
