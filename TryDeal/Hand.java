//
//  Hand.java
//  TryDeal
//
//  Created by Peter Brown on Wed Apr 16 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.util.*;

public class Hand {

	// Private variables

	private Stack hand = new Stack();

	// Public methods
	
	// Add a card
	public void add(Card card) {

		hand.push(card);

	}

	// Print Hand
	public String toString() {

		Iterator cards = hand.iterator();

		StringBuffer str = new StringBuffer();

		while(cards.hasNext()) {
			str.append(" " + cards.next());
		}

		return str.toString();

	}
	
}
