import java.util.ArrayList;
import java.util.List;

public class Game {

    private Boolean unsolvable;
    private List<Card> setup;
    private List<Card> deck;
    private Card topDeckCard;
    private String sequence;

    public Game(String setupString, String deckString){
        this.unsolvable = false;
        this.setup = new ArrayList<Card>();
        this.deck = new ArrayList<Card>();
        String[] setupParts = setupString.split(" ");
        String[] deckParts = deckString.split(" ");
        CardSetup cardSetup = new CardSetup();
        cardSetup.setupCards(setup, deck, setupParts, deckParts);
        this.topDeckCard = deck.get(0);
        this.deck.remove(topDeckCard);
        this.sequence = "";
    }

    public Card getTopCard(){
        return topDeckCard;
    }

    public void setTopCard(Card topCard){
        this.topDeckCard = topCard;
    }

    public boolean getUnsolvable(){
        return unsolvable;
    }

    public void setUnsolvable(boolean unsolvable){
        this.unsolvable = unsolvable;
    }

    public String getSequence(){
        return sequence;
    }

    public void setSequence(String sequence){
        this.sequence = sequence;
    }

    public List<Card> getSetup(){
        return setup;
    }

    public List<Card> getDeck(){
        return deck;
    }

}

