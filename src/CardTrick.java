/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author e201501404
 */
public class CardTrick {

    

    public static void main(String[] args) throws InterruptedException {

        ArrayList deckunshuffled = new ArrayList();
        ArrayList deckshuffled = new ArrayList();
        ArrayList subset = new ArrayList();
        Scanner scan = new Scanner(System.in);
        String response = "Y";
        Random generator = new Random();
        int random = 0, set = 0;


        while (response.equalsIgnoreCase("Y")) {
            deckunshuffled.clear();
            deckshuffled.clear();
            subset.clear();

            for (int i = 2; i < 11; i++)
                deckunshuffled.add("♥" + i);

            deckunshuffled.add("♥J");
            deckunshuffled.add("♥Q");
            deckunshuffled.add("♥K");
            deckunshuffled.add("♥A");

            for (int i = 2; i < 11; i++)
                deckunshuffled.add("♦" + i);

            deckunshuffled.add("♦J");
            deckunshuffled.add("♦Q");
            deckunshuffled.add("♦K");
            deckunshuffled.add("♦A");

            for (int i = 2; i < 11; i++)
                deckunshuffled.add("♣" + i);

            deckunshuffled.add("♣J");
            deckunshuffled.add("♣Q");
            deckunshuffled.add("♣K");
            deckunshuffled.add("♣A");

            for (int i = 2; i < 11; i++)
                deckunshuffled.add("♠" + i);

            deckunshuffled.add("♠J");
            deckunshuffled.add("♠Q");
            deckunshuffled.add("♠K");
            deckunshuffled.add("♠A");


            System.out.println("Here is my new, unshuffled deck, so you can see I am legit:");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 13; j++)
                    System.out.print(deckunshuffled.get(i * 13 + j) + "\t");
                System.out.println();
            }//for

            System.out.println();
            System.out.println();
            Thread.sleep(4000);
            System.out.println("Please think of a card, any card.  I'll give you a few seconds...");
            Thread.sleep(6000);
            System.out.println();
            System.out.println();


            for (int i = deckunshuffled.size(); i > 0; i--) {
                random = generator.nextInt(i);
                deckshuffled.add((String) deckunshuffled.get(random));
                deckunshuffled.remove(random);
            }//for

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(deckshuffled.get(5 * i + j) + "\t");
                }//for j
                System.out.println();
                System.out.print("Is your card in this set?  Enter Y or N:  ");
                response = scan.next();
                System.out.println();

                if (response.equalsIgnoreCase("Y")) {
                    subset.add(deckshuffled.get(i * 5));
                    subset.add(deckshuffled.get(i * 5 + 1));
                    subset.add(deckshuffled.get(i * 5 + 2));
                    subset.add(deckshuffled.get(i * 5 + 3));
                    subset.add(deckshuffled.get(i * 5 + 4));
                    deckshuffled.remove(i * 5 + 4);
                    deckshuffled.remove(i * 5 + 3);
                    deckshuffled.remove(i * 5 + 2);
                    deckshuffled.remove(i * 5 + 1);
                    deckshuffled.remove(i * 5);
                    break;
                }//if
            }//for i

            if (subset.size() == 0) {
                subset.add(deckshuffled.get(50));
                subset.add(deckshuffled.get(51));
                subset.add(deckshuffled.get(0));
                subset.add(deckshuffled.get(1));
                subset.add(deckshuffled.get(2));
                deckshuffled.remove(51);
                deckshuffled.remove(50);
                deckshuffled.remove(2);
                deckshuffled.remove(1);
                deckshuffled.remove(0);

                for (int j = 0; j < 5; j++) {
                    System.out.print(subset.get(j) + "\t");
                }//for j
                System.out.println();
                System.out.print("We are at the end of the deck, so I know your card is somewhere in the set above.  ");
            }//

            System.out.println("Let's keep going!");
            Thread.sleep(2500);
            System.out.println();
            System.out.println("Please note, there is nothing up my sleeves...I don't even have arms!! ☻☺");
            Thread.sleep(2500);
            System.out.println();

            for (int i = deckshuffled.size(); i > 42; i--) {
                random = generator.nextInt(i);
                subset.add(0, (String) deckshuffled.get(random));
                deckshuffled.remove(random);
            }//for

            for (int i = deckshuffled.size(); i > 37; i--) {
                random = generator.nextInt(i);
                subset.add(10, (String) deckshuffled.get(random));
                deckshuffled.remove(random);
            }//for


            for (int i = 15; i > 0; i--) {
                random = generator.nextInt(i);
                subset.add(subset.get(random));
                subset.remove(random);
            }//for

            System.out.print("Enter Y to shuffle:  ");
            response = scan.next();
            System.out.println();
            if (response.equalsIgnoreCase("Y"))
                System.out.println("Ok, I will shuffle my ♥ out!");
            else
                System.out.println("Ok, I'm going to shuffle anyway and take over the world.  <evil laugh>");

            Thread.sleep(3500);
            System.out.println();


            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 3; j++) {
                    System.out.print("Set " + (j + 1) + ":\t");

                    for (int k = 0; k < 15; k += 3) {
                        System.out.print(subset.get(j + k) + "\t");
                    }//j

                    System.out.println();
                }//for i
                System.out.println();
                System.out.print("Which set is your card in?  Enter 1, 2, or 3:  ");
                response = scan.next();
                set = Integer.parseInt(response);
                System.out.println();
                System.out.println();

                if (set == 1) {

                    for (int j = 0; j < 15; j += 3)
                        subset.add(subset.get(j + 1));

                    for (int j = 0; j < 15; j += 3)
                        subset.add(subset.get(j));

                    for (int j = 0; j < 15; j += 3)
                        subset.add(subset.get(j + 2));

                    for (int j = 0; j < 15; j++)
                        subset.remove(0);

                }//if set==1

                else if (set == 2) {

                    for (int j = 0; j < 15; j += 3)
                        subset.add(subset.get(j));

                    for (int j = 0; j < 15; j += 3)
                        subset.add(subset.get(j + 1));

                    for (int j = 0; j < 15; j += 3)
                        subset.add(subset.get(j + 2));

                    for (int j = 0; j < 15; j++)
                        subset.remove(0);

                }//if set==3

                else if (set == 3) {

                    for (int j = 0; j < 15; j += 3)
                        subset.add(subset.get(j));

                    for (int j = 0; j < 15; j += 3)
                        subset.add(subset.get(j + 2));

                    for (int j = 0; j < 15; j += 3)
                        subset.add(subset.get(j + 1));

                    for (int j = 0; j < 15; j++)
                        subset.remove(0);

                }//else if set=3

            }//for

            System.out.println();


            System.out.println("The card you picked was:  " + subset.get(7));
            System.out.println();
            Thread.sleep(2500);
            System.out.println("If not, you lied to me.  I wouldn't mess this up because I'm A COMPUTER...");
            Thread.sleep(2500);
            System.out.println();
            System.out.print("Would you like to try again?  Enter Y or N:  ");
            response = scan.next();
            System.out.println();

            if (response.equalsIgnoreCase("Y")) {
                System.out.println("Spoiler alert:  I'm going to know it this time too!");
                System.out.println();
                Thread.sleep(3500);
            }//if
            else {
                System.out.println("Suit yourself then.  Get it?  Suit yourself?!?  Cards?!?!  I'll be here all week!  It ain't easy being a machine!");
                System.out.println();
                System.out.println("Bye Felicia!");
            }
        }//endgame


    }//main

}
