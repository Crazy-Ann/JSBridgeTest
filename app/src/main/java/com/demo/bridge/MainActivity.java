package com.demo.bridge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.yjt.bridge.InjectedWebviewClient;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webView);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new InjectedWebviewClient(this));
        mWebView.setWebChromeClient(new TestChromeClient("JsProxy", JsProxy.class));
        mWebView.loadUrl("file:///android_asset/JsBridge.html");
    }

    @Override
    public void onResume() {
        if (mWebView != null) {
            mWebView.resumeTimers();
            mWebView.onResume();
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        if (mWebView != null) {
            mWebView.pauseTimers();
            mWebView.onPause();
        }
        super.onPause();
    }

    @Override
    public void onDestroy() {
        if (mWebView != null) {
            mWebView.stopLoading();
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.removeAllViews();
            mWebView.setWebChromeClient(null);
            mWebView.setWebViewClient(null);
            unregisterForContextMenu(mWebView);
            mWebView.destroy();
        }
        super.onDestroy();
    }
}
