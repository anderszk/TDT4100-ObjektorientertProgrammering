package objectstructures;

public class Tweet {
    private TwitterAccount owner;
    private String text;
    private Tweet tweet;
    private int retweetCounter = 0;

    public Tweet(TwitterAccount acc, String Tweet){
        this.owner = acc;
        this.text = Tweet;
    }

    public Tweet(TwitterAccount retweeter, Tweet tweet){
        if(tweet.getOwner() == retweeter){
            throw new IllegalStateException("You cannot retweet your own tweet");
        }
        this.owner = retweeter;
        this.text = tweet.text;
        this.tweet = tweet;
        if(tweet.getOriginalTweet() != null){
            this.tweet = tweet.getOriginalTweet();
        }
        tweet.incrementRetweetCounter();
    }

    public String getText(){
        return this.text;
    }

    public TwitterAccount getOwner(){
        return this.owner;
    }

    public Tweet getOriginalTweet(){
        return this.tweet;
    }

    public int getRetweetCount(){
        return this.retweetCounter;
    }

    private void incrementRetweetCounter(){
        this.retweetCounter++;
    }
}
