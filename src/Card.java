import java.util.ArrayList;
import java.util.List;

public class Card {


    private String card;

    private int number;

    private Boolean open;

    private Boolean topDeck;

    private List<Card> blocks;

    private List<Card> blockedBy;

    private List<Integer> connectsWith;

    public Card(){
        this.blocks = new ArrayList<Card>();
        this.blockedBy = new ArrayList<Card>();
        this.connectsWith = new ArrayList<Integer>();
        this.open = false;
        this.topDeck = false;
    }

    public void setCard(String card){
        this.card = card;
        String lvl = String.valueOf(card.charAt(0));
        if(lvl.equals("2")){
            this.setNumber(2);
            this.addConnectsWith(14);
            this.addConnectsWith(this.number + 1);
        }
        else if(lvl.equals("3")){
            this.setNumber(3);
            this.addConnectsWith(this.number - 1);
            this.addConnectsWith(this.number + 1);
        }
        else if(lvl.equals("4")){
            this.setNumber(4);
            this.addConnectsWith(this.number - 1);
            this.addConnectsWith(this.number + 1);
        }
        else if(lvl.equals("5")){
            this.setNumber(5);
            this.addConnectsWith(this.number - 1);
            this.addConnectsWith(this.number + 1);
        }
        else if(lvl.equals("6")){
            this.setNumber(6);
            this.addConnectsWith(this.number - 1);
            this.addConnectsWith(this.number + 1);
        }
        else if(lvl.equals("7")){
            this.setNumber(7);
            this.addConnectsWith(this.number - 1);
            this.addConnectsWith(this.number + 1);
        }
        else if(lvl.equals("8")){
            this.setNumber(8);
            this.addConnectsWith(this.number - 1);
            this.addConnectsWith(this.number + 1);
        }
        else if(lvl.equals("9")){
            this.setNumber(9);
            this.addConnectsWith(this.number - 1);
            this.addConnectsWith(this.number + 1);
        }
        else if(lvl.equals("T")){
            this.setNumber(10);
            this.addConnectsWith(this.number - 1);
            this.addConnectsWith(this.number + 1);
        }
        else if(lvl.equals("J")){
            this.setNumber(11);
            this.addConnectsWith(this.number - 1);
            this.addConnectsWith(this.number + 1);
        }
        else if(lvl.equals("Q")){
            this.setNumber(12);
            this.addConnectsWith(this.number - 1);
            this.addConnectsWith(this.number + 1);
        }
        else if(lvl.equals("K")){
            this.setNumber(13);
            this.addConnectsWith(this.number - 1);
            this.addConnectsWith(this.number + 1);
        }
        else if(lvl.equals("A")){
            this.setNumber(14);
            this.addConnectsWith(this.number - 1);
            this.addConnectsWith(2);
        }
    }

    public void addConnectsWith(int card){
        this.connectsWith.add(card);
    }

    public void addBlocks(Card card){
        this.blocks.add(card);
    }

    public void addBlockedBy(Card card){
        this.blockedBy.add(card);
    }

    public void removeBlockedBy(Card card){
        this.blockedBy.remove(card);
        if(this.blockedBy.size() == 0){
            this.open = true;
        }
    }

    public void setOpen(Boolean open){
        this.open = open;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    public void setTopDeck (Boolean topDeck){
        this.topDeck = topDeck;
    }

    public Boolean getOpen() {
        return this.open;
    }

    public Boolean getTopDeck() {
        return this.topDeck;
    }

    public String getCard() {
        return this.card;
    }

    public List<Card> getBlocks(){
        return this.blocks;
    }

    public List<Card> getBlockedBy(){
        return this.blockedBy;
    }

    public List<Integer> getConnectsWith(){
        return this.connectsWith;
    }

    public void setValue(Card card){
        this.setCard(card.getCard());

        this.open = card.getOpen();

        this.topDeck = card.getTopDeck();

        this.blocks = card.getBlocks();

        this.blockedBy = card.getBlockedBy();

        this.connectsWith = card.getConnectsWith();
    }

    public Card getValue(){
        return this;
    }

}
