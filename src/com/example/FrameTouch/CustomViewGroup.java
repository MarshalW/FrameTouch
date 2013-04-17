package com.example.FrameTouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created with IntelliJ IDEA.
 * User: marshal
 * Date: 13-4-17
 * Time: 上午10:37
 * To change this template use File | Settings | File Templates.
 */
public class CustomViewGroup extends LinearLayout{

    String viewName;

    public CustomViewGroup(Context context) {
        super(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("frametouch", viewName+" dispatch touch action: " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }
}
