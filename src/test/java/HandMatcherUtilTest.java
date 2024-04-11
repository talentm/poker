import com.poker.card.StandardCard;
import com.poker.util.HandMatcherUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Talent Mataba
 */
public class HandMatcherUtilTest
{
	@Test
	public void testStraightFlush()
	{
		List<StandardCard> hand = new ArrayList<>();
		hand.add(new StandardCard("Hearts", "10"));
		hand.add(new StandardCard("Hearts", "Jack"));
		hand.add(new StandardCard("Hearts", "Queen"));
		hand.add(new StandardCard("Hearts", "King"));
		hand.add(new StandardCard("Hearts", "Ace"));

		HandMatcherUtil matcher = new HandMatcherUtil();
		String result = matcher.matchHand(hand);

		assertEquals("Straight Flush", result);
	}

	@Test
	public void testFourOfAKind()
	{
		List<StandardCard> hand = new ArrayList<>();
		hand.add(new StandardCard("Hearts", "Ace"));
		hand.add(new StandardCard("Spades", "Ace"));
		hand.add(new StandardCard("Clubs", "Ace"));
		hand.add(new StandardCard("Diamonds", "Ace"));
		hand.add(new StandardCard("Hearts", "10"));

		HandMatcherUtil matcher = new HandMatcherUtil();
		String result = matcher.matchHand(hand);

		assertEquals("Four of a Kind", result);
	}

	@Test
	public void testFullHouse()
	{
		List<StandardCard> hand = new ArrayList<>();
		hand.add(new StandardCard("Hearts", "Ace"));
		hand.add(new StandardCard("Spades", "Ace"));
		hand.add(new StandardCard("Clubs", "Ace"));
		hand.add(new StandardCard("Diamonds", "King"));
		hand.add(new StandardCard("Hearts", "King"));

		HandMatcherUtil matcher = new HandMatcherUtil();
		String result = matcher.matchHand(hand);

		assertEquals("Full House", result);
	}

	@Test
	public void testFlush()
	{
		List<StandardCard> hand = new ArrayList<>();
		hand.add(new StandardCard("Hearts", "Ace"));
		hand.add(new StandardCard("Hearts", "10"));
		hand.add(new StandardCard("Hearts", "8"));
		hand.add(new StandardCard("Hearts", "6"));
		hand.add(new StandardCard("Hearts", "4"));

		HandMatcherUtil matcher = new HandMatcherUtil();
		String result = matcher.matchHand(hand);

		assertEquals("Flush", result);
	}

	@Test
	public void testStraight()
	{
		List<StandardCard> hand = new ArrayList<>();
		hand.add(new StandardCard("Hearts", "7"));
		hand.add(new StandardCard("Spades", "8"));
		hand.add(new StandardCard("Clubs", "9"));
		hand.add(new StandardCard("Diamonds", "10"));
		hand.add(new StandardCard("Hearts", "Jack"));

		HandMatcherUtil matcher = new HandMatcherUtil();
		String result = matcher.matchHand(hand);

		assertEquals("Straight", result);
	}

	@Test
	public void testThreeOfAKind()
	{
		List<StandardCard> hand = new ArrayList<>();
		hand.add(new StandardCard("Hearts", "Ace"));
		hand.add(new StandardCard("Spades", "Ace"));
		hand.add(new StandardCard("Clubs", "Ace"));
		hand.add(new StandardCard("Diamonds", "King"));
		hand.add(new StandardCard("Hearts", "10"));

		HandMatcherUtil matcher = new HandMatcherUtil();
		String result = matcher.matchHand(hand);

		assertEquals("Three of a Kind", result);
	}

	@Test
	public void testTwoPair()
	{
		List<StandardCard> hand = new ArrayList<>();
		hand.add(new StandardCard("Hearts", "Ace"));
		hand.add(new StandardCard("Spades", "Ace"));
		hand.add(new StandardCard("Clubs", "King"));
		hand.add(new StandardCard("Diamonds", "King"));
		hand.add(new StandardCard("Hearts", "10"));

		HandMatcherUtil matcher = new HandMatcherUtil();
		String result = matcher.matchHand(hand);

		assertEquals("Two Pair", result);
	}

	@Test
	public void testOnePair()
	{
		List<StandardCard> hand = new ArrayList<>();
		hand.add(new StandardCard("Hearts", "Ace"));
		hand.add(new StandardCard("Spades", "Ace"));
		hand.add(new StandardCard("Clubs", "King"));
		hand.add(new StandardCard("Diamonds", "Queen"));
		hand.add(new StandardCard("Hearts", "10"));

		HandMatcherUtil matcher = new HandMatcherUtil();
		String result = matcher.matchHand(hand);

		assertEquals("One Pair", result);
	}

	@Test
	public void testHighCard() {
		List<StandardCard> hand = new ArrayList<>();
		hand.add(new StandardCard("Diamonds", "9"));
		hand.add(new StandardCard("Clubs", "Jack"));
		hand.add(new StandardCard("Spades", "4"));
		hand.add(new StandardCard("Diamonds", "King"));
		hand.add(new StandardCard("Diamonds", "2"));

		HandMatcherUtil matcher = new HandMatcherUtil();
		String result = matcher.matchHand(hand);

		assertEquals("High Card", result);
	}
}
