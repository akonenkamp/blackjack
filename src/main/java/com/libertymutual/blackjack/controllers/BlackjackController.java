package com.libertymutual.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libertymutual.blackjack.models.Dealer;
import com.libertymutual.blackjack.models.Deck;
import com.libertymutual.blackjack.models.Hand;
import com.libertymutual.blackjack.models.Player;

@Controller
@RequestMapping("/blackjack") 
public class BlackjackController {
	Deck deck = new Deck();
	Player player1;
	Dealer dealer;
	int currentPot;
	boolean dontShowDealerCard;
	boolean doShowDealerCard;
	boolean doShowPlayerButtons;
	
	
	@GetMapping("")
	public String blackjackHome() {
		return "blackjack/start";
	}
	
	@GetMapping("/game") 
	public String blackjackhomemodel (Model model) {
		model.addAttribute("playerName" , player1.getName());
		model.addAttribute("walletAmount", player1.getWalletAmount());
		model.addAttribute("currentPot", currentPot);
		model.addAttribute("dealerCard1", dealer.hand.getCard(0).getVisualRep());
		model.addAttribute("dealerCard2", dealer.hand.getCard(1).getVisualRep());
		model.addAttribute("dontShowDealerCard", dontShowDealerCard);
		model.addAttribute("doShowDealerCard" , doShowDealerCard);
		model.addAttribute("playerCards", player1.hand.getAllCards());
		model.addAttribute("doShowPlayerButtons" , doShowPlayerButtons);
		//model.addAttribute("dealerCards" , null);
		return "blackjack/default";
		
	}
	
	@PostMapping ("/game/bet")
	public String makeBet(int playerBet, String playerName){
		Hand playerHand = new Hand();
		if (player1 == null) {
		player1 = new Player(playerName, playerHand, 100);
		}
		player1.makeBet(playerBet);
		currentPot += playerBet;
		dealer.hand.addCard(deck.dealCard());
		dealer.hand.addCard(deck.dealCard());
		player1.hand.addCard(deck.dealCard());
		player1.hand.addCard(deck.dealCard());
		dontShowDealerCard = true;
		doShowDealerCard = false;
		doShowPlayerButtons = true;
		return "redirect:/blackjack/game";
		
	}
	
	
	
	@PostMapping ("/game/start") 
	public String startingTheGame() {
		deck.shuffleDeck();
		
		Hand dealerHand = new Hand();
		player1 = null;
		dealer = new Dealer (dealerHand);
		currentPot = 0;
		return "blackjack/new-game-form";
	}

	@PostMapping ("/game/hit") 
	public String hitTheDeck() {
		int [] values = player1.hand.getValues();
		if (values[0] > 21 && values[1] > 21) {
			return "redirect:/blackjack/game/bust";
		} else {
			player1.hand.addCard(deck.dealCard());
			int values2[] = player1.hand.getValues();
			if (values2[0] > 21 && values2[1] > 21) {
				return "redirect:/blackjack/game/bust";
			} else {
				return "redirect:/blackjack/game"; 
			}
		}
		
	}
	
	@PostMapping ("game/stand") 
	public String stand() { 
		dealToDealer();
		return "blackjack/game/end-hand";
	}
	
	@GetMapping("/game/bust")
	public String busted(Model model) {
		currentPot = 0;
		player1.hand.clearHand();
		model.addAttribute("walletAmount", player1.getWalletAmount());
		model.addAttribute("messageToPlayer" , "you busted!");
		return "blackjack/end-hand";
	}
	
	private void dealToDealer() {
		int [] values = dealer.hand.getValues();
		while (values[0] < 17 && values[1] < 17) {
			dealer.hand.addCard(deck.dealCard());
			values = dealer.hand.getValues(); 
		}
	}
	
}
