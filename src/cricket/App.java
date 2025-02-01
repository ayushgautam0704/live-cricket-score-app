package cricket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        CricBuzz c = new CricBuzz();
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                           Menu 
                           1. Get Details of Live Matches 
                           2. If you already know matchID, press 2 
                            Enter your input ...""");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> c.printLiveMatches();
            case 2 -> {
                System.out.println("Enter the ID of the match, to see its score ...");
                String matchId = sc.next();
                c.printScoreOfSelectedMatch(matchId);
            }
            default -> throw new IllegalArgumentException(String.format("Choice %d is invalid", choice));
        }
        System.out.println("**********END OF PROGRAM**********");
    }
}