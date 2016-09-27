package holdemcalc.evaluator;


//"Cactus Kev's Five-Card 
// Poker Hand Evaluator"

import holdemcalc.lookup.Flushes;
import holdemcalc.lookup.Products;
import holdemcalc.lookup.Unique;
import holdemcalc.lookup.Values;

public class Evaluator {

	/* Cards mapped to numbers:
  
	
   2c =  1    2d =  2    2h =  3    2s =  4
   3c =  5    3d =  6    3h =  7    3s =  8
   4c =  9    4d = 10    4h = 11    4s = 12
   5c = 13    5d = 14    5h = 15    5s = 16
   6c = 17    6d = 18    6h = 19    6s = 20
   7c = 21    7d = 22    7h = 23    7s = 24
   8c = 25    8d = 26    8h = 27    8s = 28
   9c = 29    9d = 30    9h = 31    9s = 32
   Tc = 33    Td = 34    Th = 35    Ts = 36
   Jc = 37    Jd = 38    Jh = 39    Js = 40
   Qc = 41    Qd = 42    Qh = 43    Qs = 44
   Kc = 45    Kd = 46    Kh = 47    Ks = 48
   Ac = 49    Ad = 50    Ah = 51    As = 52

	*/

    public final static int NUM_SUITS = 4;
    public final static int NUM_RANKS = 13;
    public final static int NUM_CARDS = 52;
    public static boolean verbose = true;
    private static int[] hand;                                // re-usable array to hold cards in a hand
    private static int numCards = 0;                    // re-usable counter for number of cards in a hand
    private static int cardIndex = 0;                    // re-usable index for cards in a hands

    //Key to rapresent a poker hand
    public static long makeKey(long baseKey, int newCard) {

        int[] suitCount = new int[NUM_SUITS + 1];    // number of times a suit appears in a hand
        int[] rankCount = new int[NUM_RANKS + 1];    // number of times a rank appears in a hand
        hand = new int[8];

        // extract the hand represented by the key value
        for (cardIndex = 0; cardIndex < 6; cardIndex++) {

            // hand[0] is used to hold the new card
            hand[cardIndex + 1] = (int) ((baseKey >>> (8 * cardIndex)) & 0xFF);
        }

        hand[0] = formatCard8bit(newCard);

        // examine the hand to determine number of cards and rank/suit counts
        for (numCards = 0; hand[numCards] != 0; numCards++) {
            suitCount[hand[numCards] & 0xF]++;
            rankCount[(hand[numCards] >>> 4) & 0xF]++;

            // check to see if new card is already contained in hand (rank and suit considered)
            if (numCards != 0 && hand[0] == hand[numCards]) {
                return 0;
            }
        }

        // check to see if we already have four of a particular rank
        if (numCards > 4) {
            for (int rank = 1; rank < 14; rank++) {
                if (rankCount[rank] > 4) return 0;
            }
        }

        // determine the minimum number of suits required for a flush to be possible
        int minSuitCount = numCards - 2;

        // check to see if suit is significant
        if (minSuitCount > 1) {
            // examine each card in the hand
            for (cardIndex = 0; cardIndex < numCards; cardIndex++) {
                // if the suit is not significant then strip it from the card
                if (suitCount[hand[cardIndex] & 0xF] < minSuitCount) {
                    hand[cardIndex] &= 0xF0;
                }
            }
        }

        sortHand();

        long key = 0;
        for (int i = 0; i < 7; i++) {
            key += (long) hand[i] << (i * 8);
        }

        return key;

    }

    public static int formatCard8bit(int card) {

        // 8-Bit Packed Card Representation
        // +--------+
        // |rrrr--ss| 11010001
        // +--------+
        // r = rank of card		(deuce = 1, trey = 2, four = 3, five = 4,..., ace = 13)
        // s = suit of card		(suits are arbitrary, can take value from 0 to 3)

        card--;
        return (((card >>> 2) + 1) << 4) + (card & 3) + 1;

    }

    // Sorts the hand using Bose-Nelson Sorting Algorithm (N = 7).
    public static void sortHand() {
        swapCard(0, 4);
        swapCard(1, 5);
        swapCard(2, 6);
        swapCard(0, 2);
        swapCard(1, 3);
        swapCard(4, 6);
        swapCard(2, 4);
        swapCard(3, 5);
        swapCard(0, 1);
        swapCard(2, 3);
        swapCard(4, 5);
        swapCard(1, 4);
        swapCard(3, 6);
        swapCard(1, 2);
        swapCard(3, 4);
        swapCard(5, 6);
    }

    // Swaps card i with card j.
    public static void swapCard(int i, int j) {
        if (hand[i] < hand[j]) {
            hand[i] ^= hand[j];
            hand[j] ^= hand[i];
            hand[i] ^= hand[j];
        }
    }

    public static int getHandRank(long key) {

        // The following method implements a modified version of "Cactus Kev's Five-Card
        // Poker Hand Evaluator" to determine the relative strength of two five-card hands.
        // Reference: http://www.suffecool.net/poker/evaluator.html

        hand = new int[8];
        int currentCard;
        int rank;
        int handRank = 9999;
        int holdrank = 9999;
        int suit = 0;
        int numCards = 0;

        final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};

