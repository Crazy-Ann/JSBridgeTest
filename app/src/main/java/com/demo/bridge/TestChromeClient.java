package com.demo.bridge;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;

import com.yjt.bridge.InjectedChromeClient;
import com.yjt.bridge.JsCallJava;


public class TestChromeClient extends InjectedChromeClient {

    public TestChromeClient(String injectedName, Class injectedCls) {
        super(injectedName, injectedCls);
    }

    public TestChromeClient(JsCallJava JsCallJava) {
        super(JsCallJava);
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        // to do your work
        // ...
        return super.onJsAlert(view, url, message, result);
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        // to do your work
        // ...
        return super.onJsPrompt(view, url, message, defaultValue, result);
    }
    
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        // to do your work
        // ...
    }
}
