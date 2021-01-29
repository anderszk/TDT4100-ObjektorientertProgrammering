package ClassesAndDebugging;

import java.util.*; //Import all the util-modules
import java.lang.*; //Import all the lang-modules

public class Card {
    private int cardNumber;
    private char cardSuit;

    private boolean validateNumber(int num){
        return 0 < num && num < 14;
    }

    private boolean validateSuit(char s){
        String suit = Character.toString(s);
        return suit.matches("[SHDC]") && suit.length() == 1;
    }

   public char getSuit(){
        return this.cardSuit;
   }

   public int getFace(){
        return this.cardNumber;
   }

   public String toString(){
       return String.format("%s%s", cardSuit, cardNumber);
   }

   public Card(char cardSuit, int cardNumber){
        if (validateNumber(cardNumber) && validateSuit(cardSuit)){
            this.cardNumber = cardNumber;
            this.cardSuit = cardSuit;
        }
        else {
            throw new IllegalArgumentException("Invalid inputparameters");
        }
   }


}

