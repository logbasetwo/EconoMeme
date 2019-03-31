/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package economeme;

import java.util.Date;

/**
 *
 * @author matthew
 */
public class UserBank {
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
    
    
    
    
}
