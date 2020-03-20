package com.example.twitter;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;






public class TwitterTimeLine {
    ArrayList<String> statusArrayList = new ArrayList<String>();

    public static void main(String[] args) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("2X0arLJgocz5jSLpwIuuZzjOh")
                .setOAuthConsumerSecret("dTvtQ2nIOne2qs5NzH99WMuyN3aL1lPyUqX4mf5NUYw7IpRAhw")
                .setOAuthAccessToken("4836726586-KllQ5vBZf5d7ZnXl6G1DL8iw1fHiKws50B4h7DU")
                .setOAuthAccessTokenSecret("GhFeTZc5Zfq9AZxLy7yn34LVLs6kBRwv310E52e4RhnRO");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();


        ArrayList<String> statusArrayList = new ArrayList<String>();

        List<Status> statuses = twitter.getHomeTimeline();

        statusArrayList.clear();
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":: " +
                    status.getText() + "\n");


        }

    }

}
