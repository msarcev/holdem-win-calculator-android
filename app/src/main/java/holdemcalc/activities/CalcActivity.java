package holdemcalc.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import holdemcalc.evaluator.Evaluator;
import holdemcalc.R;
import holdemcalc.gui.EventHandler;

public class CalcActivity extends Activity implements OnClickListener {

    private ImageView nextview;
    public int cardPointer;
    //Players cards
    public int playerOneCardOne;
    public int playerOneCardTwo;
    public int playerTwoCardOne;
    public int playerTwoCardTwo;
    //Table cards
    public int flopCard1;
    public int flopCard2;
    public int flopCard3;
    public int turnCard;
    public int riverCard;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);

        cardPointer = 1;
        setNextview(cardPointer);
        EventHandler.initListeners(this);
    }


    @Override
    public void onClick(View v) {

        EventHandler.handleClick(this, v);

        if (cardPointer == 5) {
            calculateWinOfPoketCards();
        }
        if (cardPointer == 8) {
            calculateWinAfterFlop();
        }
        if (cardPointer == 9) {
            calculateWinAfterTurn();
        }
        if (cardPointer == 10) {
            calculateWinAfterRiver();
        }
    }

    public void setNextview(int num) {
        switch (num) {
            case 1:
                this.nextview = (ImageView) findViewById(R.id.player1card1);
                break;
            case 2:
                this.nextview = (ImageView) findViewById(R.id.player1card2);
                break;
            case 3:
                this.nextview = (ImageView) findViewById(R.id.player2card1);
                break;
            case 4:
                this.nextview = (ImageView) findViewById(R.id.player2card2);
                break;
            case 5:
                this.nextview = (ImageView) findViewById(R.id.flop1);
                break;
            case 6:
                this.nextview = (ImageView) findViewById(R.id.flop2);
                break;
            case 7:
                this.nextview = (ImageView) findViewById(R.id.flop3);
                break;
            case 8:
                this.nextview = (ImageView) findViewById(R.id.turn);
                break;
            case 9:
                this.nextview = (ImageView) findViewById(R.id.river);
                break;
        }
    }

    public ImageView getNextview() {
        return nextview;
    }

    public void calculateWinOfPoketCards() {

        long keyOfP1PossibleHand;
        long keyOfP2PossibleHand;
        int p1WinCount = 0;
        int p2WinCount = 0;
        int ties = 0;
        int nOfHands = 0;

        long keyOfPlayer1PoketCards = Evaluator.makeKey(Evaluator.formatCard8bit(playerOneCardOne), playerOneCardTwo);
        int player1HandRank = Evaluator.getHandRank(keyOfPlayer1PoketCards);

        long keyOfPlayer2PoketCards = Evaluator.makeKey(Evaluator.formatCard8bit(playerTwoCardOne), playerTwoCardTwo);
        int player2HandRank = Evaluator.getHandRank(keyOfPlayer2PoketCards);

        //Counting who has more wins
        for (int i = 1; i <= 52; i++)
            for (int j = 1; j <= 52; j++)
                for (int k = 1; k <= 52; k++) {

                    if (cardsAreUnique(i, j, k)) {

                        keyOfP1PossibleHand = Evaluator.makeKey(keyOfPlayer1PoketCards, i);
                        keyOfP1PossibleHand = Evaluator.makeKey(keyOfP1PossibleHand, j);
                        keyOfP1PossibleHand = Evaluator.makeKey(keyOfP1PossibleHand, k);

                        keyOfP2PossibleHand = Evaluator.makeKey(keyOfPlayer2PoketCards, i);
                        keyOfP2PossibleHand = Evaluator.makeKey(keyOfP2PossibleHand, j);
                        keyOfP2PossibleHand = Evaluator.makeKey(keyOfP2PossibleHand, k);

                        int p1HandRank = Evaluator.getHandRank(keyOfP1PossibleHand);
                        int p2HandRank = Evaluator.getHandRank(keyOfP2PossibleHand);

                        if (p1HandRank > p2HandRank) p1WinCount++;
                        if (p1HandRank < p2HandRank) p2WinCount++;
                        if (p1HandRank == p2HandRank) ties++;

                        nOfHands++;
                    }
                }

        int p1WinPercentage = (p1WinCount * 100) / nOfHands;
        int p2WinPercentage = (p2WinCount * 100) / nOfHands;
        int tiesPercentage = (ties * 100) / nOfHands;

        if (player1HandRank < 1278)  // High Card
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + tiesPercentage + "% ");
        } else if (player1HandRank < 4138) // One Pair
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + tiesPercentage + "%  \nOne pair");
        } else if (player1HandRank < 4996)  // Two Pair
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + tiesPercentage + "%  \nTwo pairs");
        } else if (player1HandRank < 5854)  // Three of a Kind
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + tiesPercentage + "%  \nThree of a kind!");
        } else if (player1HandRank < 5864) // Straight
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + tiesPercentage + "%  \nStraight!");
        } else if (player1HandRank < 7141)  // Flush
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + tiesPercentage + "% \nFlush!");
        } else if (player1HandRank < 7297)  // Full House
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + tiesPercentage + "% \nFull house!");
        } else if (player1HandRank < 7453) // Four of a Kind
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + tiesPercentage + "% \nFour of a kind!");
        } else if (player1HandRank < 7462)                // Straight Flush
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + tiesPercentage + "%  \nStraight flush!");
        }

        if (player2HandRank < 1278)  // High Card
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + tiesPercentage + "%");
        } else if (player2HandRank < 4138) // One Pair
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + tiesPercentage + "%  \nOne pair");
        } else if (player2HandRank < 4996)  // Two Pair
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + tiesPercentage + "%  \nTwo pairs");
        } else if (player2HandRank < 5854)  // Three of a Kind
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + tiesPercentage + "%  \nThree of a kind!");
        } else if (player2HandRank < 5864) // Straight
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + tiesPercentage + "%  \nStraight!");
        } else if (player2HandRank < 7141)  // Flush
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + tiesPercentage + "%  \nFlush!");
        } else if (player2HandRank < 7297)  // Full House
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + tiesPercentage + "% \nFull house!");
        } else if (player2HandRank < 7453) // Four of a Kind
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "%Draw = " + tiesPercentage + "% \nFour of a kind!");
        } else if (player2HandRank < 7462)                // Straight Flush
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + tiesPercentage + "%  \nStraight flush!");
        }
    }

    public void calculateWinAfterFlop() {

        long keyOfP1PossibleHand;
        long keyOfP2PossibleHand;
        int p1WinCount = 0;
        int p2WinCount = 0;
        int ties = 0;
        int nOfHands = 0;

        long keyOfPlayer1FlopCards = Evaluator.makeKey(Evaluator.formatCard8bit(playerOneCardOne), playerOneCardTwo);
        keyOfPlayer1FlopCards = Evaluator.makeKey(keyOfPlayer1FlopCards, flopCard1);
        keyOfPlayer1FlopCards = Evaluator.makeKey(keyOfPlayer1FlopCards, flopCard2);
        keyOfPlayer1FlopCards = Evaluator.makeKey(keyOfPlayer1FlopCards, flopCard3);
        int p1HandRank = Evaluator.getHandRank(keyOfPlayer1FlopCards);

        long keyOfPlayer2FlopCards = Evaluator.makeKey(Evaluator.formatCard8bit(playerTwoCardOne), playerTwoCardTwo);
        keyOfPlayer2FlopCards = Evaluator.makeKey(keyOfPlayer2FlopCards, flopCard1);
        keyOfPlayer2FlopCards = Evaluator.makeKey(keyOfPlayer2FlopCards, flopCard2);
        keyOfPlayer2FlopCards = Evaluator.makeKey(keyOfPlayer2FlopCards, flopCard3);
        int p2HandRank = Evaluator.getHandRank(keyOfPlayer2FlopCards);

        for (int i = 1; i <= 52; i++)
            for (int j = 1; j <= 52; j++) {
                if (cardsAreUnique(i, j)) {
                    keyOfP1PossibleHand = Evaluator.makeKey(keyOfPlayer1FlopCards, i);
                    keyOfP1PossibleHand = Evaluator.makeKey(keyOfP1PossibleHand, j);

                    keyOfP2PossibleHand = Evaluator.makeKey(keyOfPlayer2FlopCards, i);
                    keyOfP2PossibleHand = Evaluator.makeKey(keyOfP2PossibleHand, j);

                    int rank1 = Evaluator.getHandRank(keyOfP1PossibleHand);
                    int rank2 = Evaluator.getHandRank(keyOfP2PossibleHand);

                    if (rank1 > rank2) p1WinCount++;
                    if (rank1 < rank2) p2WinCount++;
                    if (rank1 == rank2) ties++;

                    nOfHands++;
                }
            }

        int p1WinPercentage = (p1WinCount * 100) / nOfHands;
        int p2WinPercentage = (p2WinCount * 100) / nOfHands;
        int drawPercentage = (ties * 100) / nOfHands;

        if (p1HandRank < 1278)  // High Card
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "% ");
        } else if (p1HandRank < 4138) // One Pair
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "%  \nOne pair");
        } else if (p1HandRank < 4996)  // Two Pair
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "%  \nTwo pairs");
        } else if (p1HandRank < 5854)  // Three of a Kind
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "%  \nThree of a kind!");
        } else if (p1HandRank < 5864) // Straight
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "%  \nStraight!");
        } else if (p1HandRank < 7141)  // Flush
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "% \nFlush!");
        } else if (p1HandRank < 7297)  // Full House
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "% \nFull house!");
        } else if (p1HandRank < 7453) // Four of a Kind
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "% \nFour of a kind!");
        } else if (p1HandRank < 7462)                // Straight Flush
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "%  \nStraight flush!");
        }


        if (p2HandRank < 1278)  // High Card
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%");
        } else if (p2HandRank < 4138) // One Pair
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%  \nOne pair");
        } else if (p2HandRank < 4996)  // Two Pair
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%  \nTwo pairs");
        } else if (p2HandRank < 5854)  // Three of a Kind
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%  \nThree of a kind!");
        } else if (p2HandRank < 5864) // Straight
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%  \nStraight!");
        } else if (p2HandRank < 7141)  // Flush
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%  \nFlush!");
        } else if (p2HandRank < 7297)  // Full House
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "% \nFull house!");
        } else if (p2HandRank < 7453) // Four of a Kind
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "%Draw = " + drawPercentage + "% \nFour of a kind!");
        } else if (p2HandRank < 7462)                // Straight Flush
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%  \nStraight flush!");
        }
    }

    public void calculateWinAfterTurn() {

        long keyOfP1PossibleHand;
        long keyOfP2PossibleHand;
        int p1WinCount = 0;
        int p2WinCount = 0;
        int ties = 0;
        int nOfHands = 0;

        long keyOfPlayer1HandAfterTurn = Evaluator.makeKey(Evaluator.formatCard8bit(playerOneCardOne), playerOneCardTwo);
        keyOfPlayer1HandAfterTurn = Evaluator.makeKey(keyOfPlayer1HandAfterTurn, flopCard1);
        keyOfPlayer1HandAfterTurn = Evaluator.makeKey(keyOfPlayer1HandAfterTurn, flopCard2);
        keyOfPlayer1HandAfterTurn = Evaluator.makeKey(keyOfPlayer1HandAfterTurn, flopCard3);
        keyOfPlayer1HandAfterTurn = Evaluator.makeKey(keyOfPlayer1HandAfterTurn, turnCard);

        int p1HandRank = Evaluator.getHandRank(keyOfPlayer1HandAfterTurn);

        long keyOfPlayer2HandAfterTurn = Evaluator.makeKey(Evaluator.formatCard8bit(playerTwoCardOne), playerTwoCardTwo);
        keyOfPlayer2HandAfterTurn = Evaluator.makeKey(keyOfPlayer2HandAfterTurn, flopCard1);
        keyOfPlayer2HandAfterTurn = Evaluator.makeKey(keyOfPlayer2HandAfterTurn, flopCard2);
        keyOfPlayer2HandAfterTurn = Evaluator.makeKey(keyOfPlayer2HandAfterTurn, flopCard3);
        keyOfPlayer2HandAfterTurn = Evaluator.makeKey(keyOfPlayer2HandAfterTurn, turnCard);

        int p2HandRank = Evaluator.getHandRank(keyOfPlayer2HandAfterTurn);

        for (int i = 1; i <= 52; i++) {
            if (cardsAreUnique(i)) {
                keyOfP1PossibleHand = Evaluator.makeKey(keyOfPlayer1HandAfterTurn, i);

                keyOfP2PossibleHand = Evaluator.makeKey(keyOfPlayer2HandAfterTurn, i);

                int rank1 = Evaluator.getHandRank(keyOfP1PossibleHand);
                int rank2 = Evaluator.getHandRank(keyOfP2PossibleHand);

                if (rank1 > rank2) p1WinCount++;
                if (rank1 < rank2) p2WinCount++;
                if (rank1 == rank2) ties++;

                nOfHands++;
            }
        }

        int p1WinPercentage = (p1WinCount * 100) / nOfHands;
        int p2WinPercentage = (p2WinCount * 100) / nOfHands;
        int drawPercentage = (ties * 100) / nOfHands;

        if (p1HandRank < 1278)  // High Card
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "% ");
        } else if (p1HandRank < 4138) // One Pair
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "%  \nOne pair");
        } else if (p1HandRank < 4996)  // Two Pair
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "%  \nTwo pairs");
        } else if (p1HandRank < 5854)  // Three of a Kind
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "%  \nThree of a kind!");
        } else if (p1HandRank < 5864) // Straight
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "%  \nStraight!");
        } else if (p1HandRank < 7141)  // Flush
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "% \nFlush!");
        } else if (p1HandRank < 7297)  // Full House
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "% \nFull house!");
        } else if (p1HandRank < 7453) // Four of a Kind
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "% \nFour of a kind!");
        } else if (p1HandRank < 7462)                // Straight Flush
        {
            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = " + p1WinPercentage + "% Draw = " + drawPercentage + "%  \nStraight flush!");
        }


        if (p2HandRank < 1278)  // High Card
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%");
        } else if (p2HandRank < 4138) // One Pair
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%  \nOne pair");
        } else if (p2HandRank < 4996)  // Two Pair
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%  \nTwo pairs");
        } else if (p2HandRank < 5854)  // Three of a Kind
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%  \nThree of a kind!");
        } else if (p2HandRank < 5864) // Straight
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%  \nStraight!");
        } else if (p2HandRank < 7141)  // Flush
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%  \nFlush!");
        } else if (p2HandRank < 7297)  // Full House
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "% \nFull house!");
        } else if (p2HandRank < 7453) // Four of a Kind
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "%Draw = " + drawPercentage + "% \nFour of a kind!");
        } else if (p2HandRank < 7462)                // Straight Flush
        {
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = " + p2WinPercentage + "% Draw = " + drawPercentage + "%  \nStraight flush!");
        }
    }

    private boolean cardsAreUnique(int i, int j, int k) {
        return i != playerOneCardOne && i != playerOneCardTwo &&
                i != playerTwoCardOne && i != playerTwoCardTwo &&
                j != playerOneCardOne && j != playerOneCardTwo
                && j != playerTwoCardOne && j != playerTwoCardTwo
                && k != playerTwoCardOne && k != playerTwoCardTwo
                && i != j && i != k && j != k;
    }

    private boolean cardsAreUnique(int i, int j) {
        return i != playerOneCardOne && i != playerOneCardTwo && i != playerTwoCardOne && i != playerTwoCardTwo && j != playerOneCardOne
                && j != playerOneCardTwo && j != playerTwoCardOne && j != playerTwoCardTwo
                && i != flopCard1 && j != flopCard1
                && i != flopCard2 && j != flopCard2
                && i != flopCard3 && j != flopCard3 && i != j;
    }

    private boolean cardsAreUnique(int i) {
        return i != playerOneCardOne && i != playerOneCardTwo && i != playerTwoCardOne && i != playerTwoCardTwo &&
                i != flopCard1 && i != flopCard2 && i != flopCard3;
    }

    public void calculateWinAfterRiver() {

        long keyOfPlayer1HandAfterRiver = Evaluator.makeKey(Evaluator.formatCard8bit(playerOneCardOne), playerOneCardTwo);
        keyOfPlayer1HandAfterRiver = Evaluator.makeKey(keyOfPlayer1HandAfterRiver, flopCard1);
        keyOfPlayer1HandAfterRiver = Evaluator.makeKey(keyOfPlayer1HandAfterRiver, flopCard2);
        keyOfPlayer1HandAfterRiver = Evaluator.makeKey(keyOfPlayer1HandAfterRiver, flopCard3);
        keyOfPlayer1HandAfterRiver = Evaluator.makeKey(keyOfPlayer1HandAfterRiver, turnCard);
        keyOfPlayer1HandAfterRiver = Evaluator.makeKey(keyOfPlayer1HandAfterRiver, riverCard);
        int p1HandRank = Evaluator.getHandRank(keyOfPlayer1HandAfterRiver);

        long keyOfPlayer2HandAfterRiver = Evaluator.makeKey(Evaluator.formatCard8bit(playerTwoCardOne), playerTwoCardTwo);
        keyOfPlayer2HandAfterRiver = Evaluator.makeKey(keyOfPlayer2HandAfterRiver, flopCard1);
        keyOfPlayer2HandAfterRiver = Evaluator.makeKey(keyOfPlayer2HandAfterRiver, flopCard2);
        keyOfPlayer2HandAfterRiver = Evaluator.makeKey(keyOfPlayer2HandAfterRiver, flopCard3);
        keyOfPlayer2HandAfterRiver = Evaluator.makeKey(keyOfPlayer2HandAfterRiver, turnCard);
        keyOfPlayer2HandAfterRiver = Evaluator.makeKey(keyOfPlayer2HandAfterRiver, riverCard);
        int p2HandRank = Evaluator.getHandRank(keyOfPlayer2HandAfterRiver);


        if (p1HandRank > p2HandRank) {

            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = 100" + "% Draw = 0%");
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = 0" + "% Draw = 0%");
        }
        if (p1HandRank < p2HandRank) {

            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = 0" + "% Draw = 0%");
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = 100" + "% Draw = 0%");
        }
        if (p1HandRank == p2HandRank) {

            TextView tv1 = (TextView) findViewById(R.id.resultPlayer1);
            tv1.setText("Win = 0" + "% Draw = 100%");
            TextView tv2 = (TextView) findViewById(R.id.resultPlayer2);
            tv2.setText("Win = 0" + "% Draw = 100%");
        }
    }
}