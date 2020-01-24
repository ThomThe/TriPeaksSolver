import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Solver {

    GameModel game;
    public Solver(GameModel game){
        this.game = game;
    }

    public boolean solve(List<Card> setup, List<Card> deck, HashMap<String, String> outcomes){
        boolean stuck = false;
        boolean solved = false;
        List<Card> openCards = new ArrayList<Card>();
        //Set openCards
        for(int i = 0; i < setup.size(); i++){
            if(setup.get(i).getOpen()){
                openCards.add(setup.get(i));
            }
        }

        int piledCards = 0;
        int moves = 0;
        while(!stuck){
            if(tryPileCard(openCards, outcomes)){
                piledCards++;
                if(piledCards == 28){
                    solved = true;
                    stuck = true;
                }
                moves++;
                continue;
            }
            if(tryDrawCard(deck, openCards, outcomes)){
                moves++;
                continue;
            } else{
                if(moves < 2){
                   this.game.setUnsolvable(true);
                   solved = false;
                }
                stuck = true;
            }

        }



        outcomes.put(this.game.getSequence(), this.game.getSequence());
        return solved;
    }

    public boolean tryPileCard(List<Card> openCards, HashMap<String, String> outcomes){

        List<Card> possibleCards = new ArrayList<Card>();
        for(int i = 0; i < openCards.size(); i++){
            if(openCards.get(i).getNumber() == this.game.getTopCard().getConnectsWith().get(0) || openCards.get(i).getNumber() == this.game.getTopCard().getConnectsWith().get(1) ){
                possibleCards.add(openCards.get(i));
            }
        }
        boolean failed = false;

        while(!failed){
            if(possibleCards.size() != 0){
                int randomNum = ThreadLocalRandom.current().nextInt(0, possibleCards.size());
                //Check if sequence already tried
                String possibleSequence = this.game.getSequence() + "GetCard(" + possibleCards.get(randomNum).getCard() + ") ";
                if(outcomeExists(possibleSequence, outcomes)){
                    //Sequence already tried
                    possibleCards.remove(possibleCards.get(randomNum));
                    continue;
                }

                //sequence does not exist yet, so save it
                this.game.setSequence(possibleSequence);

                //Sequence not tried, so, unblock cards blocked by picked Card
                List<Card> blockedCards = possibleCards.get(randomNum).getBlocks();
                for(Card c : blockedCards){
                    c.removeBlockedBy(possibleCards.get(randomNum));
                    if(c.getOpen()){
                        openCards.add(c);
                    }
                }
                //Set card to closed because is now topdeckcard and when used needs to be closed to not be used again

                this.game.setTopCard(possibleCards.get(randomNum));
                possibleCards.get(randomNum).setOpen(false);
                openCards.remove(possibleCards.get(randomNum));

                return true;
            }
            else{
                failed = true;
            }
        }




        return false;
    }

    public boolean tryDrawCard(List<Card> deck, List<Card> openCards, HashMap<String, String> outcomes){
        if(deck.size() == 0){
            return false;
        }
        String possibleSequence = this.game.getSequence() + "DrawCard(" + deck.get(0).getCard() + ") ";
        if(outcomeExists(possibleSequence, outcomes)){
            //Sequence already tried
            return false;
        }
        this.game.setTopCard(deck.get(0));
        deck.remove(this.game.getTopCard());
        this.game.setSequence(possibleSequence);

        return true;
    }

    public boolean outcomeExists(String sequence, HashMap<String, String> outcomes){
        if(outcomes.get(sequence) == null){
            return false;
        }
        return true;
    }
}
