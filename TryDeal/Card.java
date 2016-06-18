//
//  Card.java
//  TryDeal
//
//  Created by Peter Brown on Wed Apr 16 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//

public class Card implements Comparable {

    // Suit constants
    public static final int HEARTS = 0;
    public static final int CLUBS = 1;
    public static final int DIAMONDS = 2;
    public static final int SPADES = 3;

    // Face constants
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    private int suit;
    private int value;

    // Constructor
    public Card(int value, int suit) throws IllegalArgumentException {

        if (value >= ACE && value <= KING) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Invalid card value");
        }

        if (suit >= HEARTS && suit <= SPADES) {
            this.suit = suit;
        } else {
            throw new IllegalArgumentException("Invalid suit");
        }

    }

    // String representation
    public String toString() {

        String cardString;

        switch(value) {
            case ACE: cardString = "A"; break;
			case JACK: cardString = "J"; break;
			case QUEEN: cardString = "Q"; break;
			case KING: cardString = "K"; break;
			default: cardString = Integer.toString(value); break;
		}

        switch(suit) {
            case HEARTS: cardString += "H"; break;
			case DIAMONDS: cardString += "D"; break;
			case CLUBS: cardString += "C"; break;
			case SPADES: cardString += "S"; break;
		}

		return cardString;

	}

	// Compare cards
	public int compareTo(Object card) {

		if (suit != ((Card)card).suit) {
			return suit < ((Card)card).suit ? -1 : 1;
		} else if (value == ((Card)card).value) {
			return 0;
		} else {
			return value < ((Card)card).value ? -1 : 1;
		}
		
	}


        
}
