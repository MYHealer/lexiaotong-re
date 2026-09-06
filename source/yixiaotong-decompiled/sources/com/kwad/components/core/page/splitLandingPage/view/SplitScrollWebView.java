package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.kwad.components.core.t.d;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SplitScrollWebView extends KsAdWebView {
    private boolean afO;
    private a afP;
    private float afQ;
    private boolean afR;
    private int afq;

    public interface a {
        void g(float f);

        boolean uR();
    }

    private void uL() {
        this.afq = 0;
    }

    public void setDisableAnimation(boolean z) {
        this.afO = z;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.afP = aVar;
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.afO = false;
        uL();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afO = false;
        uL();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afO = false;
        uL();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int screenHeight;
        if (this.afq != 0) {
            int statusBarHeight = d.wJ() ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0;
            if (getContext() instanceof Activity) {
                screenHeight = com.kwad.sdk.c.a.a.k((Activity) getContext());
            } else {
                screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
            }
            i2 = View.MeasureSpec.makeMeasureSpec((screenHeight - statusBarHeight) - this.afq, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (this.afO) {
            return super.onTouchEvent(motionEventObtain);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.afQ = y;
            this.afR = false;
            return super.onTouchEvent(motionEvent);
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                float f = this.afQ;
                float f2 = f - y;
                a aVar = this.afP;
                if (aVar != null && y <= f) {
                    this.afR = true;
                    aVar.g(f2);
                }
                return super.onTouchEvent(motionEventObtain);
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        a aVar2 = this.afP;
        if (aVar2 == null) {
            return false;
        }
        if ((this.afQ - y < 0.0f && !this.afR) || !aVar2.uR()) {
            return false;
        }
        this.afO = true;
        return false;
    }
}
