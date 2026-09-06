package com.hihonor.adsdk.base.widget.web.jsbridge;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class MyWebView extends WebView {
    private static final String hnadsg = "MyWebView";
    private static final float hnadsh = 30.0f;
    private boolean hnadsd;
    private float hnadse;
    private float hnadsf;

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.hihonor.adsdk.common.b.b.hnadsc(MyWebView.hnadsg, "onTouch", new Object[0]);
            MyWebView.this.requestDisallowInterceptTouchEvent(motionEvent.getAction() != 1);
            return false;
        }
    }

    public MyWebView(Context context) {
        this(context, null);
    }

    public boolean hnadsa() {
        return this.hnadsd;
    }

    public void hnadsb() {
        if (this.hnadsd) {
            this.hnadsd = false;
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "scrollY:" + i2, new Object[0]);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "clampedY:" + z2, new Object[0]);
        if (i2 == 0 || z2) {
            requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.hnadsd = Math.abs(this.hnadse - motionEvent.getX()) < hnadsh && Math.abs(this.hnadsf - motionEvent.getY()) < hnadsh;
            }
        } else {
            this.hnadse = motionEvent.getX();
            this.hnadsf = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public MyWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.webViewStyle);
    }

    public MyWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnTouchListener(new a());
    }
}
