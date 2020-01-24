import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String setupString = "AH AD QD 9H JC 7H 4H AS 3S JD 8S 7C 6S 6H KC 3C QH 2D 5S TH KH QS 2S TC QC 9C AC 4C";
        String deckString = "7S 3H 8H 2H 9D KD JS 4D 6D TS 2C 6C JH KS 7D 5C 5H TD 5D 8D 4S 3D 8C 9S";


        HashMap<String, String> outcomes = new HashMap<String, String>();
        boolean solved = false;



//        Logger logger = new Logger();
//        logger.logSetup(setup);


        boolean unsolvable = false;
        int count = 0;
        while(!solved){
            List<Card> setup = new ArrayList<Card>();
            List<Card> deck = new ArrayList<Card>();

            String[] setupParts = setupString.split(" ");
            String[] deckParts = deckString.split(" ");

            CardSetup cardSetup = new CardSetup();
            cardSetup.setupCards(setup, deck, setupParts, deckParts);

            Card topDeckCard = deck.get(0);
            deck.remove(topDeckCard);
            String sequence = "";
            GameModel game = new GameModel();
            game.setSequence("");
            game.setTopCard(topDeckCard);
            game.setUnsolvable(false);
            Solver solver = new Solver(game);
            if(solver.solve(setup, deck, outcomes)){
                solved = true;
                System.out.println("The game is solved! The solution was:");
                String[] moves = game.getSequence().split(" ");
                for(int i = 0; i < moves.length; i++){
                    System.out.println(moves[i]);
                }
                System.out.println("To solve the game the computer ran " + outcomes.size() + " simulations!");
            }
            else{
                if(unsolvable){
                    System.out.println("The game is unsolvable!");
                    //System.out.println(outcomes.get(outcomes.size() - 1));
                    System.out.println("The computer ran " + outcomes.size() + " simulations!");
                    solved = true;
                }
                else{
                    //Clear Console
                    System.out.println("Try number " + outcomes.size());
                    System.out.println(game.getSequence());

                }
            }

        }


    }




}


