package objectstructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TweetTest {
    TwitterAccount nils;
    TwitterAccount ole;
    TwitterAccount kari;
    Tweet tweet, retweet1, retweet2;

    @BeforeEach
    public void setup() {
        nils = new TwitterAccount("Nils");
        ole = new TwitterAccount("Ole");
        kari = new TwitterAccount("Kari");

        tweet = new Tweet(nils, "Kvitre!");
        retweet1 = null;
        retweet2 = null;
    }

    @Test
    void constructorNewTweet() {
        assertEquals(tweet.getText(), "Kvitre!");
        assertEquals(tweet.getOwner(), nils);
    }

    @Test
    void constructorRetweet() {
        retweet1 = new Tweet(ole, tweet);
        assertEquals(retweet1.getText(), "Kvitre!");
        assertEquals(retweet1.getOwner(), ole);
        assertThrows(RuntimeException.class, () -> {
            new Tweet(nils, tweet);
        });
    }

    @Test
    void getOriginalTweet() {
        assertNull(tweet.getOriginalTweet());
        retweet1 = new Tweet(ole, tweet);
        assertEquals(retweet1.getOriginalTweet(), tweet);
        assertEquals(retweet1.getText(), retweet1.getOriginalTweet().getText());
        retweet2 = new Tweet(kari, tweet);
        assertEquals(retweet1.getOriginalTweet(), tweet);
        assertEquals(retweet1.getText(), retweet1.getOriginalTweet().getText());
    }

    @Test
    void getRetweetCount() {
        assertEquals(tweet.getRetweetCount(), 0);
        new Tweet(ole, tweet);
        assertEquals(tweet.getRetweetCount(), 1);
        new Tweet(kari, tweet);
        assertEquals(tweet.getRetweetCount(), 2);
    }
}

