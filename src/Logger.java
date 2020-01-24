import java.util.List;

public class Logger {
    public void logSetup(List<Card> setup){
        for(int i = 0; i < setup.size(); i++){
            System.out.print(setup.get(i).getCard() + " Connects with(" + setup.get(i).getConnectsWith().get(0) + ", " +  setup.get(i).getConnectsWith().get(1) + ")");
        }
        System.out.println();
    }
}
