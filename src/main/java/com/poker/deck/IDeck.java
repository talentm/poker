package com.poker.deck;

import com.poker.card.StandardCard;

import java.util.List;

/**
 * @author Talent Mataba
 *
 * IDeck interface for managing a deck of playing cards with extensibility for different shuffling methods
 * and additional functionalities
 */
public interface IDeck
{
	void shuffle();

	StandardCard drawCard();

	List<StandardCard> dealCards(int numCards);
}