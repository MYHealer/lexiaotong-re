package com.ubixnow.ooooo;

import android.os.Handler;
import android.os.Looper;
import com.ubixnow.core.utils.error.ErrorInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o00O00o0 {
    public Handler mHandler;
    public boolean mHasReturn = false;
    public Runnable mTimerTask = new OooO00o();
    public Runnable uniteTimeTask = new OooO0O0();

    public class OooO00o implements Runnable {
        public OooO00o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o00O00o0 o00o00o0 = o00O00o0.this;
            if (o00o00o0.mHasReturn) {
                return;
            }
            o00o00o0.mHasReturn = true;
            ooooO000.OooO0O0(ooooO000.OooO0O0, ooooO000.OooO0OO("i8"));
            o00O00o0.this.onTimeout();
        }
    }

    public class OooO0O0 implements Runnable {
        public OooO0O0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o00O00o0.this.onTimeout();
        }
    }

    public void cancle() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void getTokenFail(ErrorInfo errorInfo) {
    }

    public void getTokenSucc(oo00o oo00oVar) {
    }

    public abstract void onAdCacheSuccess(oo00o oo00oVar);

    public abstract void onAdDataLoaded(oo00o oo00oVar);

    public abstract void onAdRenderFail(ErrorInfo errorInfo);

    public void onCallbackAdLoaded(oo00o oo00oVar) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.mHasReturn) {
            return;
        }
        this.mHasReturn = true;
        onAdCacheSuccess(oo00oVar);
    }

    public void onCallbackNoAdError(ErrorInfo errorInfo) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.mHasReturn) {
            return;
        }
        this.mHasReturn = true;
        onNoAdError(errorInfo);
    }

    public void onMoreAdSucc(oo00o oo00oVar) {
    }

    public abstract void onNoAdError(ErrorInfo errorInfo);

    public void onPreRedirectFail(ErrorInfo errorInfo) {
    }

    public abstract void onTimeout();

    public void startCountDown(int i, int i2) {
        if (i <= 0) {
            i = (i2 < 1000 || i2 > 30000) ? 3000 : i2;
        }
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        ooooO000.OooO0O0(ooooO000.OooO0O0, "设置超时时间：" + i);
        this.mHandler.postDelayed(this.mTimerTask, i);
    }

    public void startCountDown4Unite(int i) {
        if (i <= 0) {
            i = 1000;
        }
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        ooooO000.OooO0O0(ooooO000.OooO0O0, "设置单元超时时间：" + i);
        this.mHandler.postDelayed(this.uniteTimeTask, i);
    }
}
