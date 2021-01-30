package objectstructures;

import java.util.ArrayList;

public class TwitterAccount {

    private TwitterAccount user;
    private String username;
    private ArrayList<TwitterAccount> follows = new ArrayList<TwitterAccount>();
    private ArrayList<TwitterAccount> followers = new ArrayList<TwitterAccount>();
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private int tweetCount;
    private int retweetCount;


    public TwitterAccount(String username){
        this.username = username;
    }

    public String getUserName(){
        return this.username;
    }

    public int getTweetCount(){
        return this.tweetCount;
    }

    public int getRetweetCount(){
        return this.retweetCount;
    }

    public Tweet getTweet(int i){
        return this.tweets.get(i-1);
    }


    /**
     *
     * @param acc brukernavn til brukeren du vil følge
     */
    public void follow(TwitterAccount acc){
        if (this == acc || this.follows.contains(acc)){
            throw new IllegalArgumentException("You cannot do that!");
        }
        else{
            this.follows.add(acc);
            acc.followers.add(this);
        }
    }

    /**
     *
     * @param acc brukernavn til personen du vil unfollowe
     */
    public void unfollow(TwitterAccount acc){
        if (this == acc || !this.follows.contains(acc)){
            throw new IllegalArgumentException("You cannot do that!");
        }
        else{
            this.follows.remove(acc);
            acc.followers.remove(this);
        }
    }

    public boolean isFollowing(TwitterAccount acc){
        if (this == acc){
            throw new IllegalArgumentException("Error: cannot check if youre following yourself");
        }
        else {
            return this.follows.contains(acc);
        }
    }

    public boolean isFollowedBy(TwitterAccount acc){
        if (this == acc){
            throw new IllegalArgumentException("Error: cannot check if youre following yourself");
        }
        else {
            return acc.follows.contains(this);
        }
    }

    public void tweet(String text){
        Tweet tweet = new Tweet(this, text);
        tweetCount++;
        this.tweets.add(0,tweet);
    }

    public void retweet(Tweet tweet){
        Tweet retweet = new Tweet(this, tweet);
        retweet.getOriginalTweet().getOwner().incrementRetweetCount();
        this.tweets.add(retweet);
        tweetCount++;
    }

    private void incrementRetweetCount(){
        retweetCount ++;
    }

    public int getFollowingCount(){
        return this.follows.size();
    }
    public int getFollowerCount(){
        return this.followers.size();
    }


}
