import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by HP on 11/2/2016.
 */
public class Game {
    private static ArrayList<Integer> deck = new ArrayList<>(40);
    private static int discard;
    private static ArrayList<Integer> player1 = new ArrayList<>(10);
    private static ArrayList<Integer> player2 = new ArrayList<>(10);
    private static Random rng = new Random();
    static {
        for(int i = 0; i < 40; i++){
            int card;
            do {
                card = rng.nextInt(40)+1;
            } while(deck.contains(card));
            deck.add(card);
        }
        for(int i = 0; i < 20; i++){
            if(i%2 == 0){
                player1.add(deck.remove(i%10));
            } else player2.add(deck.remove(i%10));
        }
        draw();
    }

    public static void draw(){
        discard = deck.remove(0);
    }

    public static void swapCard(int player, int swapNum){
        int temp = discard;
        discard = swapNum;
        if(player == 1){
            player1.set(player1.indexOf(swapNum), temp);
        } else if(player == 2){
            player2.set(player2.indexOf(swapNum), temp);
        }
    }

    public static boolean areAllTrue(boolean[] array)
    {
        for(boolean b : array) if(!b) return false;
        return true;
    }

    public static void printPlayer(int player){
        if(player == 1){
            for(Integer card : player1){
                System.out.print(card.toString() + " ");
            }
        } else if(player == 2){
            for(Integer card : player2){
                System.out.print(card.toString() + " ");
            }
        }
        System.out.println();
    }

    public static int gameOver(){
        boolean[] player1compare = new boolean[player1.size()-1];
        boolean[] player2compare = new boolean[player2.size()-1];
        for(int i = 1; i < player1.size(); i++){
            player1compare[i-1] = (player1.get(i) > player1.get(i-1));
        }
        for(int i = 1; i < player2.size(); i++){
            player2compare[i-1] = (player2.get(i) > player2.get(i-1));
        }

        if(areAllTrue(player1compare)) return 1;
        if(areAllTrue(player2compare)) return 2;
        return 0;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String decision = "";
        System.out.print("Player 1, your cards are: ");
        printPlayer(1);
        System.out.println("The current card on the discard pile is: " + discard);
        System.out.print("Would you like to swap or draw a new card? swap/draw: ");
        decision = input.next().trim().toLowerCase();
        if(decision.equalsIgnoreCase("swap")){
            System.out.print("\nWhich card would you like to swap? (Enter the card's value): ");
            swapCard(1,input.nextInt());
            System.out.print("Your cards are now: ");
            printPlayer(1);
        } else if(decision.equalsIgnoreCase("draw")){
            draw();
            System.out.println("\nThe drawn card is: " + discard);
            System.out.print("Would you like to swap or discard the card? swap/draw: ");
            decision = input.next().trim().toLowerCase();

        }
        printPlayer(2);

    }
}
