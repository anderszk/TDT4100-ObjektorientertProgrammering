package interfaces.twitter;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import interfaces.twitter.TweetsCountComparator;
import objectstructures.TwitterAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TweetsCountComparatorTest {
    TwitterAccount mostTweet;
    TwitterAccount lessTweet1;
    TwitterAccount lessTweet2;
    TweetsCountComparator comparator;

    @BeforeEach
    public void SetUp() {
        mostTweet = new TwitterAccount("aaron");
        lessTweet1 = new TwitterAccount("ben");
        lessTweet2 = new TwitterAccount("charlie");
        comparator = new TweetsCountComparator();
    }

    @Test
    void testCompare() throws Exception {
        mostTweet.tweet("Tweet");
        mostTweet.tweet("Tweet");
        lessTweet1.tweet("Tweet");
        lessTweet2.tweet("Tweet");
        assertTrue(comparator.compare(mostTweet, lessTweet1) > 0);
        assertTrue(comparator.compare(lessTweet1, mostTweet) < 0);
        assertEquals(comparator.compare(lessTweet1, lessTweet2), 0);
    }

}
