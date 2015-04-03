package com.example.Hybrid_demo;

import android.content.Context;
import android.widget.Toast;
import android.graphics.Camera;

/**
 * Created by admin on 15-4-3.
 */
public class HelloWorld {

    Context mContext;

    private Camera mCamera;

    /** Instantiate the interface and set the context */
    HelloWorld(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    //@JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    public void openCamera(){
        getCameraInstance();
    }

    public static Camera getCameraInstance(){
        Camera c = null;
        try {
//            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
}
