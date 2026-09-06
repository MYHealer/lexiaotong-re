package com.heytap.msp.mobad.api.params;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SplashSkipView extends FrameLayout {
    private ISplashSkipCountDown mISplashSkipCountDown;

    public interface ISplashSkipCountDown {
        void onSkipCountDownSecond(int i);
    }

    public SplashSkipView(Context context) {
        super(context);
    }

    public SplashSkipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SplashSkipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onSkipCountDown(int i) {
        ISplashSkipCountDown iSplashSkipCountDown = this.mISplashSkipCountDown;
        if (iSplashSkipCountDown != null) {
            iSplashSkipCountDown.onSkipCountDownSecond(i);
        }
    }

    public void setSkipCountDownCallBack(ISplashSkipCountDown iSplashSkipCountDown) {
        this.mISplashSkipCountDown = iSplashSkipCountDown;
    }
}
