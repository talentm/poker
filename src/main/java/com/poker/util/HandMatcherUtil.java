package com.poker.util;

import com.poker.card.StandardCard;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandMatcherUtil
{
	public String matchHand(List<StandardCard> hand)
	{
		Collections.sort(hand);

		if (isStraightFlush(hand))
		{
			return "Straight Flush";
		}
		else if (isFourOfAKind(hand))
		{
			return "Four of a Kind";
		}
		else if (isFullHouse(hand))
		{
			return "Full House";
		}
		else if (isFlush(hand))
		{
			return "Flush";
		}
		else if (isStraight(hand))
		{
			return "Straight";
		}
		else if (isThreeOfAKind(hand))
		{
			return "Three of a Kind";
		}
		else if (isTwoPair(hand))
		{
			return "Two Pair";
		}
		else if (isOnePair(hand))
		{
			return "One Pair";
		}
		else
		{
			return "High Card";
		}
	}

	/**
	 * Five consecutive cards of the same suit.
	 */
	private boolean isStraightFlush(List<StandardCard> hand)
	{
		return isStraight(hand) && isFlush(hand);
	}

	/**
	 * Four cards of the same rank.
	 */
	private boolean isFourOfAKind(List<StandardCard> hand)
	{
		Map<String, Integer> rankCount = new HashMap<>();
		for (StandardCard card : hand)
		{
			rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
		}
		return rankCount.containsValue(4);
	}

	/**
	 * Three cards of one rank and two cards of another rank.
	 */
	private boolean isFullHouse(List<StandardCard> hand)
	{
		Map<String, Integer> rankCount = new HashMap<>();
		for (StandardCard card : hand)
		{
			rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
		}
		return rankCount.containsValue(3) && rankCount.containsValue(2);
	}

	/**
	 * Five cards of the same suit.
	 */
	private boolean isFlush(List<StandardCard> hand)
	{
		String suit = hand.get(0).getSuit();
		return hand.stream().allMatch(card -> card.getSuit().equals(suit));
	}

	/**
	 * Five consecutive cards of mixed suits.
	 */
	private boolean isStraight(List<StandardCard> hand)
	{
		for (int i = 1; i < hand.size(); i++)
		{
			if (hand.get(i).getRankValue() != hand.get(i - 1).getRankValue() + 1)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Three cards of the same rank.
	 */
	private boolean isThreeOfAKind(List<StandardCard> hand)
	{
		Map<String, Integer> rankCount = new HashMap<>();
		for (StandardCard card : hand)
		{
			rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
		}
		return rankCount.containsValue(3);
	}

	/**
	 * Two sets of two cards of the same rank.
	 */
	private boolean isTwoPair(List<StandardCard> hand)
	{
		Map<String, Integer> rankCount = new HashMap<>();
		for (StandardCard card : hand)
		{
			rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
		}
		int pairs = 0;
		for (int count : rankCount.values())
		{
			if (count == 2)
			{
				pairs++;
			}
		}
		return pairs == 2;
	}

	/**
	 * Two cards of the same rank.
	 */
	private boolean isOnePair(List<StandardCard> hand)
	{
		Map<String, Integer> rankCount = new HashMap<>();
		for (StandardCard card : hand)
		{
			rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
		}
		return rankCount.containsValue(2);
	}
}
