
import java.util.*;

class Twitter {

    static class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    static class Entry {
        Tweet tweet;
        Entry(Tweet tweet) {
            this.tweet = tweet;
        }
    }

    HashMap<Integer, Tweet> posts = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> following = new HashMap<>();
    int time = 0;

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, time++);
        tweet.next = posts.get(userId);
        posts.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Entry> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.tweet.time, a.tweet.time)
        );

        // Include the user's own tweets
        if (posts.containsKey(userId)) {
            pq.offer(new Entry(posts.get(userId)));
        }

        // Include the tweets of followed users
        for (int followee : following.getOrDefault(
                userId, new HashSet<>())) {
            if (posts.containsKey(followee)) {
                pq.offer(new Entry(posts.get(followee)));
            }
        }

        while (!pq.isEmpty() && result.size() < 10) {
            Tweet tweet = pq.poll().tweet;
            result.add(tweet.id);

            if (tweet.next != null) {
                pq.offer(new Entry(tweet.next));
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        following.computeIfAbsent(
            followerId, x -> new HashSet<>()
        ).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        following.getOrDefault(
            followerId, new HashSet<>()
        ).remove(followeeId);
    }
}
