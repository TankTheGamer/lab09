package lab09;
import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		Boolean toReturn = false;
		if(selectedCards.size() == 2){
			System.out.println(cardAt(selectedCards.get(0)).pointValue() + " " + cardAt(selectedCards.get(1)).pointValue());
			return cardAt(selectedCards.get(0)).pointValue() + cardAt(selectedCards.get(1)).pointValue() == 11 ;
		}else if(selectedCards.size() == 3){
			return cardAt(selectedCards.get(0)).pointValue() + cardAt(selectedCards.get(1)).pointValue() + cardAt(selectedCards.get(2)).pointValue() == 0;
		}
			return false;

	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		List<Integer> toUse = cardIndexes();
		boolean toReturn = containsPairSum11(toUse) || containsJQK(toUse);
		System.out.println(toReturn);
		return toReturn;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		for(int i = 0; i < selectedCards.size(); i++){
			for(int s = 0; s < selectedCards.size(); s++){
				if(i!=s){
					if(cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(s)).pointValue() == 11){
						return true;
					}
				}
			}
		}
		
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		for(int i = 0; i < cardIndexes().size(); i++){
			for(int s = 0; s < cardIndexes().size(); s++){
				for(int x = 0; x < cardIndexes().size(); x++){
					if(i!=s && i != x && s!=x){
						if(cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(s)).pointValue() + cardAt(selectedCards.get(x)).pointValue() == 0 &&
								!cardAt(selectedCards.get(i)).rank().equals(cardAt(selectedCards.get(s)).rank()) && !cardAt(selectedCards.get(i)).rank().equals(cardAt(selectedCards.get(x)).rank()) && !cardAt(selectedCards.get(s)).rank().equals(cardAt(selectedCards.get(x)).rank())     ){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
