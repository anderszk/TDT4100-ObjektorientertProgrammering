package ClassesAndDebugging;

import java.util.*; //Import all the util-modules
import java.lang.*; //Import all the lang-modules

public class CardDeck {
    List<String> cardCounter = new ArrayList<>();
    private int totalCards;
    private int chosenCard;


    public int getCardCount() {
        return cardCounter.size();
    }

    private boolean validateGetCard(int in){
        if (in < cardCounter.size()){
            return true;
        }
        else return false;
    }

    public String getCard(int n) {
        if(validateGetCard(n)) {
            return cardCounter.get(n);
        }
        else{
            throw new IllegalArgumentException("Out of range");
        }
    }

    public CardDeck(int n){
        this.totalCards = n*4;

        String[] validSuits = {"S", "H", "D", "C"};
        for (String validSuit : validSuits) {
            int[] validNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
            for (int k = 1; k < n+1; k++) {
                cardCounter.add(validSuit + k);
            }
        }
    }

    public static void main(String[] args) { //Det er her koden faktisk blir executed

        CardDeck c = new CardDeck(10);
        for (int i = 0; i < c.cardCounter.size(); i++){
            System.out.println(c.cardCounter.get(i));
        }
        System.out.println(c.getCard(12));

    }


}
