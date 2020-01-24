public class GameModel {
    private String sequence;

    private Card topDeckCard;

    private Boolean unsolvable;

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
}

