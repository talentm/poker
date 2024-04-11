package com.poker.card;

/**
 * @author Talent Mataba
 *
 * ICard interface for representing a playing card, which can be extended to support multiple types of cards
 */
public interface ICard
{
	String getSuit();

	String getRank();

	int getRankValue();
}