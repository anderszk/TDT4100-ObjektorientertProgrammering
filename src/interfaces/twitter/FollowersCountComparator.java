package interfaces.twitter;

import objectstructures.TwitterAccount;
import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount>{
    @Override
    public int compare(TwitterAccount o1, TwitterAccount o2) {
        return Integer.compare(o1.getFollowerCount(), o2.getFollowerCount());
    }
}
