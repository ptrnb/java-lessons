//
//  CardDeck.java
//  TryDeal
//
//  Created by Peter Brown on Wed Apr 16 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.util.*;

public class CardDeck {

	// Private variables
	private Stack deck = new Stack();

	// Public methods
	
	// Create a deck of 52 cards
	public CardDeck() {

		for (int theSuit = Card.HEARTS; theSuit <= Card.SPADES; theSuit++) {
			for (int theValue = Card.ACE; theValue <= Card.KING; theValue++) {
				deck.push(new Card(theValue, theSuit));
			}
		}

	}

	// Deal the hand
	public Hand dealHand(int numCards) {

		Hand hand = new Hand();

		for (int i = 0; i < numCards; i++) {
			hand.add((Card)deck.pop());
		}
		return hand;

	}

	// Shuffle
	public void shuffle() {

		Collections.shuffle(deck);

	}
}
