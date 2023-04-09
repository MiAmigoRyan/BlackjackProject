package com.skilldistillery.blackjack.entities;

public enum Rank {
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), 
	EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10),
	ACE(11);

	private int value;

	private Rank(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	

//    public String toString() {
//    	if (value == 11) {
//    		return "Ace";
//    	}else if (value == 10) {
//    		switch(){
//    		case JACK : return "Jack";
//    		case QUEEN : return "Queen";
//    		case KING : return "King";
//    		}
//    	}
//        return Integer.toString(value);
//    }
    }
