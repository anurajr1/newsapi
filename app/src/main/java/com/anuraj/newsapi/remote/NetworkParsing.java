/*
 * *
 *  * Created by Anuraj R (a4anurajr@gmail.com) on 2019
 *  * Last modified 15/6/19 3:18 PM
 *
 */

package com.anuraj.newsapi.remote;

import static com.anuraj.newsapi.Util.Constants.API_KEY;
import static com.anuraj.newsapi.Util.Constants.NEWS_API;

public class NetworkParsing {

        public String networkSelect(String category,String newsChannel){
            String url ="";
            if(!category.isEmpty() && !newsChannel.isEmpty()){
                url = NEWS_API + category +"?sources=" +newsChannel+"&apiKey=" +API_KEY;
            }
            return url;
        }
}
