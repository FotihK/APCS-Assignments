package RackO;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by HP on 11/2/2016.
 */
public class Game {

    private static final int DECK_SIZE = 40;

    private static final ArrayList<Integer> deck = new ArrayList<>(DECK_SIZE);
    private static int discard;
    private static final ArrayList<Integer> player1 = new ArrayList<>(10);
    private static final ArrayList<Integer> player2 = new ArrayList<>(10);
    private static final Random RNG = new Random();

    public static void setup(){
        for (int i = 0; i < DECK_SIZE; i++) {
            int card;
            do {
                card = RNG.nextInt(DECK_SIZE) + 1;
            } while (deck.contains(card));
            deck.add(card);
        }
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                player1.add(deck.remove(i % 10));
            } else {
                player2.add(deck.remove(i % 10));
            }
        }
        draw();
        System.out.println("Let's begin the game of Rack-O!\n\n");
    }

    public static void draw() {
        discard = deck.remove(0);
    }

    public static void swapCard(int player, int swapNum) {
        int temp = discard;
        discard = swapNum;
        if (player == 1) {
            player1.set(player1.indexOf(swapNum), temp);
        } else if (player == 2) {
            player2.set(player2.indexOf(swapNum), temp);
        }
    }

    public static boolean areAllTrue(boolean[] array) {
        for (boolean b : array) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public static void printPlayer(int player) {
        if (player == 1) {
            player1.forEach((card) -> {
                System.out.print(card.toString() + " ");
            });
        } else if (player == 2) {
            player2.forEach((card) -> {
                System.out.print(card.toString() + " ");
            });
        }
        System.out.println();
    }

    public static int gameOver() {
        boolean[] player1compare = new boolean[player1.size() - 1];
        boolean[] player2compare = new boolean[player2.size() - 1];
        for (int i = 1; i < player1.size(); i++) {
            player1compare[i - 1] = (player1.get(i) > player1.get(i - 1));
        }
        for (int i = 1; i < player2.size(); i++) {
            player2compare[i - 1] = (player2.get(i) > player2.get(i - 1));
        }

        if (areAllTrue(player1compare)) {
            return 1;
        }
        if (areAllTrue(player2compare)) {
            return 2;
        }
        return 0;
    }

    public static void playTurn(int player, boolean deckEmpty) throws InterruptedException {
        String decision;
        Scanner input = new Scanner(System.in);
        System.out.print("Player " + player + ", your cards are: ");
        printPlayer(player);
        System.out.println("The current card on the discard pile is: " + discard);
        if (!deckEmpty) {
            System.out.print("Would you like to swap or draw a new card? swap/draw: ");
            decision = input.next().trim().toLowerCase();
            if (decision.equals("swap")) {
                System.out.print("Which card would you like to swap? (Enter the card's value): ");
                swapCard(player, input.nextInt());
                System.out.print("Your cards are now: ");
                printPlayer(player);
                Thread.sleep(2500);
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            } else {
                draw();
                System.out.println("The drawn card is: " + discard);
                System.out.print("Would you like to swap or discard the card? swap/discard: ");
                decision = input.next().trim().toLowerCase();
                if (decision.equals("swap")) {
                    System.out.print("Which card would you like to swap? (Enter the card's value): ");
                    swapCard(player, input.nextInt());
                    System.out.print("Your cards are now: ");
                    printPlayer(player);
                    Thread.sleep(2500);
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                } else {
                    System.out.println("Okay then!\n\n\n\n\n\n\n\n\n\n\n\n");
                }
            }
        } else {
            System.out.print("Which card would you like to swap? (Enter the card's value): ");
            swapCard(player, input.nextInt());
            System.out.print("Your cards are now: ");
            printPlayer(player);
            Thread.sleep(2500);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        }
        if(gameOver() == 0) System.out.println(player == 1 ? "Player 2's turn!" : "Player 1's turn!");
        else System.out.println("Player " + gameOver() + " has won! Conglaturations!");
        
    }

    public static void main(String[] args) throws InterruptedException {
        setup();
        while (gameOver() == 0) {
            playTurn(1, !(deck.size() > 0)); 
            playTurn(2, !(deck.size() > 0));
        }

    }
}