        if (key != 0) {

            for (cardIndex = 0; cardIndex < 7; cardIndex++) {

                currentCard = (int) ((key >>> (8 * cardIndex)) & 0xFF);
                if (currentCard == 0) break;
                numCards++;

                // Cactus Kev Card Representation
                // +--------+--------+--------+--------+
                // |xxxbbbbb|bbbbbbbb|cdhsrrrr|xxpppppp|
                // +--------+--------+--------+--------+
                // p    = prime number of rank (deuce = 2, trey = 3, four = 5, five = 7,..., ace = 41)
                // r    = rank of card         (deuce = 0, trey = 1, four = 2, five = 3,..., ace = 12)
                // cdhs = suit of card
                // b    = bit turned on depending on rank of card

                // extract suit and rank from 8-bit packed representation
                rank = (currentCard >>> 4) - 1;
                suit = currentCard & 0xF;

                // change card representation to Cactus Kev Representation
                hand[cardIndex] = primes[rank] | (rank << 8) | (1 << (suit + 11)) | (1 << (16 + rank));
            }

            switch (numCards) {
                case 5:

                    holdrank = eval_5hand(hand[0], hand[1], hand[2], hand[3], hand[4]);
                    break;

                case 6:

                    // Cactus Kev's Evaluator ranks hands from 1 (Royal Flush) to 7462 (Seven High Card)
                    holdrank = eval_5hand(hand[0], hand[1], hand[2], hand[3], hand[4]);
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[1], hand[2], hand[3], hand[5]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[1], hand[2], hand[4], hand[5]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[1], hand[3], hand[4], hand[5]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[2], hand[3], hand[4], hand[5]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[1], hand[2], hand[3], hand[4], hand[5]));
                    break;

                case 7:

                    holdrank = eval_5hand(hand[0], hand[1], hand[2], hand[3], hand[4]);
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[1], hand[2], hand[3], hand[5]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[1], hand[2], hand[3], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[1], hand[2], hand[4], hand[5]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[1], hand[2], hand[4], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[1], hand[2], hand[5], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[1], hand[3], hand[4], hand[5]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[1], hand[3], hand[4], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[1], hand[3], hand[5], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[1], hand[4], hand[5], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[2], hand[3], hand[4], hand[5]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[2], hand[3], hand[4], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[2], hand[3], hand[5], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[2], hand[4], hand[5], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[0], hand[3], hand[4], hand[5], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[1], hand[2], hand[3], hand[4], hand[5]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[1], hand[2], hand[3], hand[4], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[1], hand[2], hand[3], hand[5], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[1], hand[2], hand[4], hand[5], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[1], hand[3], hand[4], hand[5], hand[6]));
                    holdrank = Math.min(holdrank, eval_5hand(hand[2], hand[3], hand[4], hand[5], hand[6]));
                    break;

                default:

                    System.out.println("ERROR: Invalid hand in GetRank method.");
                    break;

            }

            // Hand Rank Representation
            // +--------+--------+
            // |hhhheeee|eeeeeeee|
            // +--------+--------+
            // h    = poker hand	    (1 = High Card, 2 = One Pair, 3 = Two Pair,..., 9 = Straight Flush)				
            // e    = equivalency class (Rank of equivalency class relative to base hand)

            // +-----------------------------------+----------------------------------+-----------------+
            // 		5-Card Equivalency Classes			7-Card Equivalency Classes
            // +-----------------------------------+----------------------------------+-----------------+
            //  	        1277      							 407					High Card
            //				2860 								1470					One Pair
            //				 858 								 763					Two Pair
            //				 858 								 575					Three of a Kind
            //				  10 								  10					Straight
            //				1277 								1277					Flush
            //				 156 								 156					Full House
            //				 156 								 156					Four of a Kind
            //				  10								  10					Straight Flush
            // +----------+------------------------+----------------------------------+-----------------+
            //    Total:    7462								4824
            // +----------+------------------------+----------------------------------+-----------------+

            handRank = 7463 - holdrank;  // Invert ranking metric (1 is now worst hand)
                      														          
            /* handRank < 1278       // Visoka Karta 
            handRank < 4138         // Par 
           handRank < 4996         // Dva para
           handRank < 5854 //Tris
           handRank < 5864 // Skala   
           handRank < 7141 // Boja  
            handRank < 7297 // Full House    
            handRank < 7453 // Poker    
            handRank  // Skala u boji     */

        }
        return handRank;

    }


    public static int getIndex(int key) {

        // use binary search to find key
        int low = -1;
        int high = 4888;
        int pivot;

        while (high - low > 1) {
            pivot = (low + high) >>> 1;
            if (Products.table[pivot] > key) {
                high = pivot;
            } else if (Products.table[pivot] < key) {
                low = pivot;
            } else {
                return pivot;
            }
        }
        return -1;

    }

    private static int eval_5hand(int c1, int c2, int c3, int c4, int c5) {
        int q = (c1 | c2 | c3 | c4 | c5) >> 16;
        short s;

        // check for Flushes and Straight Flushes
        if ((c1 & c2 & c3 & c4 & c5 & 0xF000) != 0) return Flushes.table[q];

        // check for Straights and High Card hands
        if ((s = Unique.table[q]) != 0) return s;

        q = (c1 & 0xFF) * (c2 & 0xFF) * (c3 & 0xFF) * (c4 & 0xFF) * (c5 & 0xFF);
        q = getIndex(q);

        return Values.table[q];

    }

}
	
