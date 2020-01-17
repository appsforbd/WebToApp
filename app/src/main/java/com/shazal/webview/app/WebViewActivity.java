package com.shazal.webview.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity implements AppConstant {

    public TextView pageTitle;
    public WebView webView;
    String strPageTitle;
    String strPageUrl;
    private AppCompatActivity mActivity;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        mActivity = WebViewActivity.this;
        mContext = mActivity.getApplicationContext();

        pageTitle = (TextView) findViewById(R.id.pageTitle);
        webView = (WebView) findViewById(R.id.webView);

        Intent intent = getIntent();
        if (intent != null) {
            strPageTitle = intent.getStringExtra("title");
            strPageUrl = intent.getStringExtra("url");

            if (strPageUrl.equals("")) {
                strPageUrl = pageError;
            }
        }

        displayData();

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void displayData() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }
        });

        pageTitle.setText(strPageTitle);
        webView.loadUrl(assetUri + strPageUrl);
    }

}
