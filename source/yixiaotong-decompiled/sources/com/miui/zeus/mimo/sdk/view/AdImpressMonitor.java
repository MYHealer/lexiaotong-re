package com.miui.zeus.mimo.sdk.view;

import android.os.Handler;
import android.view.View;
import com.miui.zeus.mimo.sdk.e9;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AdImpressMonitor implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5661a;
    public long b;
    public boolean c;
    public Handler d;
    public a e;
    public View f;

    public interface a {
        void onAdShow();
    }

    public AdImpressMonitor(Handler handler) {
        int i = e9.f5418a;
        this.f5661a = 500;
        this.b = 0L;
        this.c = false;
        this.d = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        NCall.IV(new Object[]{493, this});
    }
}
