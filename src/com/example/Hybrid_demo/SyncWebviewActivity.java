package com.example.Hybrid_demo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;

/**
 * Created by admin on 15-4-10.
 */
public class SyncWebviewActivity extends Activity {

    private  WebView myWebView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.syncwebview);

        myWebView = (WebView) this.findViewById(R.id.syncwebview_wv);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new DrawView(this), "Android");

        myWebView.loadUrl("file:///android_asset/SyncWebview.html");

        FrameLayout fl = (FrameLayout)findViewById(R.id.syncwebview_fl);
        final DrawView dw = new DrawView(this);



        fl.addView(dw);
    }

    public class DrawView extends View{

        public float cX = 40;
        public float cY = 40;

        Paint p = new Paint();

        public DrawView(Context context) {
            super(context);

            setWillNotDraw(false);
        }


        @Override
        public void onDraw(Canvas canvas){
            super.onDraw(canvas);

            p.setColor(Color.RED);

            canvas.drawCircle(cX, cY, 15, p);

        }

        @Override
        public boolean onTouchEvent(MotionEvent event){
            cX = event.getX();
            cY = event.getY();

            invalidate();
            return true;
        }

        public void onGetPointsFromDom(float x,float y){
            cX = x;
            cY = y;

            invalidate();
        }

    }
}
