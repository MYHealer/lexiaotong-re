package com.hihonor.adsdk.base.widget.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.g.j.d.h;
import com.hihonor.adsdk.base.g.k.c.u;
import com.hihonor.adsdk.common.f.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class CountdownView extends TextView {
    private static final String TAG = "CountdownView";
    private final int KEY_COUNT_DOWN;
    private BaseAd baseAd;
    private int countdown;
    private Handler mHandler;
    private boolean stopCountdown;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1003) {
                CountdownView.access$010(CountdownView.this);
                CountdownView.this.startCountdown();
            }
        }
    }

    interface b {
        public static final int hnadsa = 0;
        public static final int hnadsb = 1;
    }

    public CountdownView(Context context) {
        super(context);
        this.KEY_COUNT_DOWN = 1003;
        this.countdown = 3;
        this.stopCountdown = false;
        this.mHandler = new a(Looper.getMainLooper());
        init();
    }

    static /* synthetic */ int access$010(CountdownView countdownView) {
        int i = countdownView.countdown;
        countdownView.countdown = i - 1;
        return i;
    }

    private void init() {
        setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.base.CountdownView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m905lambda$init$0$comhihonoradsdkbasewidgetbaseCountdownView(view);
            }
        });
        setBackgroundResource(R.drawable.honor_ads_bg_countdown);
    }

    private void jumpOverClose(boolean z) {
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "jumpOverClose#isClick=" + z, new Object[0]);
        BaseAd baseAd = this.baseAd;
        if (baseAd != null) {
            report(z, baseAd.getImpDuration() - this.countdown);
            AdListener adListener = this.baseAd.getAdListener();
            if (adListener != null) {
                adListener.onAdSkip(!z ? 1 : 0);
            }
        }
    }

    private void report(boolean z, int i) {
        String str = "jumpOverClose and isClick " + z + ", Duration of playback " + i;
        BaseAd baseAd = this.baseAd;
        if (baseAd != null) {
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
            BaseAd baseAd2 = this.baseAd;
            new h(baseAd2, baseAd2.getAdUnitId(), aVarHnadsa, String.valueOf(2), str).hnadse();
            if (z) {
                u uVar = new u(i);
                BaseAd baseAd3 = this.baseAd;
                uVar.hnadsa(baseAd3, baseAd3.getTrackUrl().getCommons());
            } else {
                com.hihonor.adsdk.base.g.k.c.e eVar = new com.hihonor.adsdk.base.g.k.c.e(i);
                BaseAd baseAd4 = this.baseAd;
                eVar.hnadsa(baseAd4, baseAd4.getTrackUrl().getCommons());
            }
        }
    }

    /* JADX INFO: renamed from: lambda$init$0$com-hihonor-adsdk-base-widget-base-CountdownView, reason: not valid java name */
    /* synthetic */ void m905lambda$init$0$comhihonoradsdkbasewidgetbaseCountdownView(View view) {
        jumpOverClose(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "onAttachedToWindow", new Object[0]);
        if (hasWindowFocus()) {
            startCountdown();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "onDetachedFromWindow", new Object[0]);
        release();
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "onWindowFocusChanged#hasWindowFocus: " + z, new Object[0]);
        if (!z) {
            pauseCountdown();
        } else {
            this.stopCountdown = false;
            startCountdown();
        }
    }

    public void release() {
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "release", new Object[0]);
        this.stopCountdown = true;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1003);
            this.mHandler = null;
        }
    }

    public void setBaseAd(BaseAd baseAd) {
        this.baseAd = baseAd;
    }

    public void setCountdown(int i) {
        this.countdown = i;
    }

    private void pauseCountdown() {
        this.stopCountdown = true;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1003);
        }
    }

    public void startCountdown() {
        if (this.stopCountdown) {
            return;
        }
        setText(s.hnadsa(R.string.ads_countdown_jump_over, Integer.valueOf(this.countdown)));
        if (this.countdown == 0) {
            jumpOverClose(false);
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1003);
            this.mHandler.sendEmptyMessageDelayed(1003, 1000L);
        }
    }

    public CountdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KEY_COUNT_DOWN = 1003;
        this.countdown = 3;
        this.stopCountdown = false;
        this.mHandler = new a(Looper.getMainLooper());
        init();
    }

    public CountdownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KEY_COUNT_DOWN = 1003;
        this.countdown = 3;
        this.stopCountdown = false;
        this.mHandler = new a(Looper.getMainLooper());
        init();
    }
}
