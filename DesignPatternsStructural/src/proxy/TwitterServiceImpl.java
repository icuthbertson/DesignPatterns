package proxy;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterServiceImpl implements TwitterService {

	private static final String TWITTER_CONSUMER_KEY = "2xiwfE2pvYKXPWgff24S7qhr7";
	private static final String TWITTER_SECRET_KEY = "jYFwkarlJCCtrXd8RdGxWdtxFbZjZy54tluvqFjdssYIxM2gJc";
	private static final String TWITTER_ACCESS_TOKEN = "2260464548-1FzUK3DmS4DhzzRUFmt83BZUdqeUQwOZJYHljcY";
	private static final String TWITTER_ACCESS_TOKEN_SECRET = "F13nWjDw2a4j4RpgX8G4fyJ5qhsOLP0pc8Dv8mmbHgPqu";
	
	@Override
	public String getTimeline(String screenName) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		    .setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
		    .setOAuthConsumerSecret(TWITTER_SECRET_KEY)
		    .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
		    .setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		StringBuilder builder = new StringBuilder();
		try {
		    Query query = new Query(screenName);
		    QueryResult result;
		    do {
		        result = twitter.search(query);
		        List<Status> tweets = result.getTweets();
		        for (Status tweet : tweets) {
		            builder.append("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
		            builder.append("\n");
		        }
		    } while ((query = result.nextQuery()) != null);
		    
		} catch (TwitterException te) {
		    te.printStackTrace();
		    System.out.println("Failed to search tweets: " + te.getMessage());
		}
		return builder.toString();	
	}

	@Override
	public void postToTimeline(String screenName, String message) {
		System.out.println(message);
	}
}