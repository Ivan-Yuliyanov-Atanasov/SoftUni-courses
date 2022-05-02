public class Card {

    private int power;
    private CardSuits suit;
    private CardRanks rank;

    public Card(CardSuits suit, CardRanks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getPower() {
        return this.suit.getValue() + this.rank.getValue();
    }
}
