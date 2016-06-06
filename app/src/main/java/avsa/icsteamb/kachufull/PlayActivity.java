package avsa.icsteamb.kachufull;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    ImageButton card1, card2, card3, card4, card5;
    TextView aiText1, aiText2, aiText3;
    Deck deck;

    int playerTurn = 0;



    Player player = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    Player player4 = new Player();
    Suit dominant;
    ImageView trump;

    Player players[] = new Player[4];


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        aiText1 = (TextView) findViewById(R.id.aiText1);
        aiText2 = (TextView) findViewById(R.id.aiText2);
        aiText3 = (TextView) findViewById(R.id.aiText3);

        card1 = (ImageButton) findViewById(R.id.card1);
        card2 = (ImageButton) findViewById(R.id.card2);
        card3 = (ImageButton) findViewById(R.id.card3);
        card4 = (ImageButton) findViewById(R.id.card4);
        card5 = (ImageButton) findViewById(R.id.card5);

        trump = (ImageView) findViewById(R.id.trumpDisplay);

        deck = new Deck(this);

        players[0] = player;
        players[1] = player2;
        players[2] = player3;
        players[3] = player4;

        for (int gameNum = 1; gameNum < 10; gameNum++) {
            if(playerTurn == 4){
                playerTurn = 0;
            }

            deck.shuffleDeck();

            if (gameNum == 1 || gameNum == 5 || gameNum == 9) {

                dominant = Suit.Spades;
                trump.setImageResource(R.drawable.spades);

            } else if (gameNum == 2 || gameNum == 6) {

                dominant = Suit.Diamonds;
                trump.setImageResource(R.drawable.diamonds);

            } else if (gameNum == 3 || gameNum == 7) {

                dominant = Suit.Clubs;
                trump.setImageResource(R.drawable.clubs);

            } else {

                dominant = Suit.Hearts;
                trump.setImageResource(R.drawable.hearts);

            }

            if (gameNum <= 5) {
                for (int i = 0; i < gameNum; i++) {
                    player.setHand(deck.dealACard());
                    player2.setHand(deck.dealACard());
                    player3.setHand(deck.dealACard());
                    player4.setHand(deck.dealACard());
                }
            } else {
                for (int i = gameNum - 5; i < 5; i++) {
                    player.setHand(deck.dealACard());
                    player2.setHand(deck.dealACard());
                    player3.setHand(deck.dealACard());
                    player4.setHand(deck.dealACard());
                }
            }



            int totalBet = 0;
            playerTurn=(gameNum%4)-1;
            for (int z = 0; z < 4; z++) {

                if (playerTurn == 4) {

                    playerTurn = 0;

                }

                if(players[playerTurn].equals(player)){

                    card1.setImageBitmap(player.getHand(0).getImage());
                    //card2.setImageBitmap(player.getHand(1).getImage());
                    //card3.setImageBitmap(player.getHand(2).getImage());
                    //card4.setImageBitmap(player.getHand(3).getImage());
                    //card5.setImageBitmap(player.getHand(4).getImage());

                    LayoutInflater inflater = LayoutInflater.from(this);
                    View view = inflater.inflate(R.layout.bets, null);
                    EditText textInput = (EditText) view.findViewById(R.id.text_input);
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Enter Bet: ");
                    builder.setView(R.layout.bets);
                    builder.show();

                    //String sBet = String.valueOf(textInput);
                    //int iBet = Integer.valueOf(sBet);
                    //player.setBet(iBet);


                } else {

                    players[playerTurn].setBet(players[playerTurn].bet(dominant));
                    if (players[playerTurn].equals(player2)) {

                        aiText1.setText(String.valueOf(players[playerTurn].getBet()));

                    } else if (players[playerTurn].equals(player3)) {

                        aiText2.setText(String.valueOf(players[playerTurn].getBet()));

                    } else {

                        aiText3.setText(String.valueOf(players[playerTurn].getBet()));

                    }

                }
                totalBet = totalBet + players[playerTurn].getBet();

//                if (totalBet == players[playerTurn].getHandSize() && z == 3){
//
//                    totalBet = totalBet - players[playerTurn].getBet();
//                    players[playerTurn].setBet(validate(playerTurn, players[playerTurn].getHandSize(), totalBet));
//                    System.out.println(validate(playerTurn, players[playerTurn].getHandSize(), totalBet));
//                    totalBet = totalBet + players[playerTurn].getBet();
//
//                }

                playerTurn++;
            }

//            Start Playing
//            int handSize = player.getHandSize();
//            for ( int i = 0; i < handSize; i++) {
//
//                String mainSuit = "";
//                Card[] roundCards = new Card[4]; //Make this an arraylist
//                playerTurn=(gameNum%4)-1;
//                for (int k = 0; k < 4; k++) {
//
//                    Card cardPlaced = new Card();
//                    if (playerTurn == 4) {
//
//                        playerTurn = 0;
//
//                    }
//
//                    if (players[playerTurn].equals(player)) {
//
//                        System.out.print("Please Place a Card: ");
//                        int card = in.nextInt();
//                        cardPlaced = player.getCard(card);
//                        player.removeCard(cardPlaced);
//
//                    } else {
//
//                        cardPlaced = players[playerTurn].makeMove(mainSuit, dominant);
//                        System.out.println("\n"+players[playerTurn].getHand() + "\n");
//                        players[playerTurn].removeCard(cardPlaced);
//
//                    }
//
//                    if(k == 0 ) {
//
//                        mainSuit = cardPlaced.getSuit();
//
//                    }
//                    roundCards[k] = cardPlaced;
//                    playerTurn++;
//                }
//
//                for (Card card : roundCards) {
//
//                    System.out.println(card);
//
//                }
//
//            }


           // player.clearHand();
           // player2.clearHand();
           // player3.clearHand();
            //player4.clearHand();
            //playerTurn++;

        }



    }
// private static int validate(int playerTurn, int handSize, int totalBet) {
//
//        if (playerTurn == 0) {
//
//            boolean valid = false;
//            int newBet = 0;
//            System.out.println("You cannot bet that number as: total bet = hand size");
//            while (!valid ) {
//
//                System.out.print("Please bet again: ");
//                String temp = in.nextLine();
//                try {
//
//                    newBet = Integer.valueOf(temp);
//                    if ((newBet >=0 && newBet<=handSize) && (newBet+totalBet != handSize)) {
//
//                        return newBet;
//
//                    }
//
//                }catch (Exception e) {
//
//                    System.out.println("Please Enter a Valid Input!");
//
//                }
//            }
//        }
//
//        int bet = handSize - totalBet + 1;
//        return bet;
//
}