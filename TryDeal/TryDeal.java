//
//  TryDeal.java
//  TryDeal
//
//  Created by Peter Brown on Wed Apr 16 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.util.*;

public class TryDeal {

    public static void main (String args[]) {

		CardDeck deck = new CardDeck();

		deck.shuffle();

		Hand myHand = deck.dealHand(5);
		Hand yourHand = deck.dealHand(5);

		System.out.println("\nMy hand is " + myHand);
		System.out.println("\nYour hand is " + yourHand);
    }
}
