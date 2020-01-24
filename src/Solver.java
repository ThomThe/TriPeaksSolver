import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solver {

    HashMap<String, String> outcomes;

    public Solver(HashMap<String, String> outcomes){
        this.outcomes = outcomes;
    }

    public boolean solve(List<Card> setup, List<Card> deck){
        String sequence = "";
        boolean stuck = false;
        boolean solved = false;
        List<Card> openCards = new ArrayList<Card>();
        Card topDeckCard = deck.get(0);

        for(int i = 0; i < setup.size(); i++){
            if(setup.get(i).getOpen()){
                openCards.add(setup.get(i));
            }
        }


        while(!stuck){
            if(tryPileCard(openCards, topDeckCard, sequence)){
                continue;
            }
            if(tryDrawCard()){
                continue;
            } else{
                stuck = true;
            }

        }



        outcomes.put(sequence, sequence);
        return solved;
    }

    public boolean tryPileCard(List<Card> openCards, Card topDeckCard, String sequence){
        for(int i = 0; i < openCards.size(); i++){
            if(openCards.get(i).getNumber() == topDeckCard.getConnectsWith().get(0) || openCards.get(i).getNumber() == topDeckCard.getConnectsWith().get(1) ){

                Card card = openCards.get(i);
                //Check if sequence already tried
                String possibleSequence = sequence + "GetCard(" + card.getCard() + ") ";
                if(outcomeExists(possibleSequence)){
                    //Sequence already tried
                    continue;
                }

                //Sequence not tried, so, unblock cards blocked by picked Card
                List<Card> blockedCards = card.getBlocks();
                for(Card c : blockedCards){
                    c.removeBlockedBy(card);
                    if(c.getOpen()){
                        openCards.add(c);
                    }
                }
                //Set card to closed because is now topdeckcard and when used needs to be closed to not be used again
                card.setOpen(false);
                return true;
            }
        }
        return false;
    }

    public boolean tryDrawCard(){
         return true;
    }

    public boolean outcomeExists(String sequence){
        if(outcomes.get(sequence) == null){
            return false;
        }
        return true;
    }
}
