package com.duaamal.app;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.*;
import android.view.Window;
import android.view.WindowManager;
import android.graphics.Color;

public class MainActivity extends Activity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        webView = new WebView(this);
        setContentView(webView);
        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setBuiltInZoomControls(false);
        s.setUseWideViewPort(true);
        s.setLoadWithOverviewMode(true);
        webView.setBackgroundColor(Color.parseColor("#0d3b1e"));
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/index.html");
    }
    @Override public void onBackPressed() { if(webView.canGoBack()) webView.goBack(); }
    @Override protected void onPause() {
        super.onPause();
        webView.evaluateJavascript("if(typeof lockApp==='function')lockApp();", null);
    }
}
