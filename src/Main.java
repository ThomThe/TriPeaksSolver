import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String setupString = "AH AD QD 9H JC 7H 4H AS 3S JD 8S 7C 6S 6H KC 3C QH 2D 5S TH KH QS 2S TC QC 9C AC 4C";
        String deckString = "7S 3H 8H 2H 9D KD JS 4D 6D TS 2C 6C JH KS 7D 5C 5H TD 5D 8D 4S 3D 8C 9S";
        HashMap<String, String> outcomes = new HashMap<String, String>();
        boolean solved = false;

        List<Card> setup = new ArrayList<Card>();
        List<Card> deck = new ArrayList<Card>();

        String[] setupParts = setupString.split(" ");
        String[] deckParts = deckString.split(" ");

        CardSetup cardSetup = new CardSetup();
        cardSetup.setupCards(setup, deck, setupParts, deckParts);

        Logger logger = new Logger();
        logger.logSetup(setup);

        Solver solver = new Solver(outcomes);

        while(!solved){
            List<Card> testSetup = new ArrayList<Card>();
            List<Card> testDeck = new ArrayList<Card>();
            cardSetup.createTestSetup(testSetup, testDeck, setup, deck);
            if(solver.solve(testSetup, testDeck)){
                solved = true;
                System.out.println("The game is solved! The solution was:");
                System.out.println(outcomes.get(outcomes.size() - 1));
                System.out.println("To solve the game the computer ran " + outcomes.size() + " simulations!");
            }
            solved = true;
        }


    }




}


