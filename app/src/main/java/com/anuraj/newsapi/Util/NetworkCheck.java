/*
 * *
 *  * Created by Anuraj R (a4anurajr@gmail.com) on 2019
 *  * Last modified 15/6/19 3:26 PM
 *
 */

package com.anuraj.newsapi.Util;

import android.content.Context;
import android.net.ConnectivityManager;

public class NetworkCheck {

    public static boolean isNetworkAvailable(Context context)
    {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }
}
