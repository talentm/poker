package com.poker.game;

import com.poker.util.HandMatcherUtil;
import com.poker.card.StandardCard;
import com.poker.deck.IDeck;
import com.poker.deck.StandardDeck;

import java.util.List;
import java.util.Scanner;

/**
 * @author Talent Mataba
 */
public class PokerGame
{
    private static final int NUM_CARDS_TO_DEAL = 5;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter button to keep playing otherwise press any button and Enter");
        while (true)
        {
            // Create a standard deck
            IDeck deck = new StandardDeck();
            System.out.println("Shuffling ... Shuffling ... Shuffling ...");
            deck.shuffle();

            List<StandardCard> hand = deck.dealCards(NUM_CARDS_TO_DEAL);
            System.out.println("Your hand: " + hand);

            System.out.println("You have: " + new HandMatcherUtil().matchHand(hand));

            String input = scanner.nextLine();
            if (!input.equals(""))
            {
                System.out.println("Exit game!");
                break;
            }
        }
        // Close the scanner when done
        scanner.close();
    }
}
