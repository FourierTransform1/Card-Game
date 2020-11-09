import java.security.SecureRandom;
import java.util.Scanner;

public class Main {


    private Card[] deck = new Card[52];
    private static Main obj = new Main();
    private SecureRandom random = new SecureRandom();
    private Card[] shuffeledDeck = new Card[52];
    Scanner input = new Scanner(System.in);
    private int userScore = 0;
    private int machineScore = 0;


    public static void main(String[] args) {


        obj.deck = obj.createCards();
        obj.shuffleCards();
        obj.countResult();


    }


    private Card[] createCards() {

        int[] rank = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        String[] suite = {" Clubs", " Hearts", " Diamonds", " Spades"};
        int index = 0;

        for (int i = 0; i < suite.length; i++) {
            for (int j = 0; j < rank.length; j++) {

                deck[index] = new Card(rank[j], suite[i]);
                index++;
            }
        }
        return deck;
    }


    private Card[] shuffleCards() {

        for (int i = 0; i < 1000; i++) {
            int a = random.nextInt(52);
            int b = random.nextInt(52);

            Card original = deck[a];
            deck[a] = deck[b];
            deck[b] = original;
        }
        return deck;
    }


    private void checkArray() {
        for (Object a : deck) {
            System.out.println(a);
        }
    }


    private void countResult() {

        System.out.println("how many cards do you want to draw?");
        int count = input.nextInt();


        System.out.println("User picks: ");
        for (int i = 0; i < count; i++) {
            System.out.println(deck[i]);
            userScore += deck[i].getRank();
        }

        System.out.println();
        System.out.println("machine picks: ");
        for (int j = count; j < 2 * count; j++) {
            System.out.println(deck[j]);
            machineScore += deck[j].getRank();
        }

        System.out.println();
        System.out.printf("User score is: %d\n ", userScore);
        System.out.printf("Machine score is: %d \n", machineScore);


        if (userScore < machineScore) {
            System.out.println("User is the WINNER!");
        } else {
            System.out.println("machine is the WINNER!");
        }


    }
}
