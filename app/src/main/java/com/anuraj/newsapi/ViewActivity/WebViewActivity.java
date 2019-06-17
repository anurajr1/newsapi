/*
 * *
 *  * Created by Anuraj R (a4anurajr@gmail.com) on 2019
 *  * Last modified 17/6/19 6:40 PM
 *
 */

package com.anuraj.newsapi.ViewActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.anuraj.newsapi.R;

import static com.anuraj.newsapi.Util.Constants.NEWS_URL;

public class WebViewActivity extends AppCompatActivity {
    Intent intent;
    //WebView webView;
    ProgressBar bar;
    String url = "";

    private WebView webView;
    static final int CLOSEPROGRESS = 5000;

    Activity activity ;
    private ProgressDialog progDailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        setContentView(R.layout.webview_layout);
        //setting the close icon and title name
        setupToolBar();

        webView = (WebView) findViewById(R.id.web_view);
        //bar=(ProgressBar) findViewById(R.id.progressBar2);
        webView.setWebViewClient(new myWebclient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);


        activity = this;
        progDailog = ProgressDialog.show(activity, "Loading","Please wait...", true);
        progDailog.setCancelable(false);

        url = intent.getStringExtra(NEWS_URL);
        if (!url.startsWith("http://") && !url.startsWith("https://")){
            url = "https://" + url;
        }
        webView.loadUrl(url);

    }

    public class myWebclient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //bar.setVisibility(View.GONE);
            new Handler().postDelayed(clossProgressRunnable(), CLOSEPROGRESS);
            //progDailog.dismiss();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            progDailog.show();
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode== KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            //webView.goBack();
            activity.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    //design the toolbar programatically
    private void setupToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        if (toolbar == null) return;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(intent.getStringExtra("companyname"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_arrow);

    }

    //closing the current screen by clicking the cross button
    @Override
    public boolean onSupportNavigateUp() {
        finish(); // close this activity as oppose to navigating up
        return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.webview_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_open_browser) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private Runnable clossProgressRunnable() {
        return new Runnable() {

            @Override
            public void run() {
                try {
                    progDailog.dismiss();

                }catch(Exception e){
                    System.out.print(e);
                }
            }
        };
    }

}
