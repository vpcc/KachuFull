package avsa.icsteamb.kachufull;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public int value() {
        int value = 0;
        for (Card card : cards) {
            value += card.getNumber();
        }
        return value;
    }

    public int numCards(){
        return cards.size();
    }

}