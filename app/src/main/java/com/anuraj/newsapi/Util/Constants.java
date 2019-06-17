/*
 * *
 *  * Created by Anuraj R (a4anurajr@gmail.com) on 2019
 *  * Last modified 17/6/19 3:21 PM
 *
 */

package com.anuraj.newsapi.Util;

import java.text.SimpleDateFormat;
import java.util.Locale;

public interface Constants {
    String API_KEY = "8190df9eb51445228e397e4185311a66";
    String NEWS_SOURCE = "bbc-news";
    String NEWS_AUTHOR = "author";
    String NEWS_TITLE = "title";
    String NEWS_DESCRIPTION = "description";
    String NEWS_URL = "url";
    String NEWS_URLTOIMAGE = "urlToImage";
    String NEWS_PUBLISHEDAT = "publishedAt";
    String NEWS_API = "https://newsapi.org/v2/";
    static final SimpleDateFormat formatTo =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
    static final  SimpleDateFormat formatFrom =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

}
