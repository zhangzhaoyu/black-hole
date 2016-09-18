package org.zzy.redis.learning.vote;

import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Created by zhaoyu on 16-9-7.
 */
public class Vote {
    private static final long ONE_WEEK_IN_SECONDS = 7 * 24 * 60 * 60;
    private static final long VOTE_SCORE =86400 / 200;
    private static final long ARTICLES_PER_PAGE = 200;


    private Jedis jedis;

    public Vote(Jedis jedis) {
        this.jedis = jedis;
    }

    public void articleVote(String user, String article) {
        long cutoff = System.currentTimeMillis() - ONE_WEEK_IN_SECONDS;
        if (jedis.zscore("time:", article) < cutoff) {
            return;
        }
        String articleId = article.split(":")[1];
        // if new vote
        if (jedis.sadd("voted:" + articleId, user) == 1) {
            jedis.zincrby("score:",VOTE_SCORE, article);
            jedis.hincrBy(article, "votes", 1);
        }
    }

    public String postArticle(String user, String title, String link) {
        String articleId = Long.toString(jedis.incr("article:"));
        String voted = "voted:" + articleId;

        jedis.sadd(voted, user);
        jedis.expire(voted, (int) ONE_WEEK_IN_SECONDS);

        long now = System.currentTimeMillis();
        String article = "article:" + articleId;

        Map articleContent = new HashMap();
        articleContent.put("title", title);
        articleContent.put("link", link);
        articleContent.put("poster", user);
        articleContent.put("time", now);
        articleContent.put("votes", 1);
        jedis.hmset(
                article,
                articleContent
        );
        return articleId;
    }

    public List<Map> getArticles(int page, String order) {
        if (order == null) {
            order = "score:";
        }
        long start = (page - 1) * ARTICLES_PER_PAGE;
        long end = start + ARTICLES_PER_PAGE -1;

        Set<String> ids = jedis.zrevrange(order, start, end);
        List<Map> articles = new ArrayList<>();
        for (String id : ids) {
            Map article = jedis.hgetAll(id);
            article.put("id", id);
            articles.add(article);
        }
        return articles;
    }
}
