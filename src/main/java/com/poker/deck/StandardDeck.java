package com.poker.deck;

import com.poker.card.StandardCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Talent Mataba
 */
public class StandardDeck implements IDeck
{
	private final List<StandardCard> cards;

	public StandardDeck()
	{
		cards = new ArrayList<>();
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

		for (String suit : suits)
		{
			for (String rank : ranks)
			{
				cards.add(new StandardCard(suit, rank));
			}
		}
	}

	@Override
	public void shuffle()
	{
		Collections.shuffle(cards);
	}

	// Draw a card from the top of the deck
	@Override
	public StandardCard drawCard()
	{
		if (cards.isEmpty())
		{
			throw new IllegalStateException("Deck is empty");
		}
		return cards.remove(cards.size() - 1);
	}

	// Deal a specified number of cards from the deck
	@Override
	public List<StandardCard> dealCards(int numCards)
	{
		List<StandardCard> dealtCards = new ArrayList<>();
		for (int i = 0; i < numCards; i++)
		{
			dealtCards.add(drawCard());
		}
		return dealtCards;
	}
}