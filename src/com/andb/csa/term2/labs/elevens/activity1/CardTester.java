package com.andb.csa.term2.labs.elevens.activity1;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *
     * @param args is not used.
     */
    public static void main(String[] args) {
        Card card1 = new Card("this has terrible input verification", "honestly a bad class", 400000000);
        Card card2 = new Card("like what are the comments", "if a comment says only the type and the name", -4347834);
        Card card3 = new Card("then it's not useful", "what am i even doing", 1234567890);
        Card card3Dup = new Card("then it's not useful", "what am i even doing", 1234567890);

        System.out.println("Rank: " + card1.rank());
        System.out.println("Suit: " + card1.suit());
        System.out.println("Point Value: " + card1.pointValue());
        System.out.println(card1.toString());
        System.out.println("Rank: " + card2.rank());
        System.out.println("Suit: " + card2.suit());
        System.out.println("Point Value: " + card2.pointValue());
        System.out.println(card2.toString());
        System.out.println("Rank: " + card3.rank());
        System.out.println("Suit: " + card3.suit());
        System.out.println("Point Value: " + card3.pointValue());
        System.out.println(card3.toString());
        System.out.println("Unmatched: " + card1.matches(card2));
        System.out.println("Matched: " + card3.matches(card3Dup));
    }
}
