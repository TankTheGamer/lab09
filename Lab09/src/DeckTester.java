/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	static final String[] Card52Ranks = {"ace","two","three","four","five","six","seven","eight","nine","ten","jack","queen","king"};
	static final int[] Card52Value = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	static final String[] Card52Suit = {"Spade","Club","Heart","Diamond"};
	
	
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		Deck testDeck = new Deck( Card52Ranks, Card52Suit, Card52Value);
		
		System.out.println(testDeck.toString());
		
		testDeck.shuffle();
		
		System.out.println(testDeck.toString());
		
		
	}
}
