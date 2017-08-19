package com.libertymutual.blackjack.models;

public class NumberCard implements Card {
	
	private int value;
	private String suit;
	
	public NumberCard(int value, String suit ) {
		this.value = value;
		this.suit = suit;
	}
	
	public int[] getValues() {
		return new int[] { value, value};
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getVisualRep( ) {
		return String.valueOf(value);
	}

}
