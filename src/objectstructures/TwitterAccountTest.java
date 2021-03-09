package objectstructures;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwitterAccountTest {
    TwitterAccount nils;
    TwitterAccount ole;

    @BeforeEach
    public void setup() {
        nils = new TwitterAccount("Nils");
        ole = new TwitterAccount("Ole");
    }

    @Test
    void testConstructor() {
        assertEquals(nils.getUserName(), "Nils");
        assertEquals(nils.getTweetCount(), 0);
        assertEquals(ole.getUserName(), "Ole");
        assertEquals(ole.getTweetCount(), 0);
    }

    @Test
    void testFollow() {
        nils.follow(ole);
        assertTrue(nils.isFollowing(ole));
        assertFalse(nils.isFollowedBy(ole));
        assertFalse(ole.isFollowing(nils));
        assertTrue(ole.isFollowedBy(nils));

        ole.follow(nils);
        assertTrue(nils.isFollowing(ole));
        assertTrue(nils.isFollowedBy(ole));
        assertTrue(ole.isFollowing(nils));
        assertTrue(ole.isFollowedBy(nils));
    }

    @Test
    void testUnfollow() {
        // Nils slutter å følge Ole uten å følge han fra før
        assertFalse(nils.isFollowing(ole));
        assertFalse(nils.isFollowedBy(ole));
        assertFalse(ole.isFollowing(nils));
        assertFalse(ole.isFollowedBy(nils));

        nils.follow(ole);
        assertTrue(nils.isFollowing(ole));
        assertFalse(nils.isFollowedBy(ole));
        assertFalse(ole.isFollowing(nils));
        assertTrue(ole.isFollowedBy(nils));

        nils.unfollow(ole);
        assertFalse(nils.isFollowing(ole));
        assertFalse(nils.isFollowedBy(ole));
        assertFalse(ole.isFollowing(nils));
        assertFalse(ole.isFollowedBy(nils));
    }

    @Test
    void testNewTweet() {
        nils.tweet("Kvitre!");
        assertEquals(nils.getTweetCount(), 1);
        assertEquals(nils.getTweet(1).getText(), "Kvitre!");
        nils.tweet("Kvitre igjen!");
        assertEquals(nils.getTweetCount(), 2);
        assertEquals(nils.getTweet(1).getText(), "Kvitre igjen!");
        assertEquals(nils.getTweet(2).getText(), "Kvitre!");
    }

    @Test
    void testIllegalTweet() {
        assertThrows(RuntimeException.class, () -> {
            nils.getTweet(1);
        });
        assertThrows(RuntimeException.class, () -> {
            nils.getTweet(-1);
        });
        nils.tweet("Kvitre!");
        assertThrows(RuntimeException.class, () -> {
            nils.getTweet(2);
        });
        assertThrows(RuntimeException.class, () -> {
            nils.getTweet(-1);
        });
    }

    @Test
    void testRetweet() {
        TwitterAccount kari = new TwitterAccount("Kari");

        nils.tweet("Kvitre!");
        assertEquals(nils.getTweetCount(), 1);
        assertEquals(nils.getTweet(1).getText(), "Kvitre!");

        ole.retweet(nils.getTweet(1));
        assertEquals(nils.getTweetCount(), 1);
        assertEquals(nils.getRetweetCount(), 1);
        assertEquals(ole.getTweetCount(), 1);
        assertEquals(ole.getRetweetCount(), 0);
        assertEquals(ole.getTweet(1).getText(), "Kvitre!");
        assertEquals(ole.getTweet(1).getOriginalTweet(), nils.getTweet(1));

        kari.retweet(ole.getTweet(1));
        assertEquals(nils.getTweetCount(), 1);
        assertEquals(nils.getRetweetCount(), 2);
        assertEquals(ole.getTweetCount(), 1);
        assertEquals(ole.getRetweetCount(), 0);
        assertEquals(kari.getTweetCount(), 1);
        assertEquals(kari.getRetweetCount(), 0);
        assertEquals(kari.getTweet(1).getText(), "Kvitre!");
        assertEquals(kari.getTweet(1).getOriginalTweet(), nils.getTweet(1));

    }
}
