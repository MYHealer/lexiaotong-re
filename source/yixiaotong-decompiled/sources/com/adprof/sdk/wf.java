package com.adprof.sdk;

import android.os.Bundle;
import android.widget.RelativeLayout;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.NativeAdEventListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class wf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f1501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ d f800a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ yf f801a;

    public wf(yf yfVar, Bundle bundle, d dVar) {
        this.f801a = yfVar;
        this.f1501a = bundle;
        this.f800a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        NativeAdEventListener nativeAdEventListener;
        int i;
        try {
            ((pf) this.f801a).f1365a = this.f1501a.getInt("AD_WIDTH");
            ((pf) this.f801a).b = this.f1501a.getInt("AD_HEIGHT");
            int iB = h8.b();
            int measuredWidth = (this.f801a.getMeasuredWidth() * 20) / 55;
            int iA = (measuredWidth * 2) / 3;
            int i2 = ((pf) this.f801a).b;
            int i3 = 10;
            if (i2 > 10) {
                iA = h8.a(i2 - 10);
            }
            if (this.f801a.m705a() && (i = ((pf) this.f801a).b) > 30) {
                iA = h8.a(i - 30);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(measuredWidth, iA);
            layoutParams.setMargins(h8.a(5.0f), 0, h8.a(5.0f), 0);
            layoutParams.addRule(9);
            this.f801a.a(this.f800a, layoutParams, "3:2");
            this.f801a.a();
            if (iB / this.f801a.getMeasuredWidth() <= 1.5d) {
                i3 = 13;
            }
            this.f801a.a(4, i3);
            this.f801a.a(this.f800a, i3, 1);
            yf.a(this.f801a);
            if (iB / this.f801a.getMeasuredWidth() <= 2 || (nativeAdEventListener = ((pf) this.f801a).f579a) == null) {
                return;
            }
            nativeAdEventListener.onAdRenderFail(AdError.ERROR_NATIVE_SHOW_NOT_HALF_SCREEN);
        } catch (Throwable unused) {
        }
    }
}
