package interfaces.twitter;


import interfaces.twitter.FollowersCountComparator;
import objectstructures.TwitterAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FollowersCountComparatorTest {
    TwitterAccount aaron;
    TwitterAccount ben;
    TwitterAccount charlie;
    FollowersCountComparator comparator;

    @BeforeEach
    public void SetUp() {
        aaron = new TwitterAccount("aaron");
        ben = new TwitterAccount("ben");
        charlie = new TwitterAccount("charlie");
        comparator = new FollowersCountComparator();
    }

    @Test
    void testCompare() throws Exception {
        aaron.follow(ben);
        ben.follow(aaron);
        assertEquals(comparator.compare(aaron, ben), 0);
        charlie.follow(ben);
        assertTrue(comparator.compare(aaron, ben) < 0);
        assertTrue(comparator.compare(ben, aaron) > 0);
    }

}

