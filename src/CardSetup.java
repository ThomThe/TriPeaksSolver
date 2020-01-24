import java.util.List;

public class CardSetup {
    public void setupCards(List<Card> setup, List<Card> deck, String[] setupParts, String [] deckParts){

        for(int i = 0; i < setupParts.length; i++){
            Card card = new Card();
            card.setCard(setupParts[i]);
            if(i >= 18){
                card.setOpen(true);
            }
            setup.add(card);
        }

//Top Row
        setup.get(0).addBlockedBy(setup.get(3));
        setup.get(0).addBlockedBy(setup.get(4));
        setup.get(1).addBlockedBy(setup.get(5));
        setup.get(1).addBlockedBy(setup.get(6));
        setup.get(2).addBlockedBy(setup.get(7));
        setup.get(2).addBlockedBy(setup.get(8));

        setup.get(3).addBlocks(setup.get(0));
        setup.get(4).addBlocks(setup.get(0));
        setup.get(5).addBlocks(setup.get(1));
        setup.get(6).addBlocks(setup.get(1));
        setup.get(7).addBlocks(setup.get(2));
        setup.get(8).addBlocks(setup.get(2));

//Second row
        setup.get(3).addBlockedBy(setup.get(9));
        setup.get(3).addBlockedBy(setup.get(10));
        setup.get(4).addBlockedBy(setup.get(10));
        setup.get(4).addBlockedBy(setup.get(11));
        setup.get(5).addBlockedBy(setup.get(12));
        setup.get(5).addBlockedBy(setup.get(13));
        setup.get(6).addBlockedBy(setup.get(13));
        setup.get(6).addBlockedBy(setup.get(14));
        setup.get(7).addBlockedBy(setup.get(15));
        setup.get(7).addBlockedBy(setup.get(16));
        setup.get(8).addBlockedBy(setup.get(16));
        setup.get(8).addBlockedBy(setup.get(17));

        setup.get(9).addBlocks(setup.get(3));
        setup.get(10).addBlocks(setup.get(3));
        setup.get(10).addBlocks(setup.get(4));
        setup.get(11).addBlocks(setup.get(4));
        setup.get(12).addBlocks(setup.get(5));
        setup.get(13).addBlocks(setup.get(5));
        setup.get(13).addBlocks(setup.get(6));
        setup.get(14).addBlocks(setup.get(6));
        setup.get(15).addBlocks(setup.get(7));
        setup.get(16).addBlocks(setup.get(7));
        setup.get(16).addBlocks(setup.get(8));
        setup.get(17).addBlocks(setup.get(8));
//Third row
        setup.get(9).addBlockedBy(setup.get(18));
        setup.get(9).addBlockedBy(setup.get(19));
        setup.get(10).addBlockedBy(setup.get(19));
        setup.get(10).addBlockedBy(setup.get(20));
        setup.get(11).addBlockedBy(setup.get(20));
        setup.get(11).addBlockedBy(setup.get(21));
        setup.get(12).addBlockedBy(setup.get(21));
        setup.get(12).addBlockedBy(setup.get(22));
        setup.get(13).addBlockedBy(setup.get(22));
        setup.get(13).addBlockedBy(setup.get(23));
        setup.get(14).addBlockedBy(setup.get(23));
        setup.get(14).addBlockedBy(setup.get(24));
        setup.get(15).addBlockedBy(setup.get(24));
        setup.get(15).addBlockedBy(setup.get(25));
        setup.get(16).addBlockedBy(setup.get(25));
        setup.get(16).addBlockedBy(setup.get(26));
        setup.get(17).addBlockedBy(setup.get(27));

        setup.get(18).addBlocks(setup.get(9));
        setup.get(19).addBlocks(setup.get(9));
        setup.get(19).addBlocks(setup.get(10));
        setup.get(20).addBlocks(setup.get(10));
        setup.get(20).addBlocks(setup.get(11));
        setup.get(21).addBlocks(setup.get(11));
        setup.get(21).addBlocks(setup.get(12));
        setup.get(22).addBlocks(setup.get(12));
        setup.get(22).addBlocks(setup.get(13));
        setup.get(23).addBlocks(setup.get(13));
        setup.get(23).addBlocks(setup.get(14));
        setup.get(24).addBlocks(setup.get(14));
        setup.get(24).addBlocks(setup.get(15));
        setup.get(25).addBlocks(setup.get(15));
        setup.get(25).addBlocks(setup.get(16));
        setup.get(26).addBlocks(setup.get(16));
        setup.get(27).addBlocks(setup.get(17));



        for(int i = 0; i < deckParts.length; i++){
            Card card = new Card();
            card.setCard(deckParts[i]);
            if(i == 0){
                card.setTopDeck(true);
                card.setOpen(true);
            }
            else{
                card.setTopDeck(false);
                card.setOpen(false);
                card.addBlockedBy(deck.get(i - 1));
                deck.get(i-1).addBlocks(card);
            }
            deck.add(card);
        }
    }

    public Card deepCopy(Card input){
        Card copy = new Card();
        copy.setValue(input.getValue());//.. copy primitives, deep copy objects again

        return copy;
    }

    public void createTestSetup(List<Card> testSetup, List<Card> testDeck, List<Card> setup, List<Card> deck){
        for(int i = 0; i < setup.size(); i++){
            Card copy = this.deepCopy(setup.get(i));
            testSetup.add(copy);
        }
        for(int i = 0; i < deck.size(); i++){
            Card copy = this.deepCopy(deck.get(i));
            testDeck.add(copy);
        }
    }
}
