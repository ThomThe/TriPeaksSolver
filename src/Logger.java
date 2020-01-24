import java.util.HashMap;
import java.util.List;

public class Logger {
    public void logSetup(List<Card> setup){
        for(int i = 0; i < setup.size(); i++){
            System.out.print(setup.get(i).getCard() + " Connects with(" + setup.get(i).getConnectsWith().get(0) + ", " +  setup.get(i).getConnectsWith().get(1) + ")");
        }
        System.out.println();
    }

    public void printWin(Game game, HashMap<String, String> outcomes){
        System.out.println("The game is solved! The solution was:");
        String[] moves = game.getSequence().split(" ");
        for (String move : moves) {
            System.out.println(move);
        }
        System.out.println("To solve the game the computer ran " + outcomes.size() + " simulations!");
    }

    public void printUnsolvable(HashMap<String, String> outcomes){
        System.out.println("The game is unsolvable!");
        System.out.println("The computer ran " + outcomes.size() + " simulations!");
    }

    public void printTry(Game game, HashMap<String, String> outcomes){
        System.out.println("Simulation " + outcomes.size());
        System.out.println(game.getSequence());
    }



}
