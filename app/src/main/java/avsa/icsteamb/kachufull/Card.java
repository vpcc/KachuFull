package avsa.icsteamb.kachufull;

import android.graphics.Bitmap;

public class Card {

	private Suit suit;
	private int number;
	private Bitmap cardImage;
	private String name;

public Card(){

}
	public Card( int number, String name, Suit suit, Bitmap cardImage) {
		this.number = number;
		this.name = name;
		this.suit = suit;
		this.cardImage = cardImage;
	}


	public Bitmap getImage(){
		return cardImage;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

    public void setName(String name){
        this.name.equals(name);
    }

    public String getName(){
        return name;
    }


}