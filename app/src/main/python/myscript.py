import tweepy



def twitterTl():
    auth = tweepy.OAuthHandler("2X0arLJgocz5jSLpwIuuZzjOh","dTvtQ2nIOne2qs5NzH99WMuyN3aL1lPyUqX4mf5NUYw7IpRAhw")
    auth.set_access_token("4836726586-YrWlFfvizeMdLTuEbhuK8w16ieDlrlpLpBX8NjM","kGXflrFjaiFm9hkTHxwvPezCsPv9DBtM67Rb2tUHBoJr8")


    api = tweepy.API(auth, wait_on_rate_limit=True)
    #api = tweepy.API(auth)


    my_list = []
    my_list2 = ["a","b","c"]

    tweets = api.home_timeline()
    for tweet in tweets:
        tweet =('{real_name} said {tweet}\n\n'.format(
        real_name=tweet.author.name,tweet=tweet.text))
        my_list.append(tweet)

    return(my_list)

twitterTl()

