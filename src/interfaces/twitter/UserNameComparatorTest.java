package interfaces.twitter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import interfaces.twitter.UserNameComparator;
import objectstructures.TwitterAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserNameComparatorTest {
    TwitterAccount aaron1;
    TwitterAccount aaron2;
    TwitterAccount ben;
    UserNameComparator comparator;

    @BeforeEach
    public void SetUp() {
        aaron1 = new TwitterAccount("aaron");
        aaron2 = new TwitterAccount("aaron");
        ben = new TwitterAccount("ben");
        comparator = new UserNameComparator();
    }

    @Test
    void testCompare() throws Exception {
        assertTrue(comparator.compare(aaron1, ben) < 0, "aaron should come before ben");
        assertTrue(comparator.compare(ben, aaron1) > 0, "ben should come after aaron");
        assertEquals(comparator.compare(aaron1, aaron2), 0, "Two people with the same name should be equal");
    }

}
