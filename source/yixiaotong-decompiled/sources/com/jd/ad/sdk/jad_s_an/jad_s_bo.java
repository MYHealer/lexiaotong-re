package com.jd.ad.sdk.jad_s_an;

import com.jd.ad.sdk.splash.JADSplashSkipView;

/* JADX INFO: compiled from: JADSplashRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_s_bo implements Runnable {
    public final /* synthetic */ JADSplashSkipView jad_s_an;

    public jad_s_bo(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar, JADSplashSkipView jADSplashSkipView) {
        this.jad_s_an = jADSplashSkipView;
    }

    @Override // java.lang.Runnable
    public void run() {
        JADSplashSkipView jADSplashSkipView = this.jad_s_an;
        if (jADSplashSkipView != null) {
            int i = jADSplashSkipView.jad_s_an;
            if (i < 1 || i > 30) {
                jADSplashSkipView.jad_s_an = 5;
            }
            jADSplashSkipView.post(jADSplashSkipView.jad_s_er);
        }
    }
}
