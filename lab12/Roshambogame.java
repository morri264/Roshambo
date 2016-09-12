package lab12;

public enum Roshambogame {
	ROCK,
	PAPER,
	SCISSORS;
	
	public String toString(){
		switch (this){
		case ROCK:
			return "Rock";
		case PAPER:
			return "Paper";
		case SCISSORS:
			return "Scissors";
		}
		return "Other";
		
	}
	
}