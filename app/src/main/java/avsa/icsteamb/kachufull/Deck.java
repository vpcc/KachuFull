package avsa.icsteamb.kachufull;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Deck {

	private Context context;
	private ArrayList<Card> cards = new ArrayList<>();
	Stack<Card> stack = new Stack<>();
	static Random rn = new Random();

	public Deck(Context ctx) {

		context = ctx;
		String tmpName="";
		int [] rIDs = {R.mipmap.s_1, R.mipmap.s_2, R.mipmap.s_3,R.mipmap.s_4,R.mipmap.s_5,R.mipmap.s_6,R.mipmap.s_7,R.mipmap.s_8,R.mipmap.s_9
                ,R.mipmap.s_10,R.mipmap.s_11,R.mipmap.s_12,R.mipmap.s_13,R.mipmap.d_1, R.mipmap.d_2, R.mipmap.d_3,R.mipmap.d_4,R.mipmap.d_5,R.mipmap.d_6,R.mipmap.d_7,R.mipmap.d_8,R.mipmap.d_9
				,R.mipmap.d_10,R.mipmap.d_11,R.mipmap.d_12,R.mipmap.d_13,R.mipmap.c_1, R.mipmap.c_2, R.mipmap.c_3,R.mipmap.c_4,R.mipmap.c_5,R.mipmap.c_6,R.mipmap.c_7,R.mipmap.c_8,R.mipmap.c_9
                ,R.mipmap.c_10,R.mipmap.c_11,R.mipmap.c_12,R.mipmap.c_13,R.mipmap.h_1, R.mipmap.h_2, R.mipmap.h_3,R.mipmap.h_4,R.mipmap.h_5,R.mipmap.h_6,R.mipmap.h_7,R.mipmap.h_8,R.mipmap.h_9
                ,R.mipmap.h_10,R.mipmap.h_11,R.mipmap.h_12,R.mipmap.h_13};
		int val = 0;

		for (int i = 0; i< rIDs.length; i++) {
			Bitmap cardBMP = BitmapFactory.decodeResource(context.getResources(), rIDs[i]);
//			switch (i){
//				case 0:
//					tmpName="Ace";
//					val=1;
//					break;
//				case 1:
//					tmpName = "Two";
//					val=2;
//					break;
//				case 2:
//					tmpName = "Three";
//					val=3;
//					break;
//				case 3:
//					tmpName = "Four";
//					val=4;
//					break;
//				case 4:
//					tmpName = "Five";
//					val=5;
//					break;
//				case 5:
//					tmpName = "Six";
//					val=6;
//					break;
//				case 6:
//					tmpName = "Seven";
//					val=7;
//					break;
//				case 7:
//					tmpName = "Eight";
//					val=8;
//					break;
//				case 8:
//					tmpName = "Nine";
//					val=9;
//					break;
//				case 9:
//					tmpName = "Ten";
//					val=10;
//					break;
//				case 10:
//					tmpName = "Jack";
//					val=11;
//					break;
//				case 11:
//					tmpName = "Queen";
//					val=12;
//					break;
//				case 12:
//					tmpName = "King";
//					val=13;
//					break;
//
//			}

			if(i >= 0 && i <13) {
				Card card = new Card(val, tmpName, Suit.Spades, cardBMP);
                cards.add(card);
			}
			if(i >= 13 && i <26) {
				Card card = new Card(val - 13, tmpName, Suit.Diamonds, cardBMP);
                cards.add(card);
			}

			if(i >= 26 && i <39) {
				Card card = new Card(val - 26, tmpName, Suit.Clubs, cardBMP);
                cards.add(card);
			}
			if(i >= 39 && i <52) {
				Card card = new Card(val - 39, tmpName, Suit.Hearts, cardBMP);
                cards.add(card);
			}
		}
	}

	public void shuffleDeck() {

		int random;
		for (int i = 0; i < 52; i++) {
			random = rn.nextInt(cards.size());
			stack.push(cards.get(random));
			cards.remove(random);

		}

	}

	public Card dealACard() {

		return stack.pop();

	}


	public String toString() {

		return String.valueOf(cards);

	}

}