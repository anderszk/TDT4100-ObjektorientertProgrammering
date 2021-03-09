package classes;

import java.util.*; //Import all the util-modules
import java.lang.*; //Import all the lang-modules

public class CardDeck {
    private List<Card> cardCounter = new ArrayList<>();
    private int totalCards;
    private char[] validSuits = new char[] {'S', 'H', 'D', 'C'};


    public int getCardCount() {
        return cardCounter.size();
    }

    private boolean validateCard(int in){
        return in < cardCounter.size();
    }

    public Card getCard(int n) {
        if(validateCard(n)) {
            return cardCounter.get(n);
        }
        else{
            throw new IllegalArgumentException("Out of range");
        }
    }

    public CardDeck(int n){
        this.totalCards = n*4;

        for (char validSuit : validSuits) {
            for (int k = 1; k < n + 1; k++) {
                cardCounter.add(new Card(validSuit, k));
            }
        }
    }

    public void shufflePerfectly(){
        List<Card> card1 = new ArrayList<>();
        List<Card> card2 = new ArrayList<>();
        int half = getCardCount()/2;
        for (int i = 0; i < half; i++){
            card1.add(cardCounter.get(i));
        }
        for (int k = half; k < getCardCount(); k++){
            card2.add(cardCounter.get(k));
        }
        cardCounter.clear();
        for (int i = 0; i < half; i++){
            cardCounter.add(card1.get(i));
            cardCounter.add(card2.get(i));
        }
        System.out.println(cardCounter);
    }

    public static void main(String[] args) { //Det er her koden faktisk blir executed

        CardDeck c = new CardDeck(10);
        for (int i = 0; i < c.cardCounter.size(); i++){
            System.out.println(c.cardCounter.get(i));
        }
        System.out.println(c.getCard(12));

    }


}
