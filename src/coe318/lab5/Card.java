package coe318.lab5;
/**
 *
 * @author Sam Bondi, 500686504
 */
public class Card implements Comparable {
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;
  
  public int cardRank, cardSuit;
  public boolean cardPos;

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  //Constructor
  public Card(int rank, int suit, boolean faceUp) {
    cardRank = rank;
    cardSuit = suit;
    cardPos = faceUp;
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    return cardPos;
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    cardPos = faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return cardRank;
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return cardSuit;
  }
  
  //The java instanceof operator is used to test whether the object is an instance of the specified type 
  //(class or subclass or interface).
  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    if (c.getSuit() == this.cardSuit && c.getRank() == this.cardRank){
        return true;
    }
    return false;
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }

  //UNSURE OF DESIRED OUTPUT
  public int compareTo(Card c) {
    if (c.getRank() < cardRank || c.getRank() > cardRank){
        return c.getRank() - this.cardRank;
    }else{
        if(c.getSuit() < cardSuit){
            return c.getSuit() - this.getSuit();
        }
    }
    return 0;
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
    String newRank = "";
    if (cardRank <= 10){
        return ""+cardRank;//FIX THIS
    }else if (cardRank > 10){
        switch (cardRank) {
            case 11:
                newRank = "Jack";
                break;
            case 12:
                newRank = "Queen";
                break;
            case 13:
                newRank = "King";
                break;
            case 14:
                newRank = "Ace";
                break;
            default:
                break;
        }
    }
    return newRank;
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
    String newSuit = "";
    switch (cardSuit){
        case 0:
            newSuit = "Clubs";
            break;
        case 1:
            newSuit = "Diamonds";
            break;
        case 2:
            newSuit = "Hearts";
            break;
        case 3:
            newSuit = "Spades";
            break;
        default:
            break;
    }
    return newSuit;
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
    if (this.cardPos == true){
        return "" + getRankString() + " of " + getSuitString();
    }
    return "?";
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}