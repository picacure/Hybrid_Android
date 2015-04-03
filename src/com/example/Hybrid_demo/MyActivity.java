package com.example.Hybrid_demo;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private WebView myWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        CallHelloWorld();
    }

    private void CallHelloWorld(){
        myWebView = (WebView) this.findViewById(R.id.myWebView);
        myWebView.getSettings().setJavaScriptEnabled(true);

        myWebView.addJavascriptInterface(new HelloWorld(this), "Android");
        myWebView.loadUrl("file:///android_asset/HelloWorld.html");
    }
}
