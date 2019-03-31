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

/**
 *
 * @author Ross
 */
public class MemeLibrary {

    public static Integer readFile(int w, int y) throws FileNotFoundException
    {
        String fileName = "memeLibrary.csv";
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        int memeNum = w + 3;
        int date = y + 3;
        String lineClearer = "";
        int value = -1;
        for(int x = 0; x < date; x++)
        {
            lineClearer = reader.nextLine();
        }
        for(int z = 0; z < memeNum; z++)
        {
            value = reader.nextInt();
        }
        value = reader.nextInt();
        return value;
    }
    
    public static Integer dataRetrieval (String w, int y)
    {
        //given meme name and date retrieves value of meme on date
        if (w.equals("$SP"))
            
        else if
    }
    
    public static Integer[] updateMeme(Integer[] w, String y)
    {
        for(int x = 0; x < 30; x++)
        {
            w[x] = dataRetrieval(y, x);
        }
        return w;
    }
    
    public static void main(String[] args) {
        Integer[] surprisedPikachu = new Integer[30];
        surprisedPikachu = updateMeme(surprisedPikachu, "$SP");
        
        Integer[] drakeMeme = new Integer[30];
        drakeMeme = updateMeme(drakeMeme, "$DRK");
        
        Integer[] tomMeme = new Integer[30];
        tomMeme = updateMeme(tomMeme, "$TOM");
        
        Integer[] distractedBoyfriend = new Integer[30];
        distractedBoyfriend = updateMeme(distractedBoyfriend, "$DBF");
        
        Integer[] kermitMeme = new Integer[30];
        kermitMeme = updateMeme(kermitMeme, "$KMT");
        
        
    }
    
}
