package com.example.FrameTouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-4-17
 * Time: 上午9:46
 * To change this template use File | Settings | File Templates.
 */
public class RootControllerView extends FrameLayout {

    private CustomViewGroup backgroundView, foregroundView;

    public RootControllerView(Context context) {
        super(context);
        init();
    }

    public RootControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RootControllerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                Log.d("frametouch", "root view, touch action: " + event.getAction());
                return true;
            }
        });

        this.addOnLayoutChangeListener(new OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom,
                                       int oldLeft, int oldTop, int oldRight, int oldBottom) {
                removeOnLayoutChangeListener(this);
                backgroundView = (CustomViewGroup) findViewById(R.id.view1);
                foregroundView = (CustomViewGroup) findViewById(R.id.view2);

                backgroundView.setViewName("background view");
                backgroundView.setOnTouchListener(new OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        Log.d("frametouch", "background view, touch action: " + event.getAction());
                        return true;
                    }
                });

                foregroundView.setViewName("foreground view");
                foregroundView.setOnTouchListener(new OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        Log.d("frametouch", "foreground view, touch action: " + event.getAction());
                        return false;
                    }
                });
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("frametouch", "root view dispatch touch action: " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }
}
