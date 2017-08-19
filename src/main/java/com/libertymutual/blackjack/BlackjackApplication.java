package com.libertymutual.blackjack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.libertymutual.blackjack.models.Card;
import com.libertymutual.blackjack.models.Dealer;
import com.libertymutual.blackjack.models.Deck;
import com.libertymutual.blackjack.models.FaceCard;
import com.libertymutual.blackjack.models.Hand;
import com.libertymutual.blackjack.models.Player;

@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackjackApplication.class, args);
		
//		Deck deck = new Deck();
//		deck.printThis();
//		deck.shuffleDeck();
//		deck.printThis();
//		Card card = deck.dealCard();
//		System.out.println(" ");
//		System.out.println(card.getVisualRep() + " " + card.getSuit());
//		
//	    Hand hand = new Hand();
//	    hand.addCard(deck.dealCard());
//	    hand.addCard(deck.dealCard());
//	    hand.addCard(deck.dealCard());
//	   
//	    int[] values = hand.getValues();
//	    System.out.println("Values: " + values[0] + "  ,  " + values[1]);
//	    
//	    Player player1 = new Player("amanda", hand, 100);
//	    int[] playerHandValues = player1.hand.getValues();
//	    System.out.println("PlayerName:" + player1.getName() + "wallet amount: " + player1.getWalletAmount() + "Players Hand:" + playerHandValues[0] + "," + playerHandValues[1]);
//	    player1.makeBet(5);
//	    System.out.println("PlayerName:" + player1.getName() + "wallet amount: " + player1.getWalletAmount() + "Players Hand:" + playerHandValues[0] + "," + playerHandValues[1]);
//
//	    
	}
}
