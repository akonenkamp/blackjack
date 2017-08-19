package com.libertymutual.blackjack.models;

public class Player {

	private String name;
	public Hand hand;
	private int wallet;
	
	public  Player(String name, Hand hand, int wallet) {
		this.name = name;
		this.hand = hand;
		this.wallet = wallet;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWalletAmount() {
		return wallet;
	}
	
	public void makeBet(int betAmount) {
		wallet -= betAmount;
	}
	
}
