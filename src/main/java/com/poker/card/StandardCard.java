package com.poker.card;

/**
 * @author Talent Mataba
 */
public class StandardCard implements ICard, Comparable<StandardCard>
{
	private final String suit;
	private final String rank;

	public StandardCard(String suit, String rank)
	{
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String getSuit()
	{
		return suit;
	}

	@Override
	public String getRank()
	{
		return rank;
	}

	// Get the numerical value of the rank for comparison
	@Override
	public int getRankValue()
	{
		switch (rank)
		{
			case "Ace":
				return 14;
			case "King":
				return 13;
			case "Queen":
				return 12;
			case "Jack":
				return 11;
			default:
				return Integer.parseInt(rank);
		}
	}

	@Override
	public int compareTo(StandardCard other)
	{
		return Integer.compare(this.getRankValue(), other.getRankValue());
	}

	@Override
	public String toString()
	{
		return rank + " of " + suit;
	}

}