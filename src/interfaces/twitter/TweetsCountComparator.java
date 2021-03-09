package interfaces.twitter;

import objectstructures.TwitterAccount;

import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount>{
    @Override
    public int compare(TwitterAccount o1, TwitterAccount o2) {
        return Integer.compare(o1.getTweetCount(), o2.getTweetCount());
    }
}
