package rss.tests;

import rss.model.Feed;
import rss.read.RSSFeedParser;

public class ReadTest {
  public static void main(String[] args) {
    RSSFeedParser parserOne = new RSSFeedParser("http://www.astrology.com/horoscopes/daily-horoscope.rss");
    Feed feedOne = parserOne.readFeed();
    
    RSSFeedParser parserTwo = new RSSFeedParser("http://my.horoscope.com/astrology/daily-horoscopes-rss.html");
    Feed feedTwo = parserTwo.readFeed();
    
    String strOne = feedOne.getTaurusMessage().toString();
    System.out.println(strOne);
    
    String strTwo = feedTwo.getTaurusMessage().toString();
    System.out.println(strTwo);
  }
} 