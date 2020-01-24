import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Setup string is from the cards Top left to bottom right, first three are the top cards, next 6 the second row from the top and so on
        //Deck string is the cards from the deck, first is the one shown at the beginning of the came, after follow what gets turned from the deck
        String setupString = "AH AD QD 9H JC 7H 4H AS 3S JD 8S 7C 6S 6H KC 3C QH 2D 5S TH KH QS 2S TC QC 9C AC 4C";
        String deckString = "7S 3H 8H 2H 9D KD JS 4D 6D TS 2C 6C JH KS 7D 5C 5H TD 5D 8D 4S 3D 8C 9S";
        HashMap<String, String> outcomes = new HashMap<>();
        boolean solved = false;
        Logger logger = new Logger();

        while(!solved){
            Game game = new Game(setupString, deckString);
            Solver solver = new Solver(game, outcomes);
            if(solver.solve()){
                solved = true;
                logger.printWin(game, outcomes);
            }
            else{
                if(game.getUnsolvable()){
                    solved = true;
                    logger.printUnsolvable(outcomes);
                }
                else{
                    logger.printTry(game, outcomes);
                }
            }
        }
    }
}


