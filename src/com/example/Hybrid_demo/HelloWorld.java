package com.example.Hybrid_demo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by admin on 15-4-3.
 */
public class HelloWorld {

    Context mContext;

    /** Instantiate the interface and set the context */
    HelloWorld(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    //@JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
}
