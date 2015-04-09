package com.example.Hybrid_demo;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Toast;

import java.io.*;

public class HelloWorldActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private WebView myWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        try {
            CallHelloWorld();
        } catch (IOException e) {

            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void CallHelloWorld() throws IOException {
        myWebView = (WebView) this.findViewById(R.id.myWebView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new Proxy(this), "Android");

//        LoadHtmlFromBaseURL();

        myWebView.loadUrl("file:///android_asset/HelloWorld.html");
    }

    private void LoadHtmlFromBaseURL() throws IOException {
        AssetManager am = this.getAssets();
        InputStream input = am.open("HelloWorld.html");
        BufferedReader br = new BufferedReader(new InputStreamReader(input));

        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null){
            sb.append(line);
        }

        String myHTML = sb.toString();

        myWebView.loadDataWithBaseURL("file:///android_asset/", myHTML,
                "text/html", "UTF-8", null);
    }

    public class Proxy {

        Context mContext;

        /** Instantiate the interface and set the context */
        Proxy(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        //@JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
    }

}
