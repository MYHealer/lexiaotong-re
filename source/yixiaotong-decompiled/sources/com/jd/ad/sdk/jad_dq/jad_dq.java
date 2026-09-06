package com.jd.ad.sdk.jad_dq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_dq {
    public static volatile String jad_an;

    public static class jad_an implements Runnable {
        public final /* synthetic */ Context jad_an;
        public final /* synthetic */ CountDownLatch jad_bo;

        public jad_an(Context context, CountDownLatch countDownLatch) {
            this.jad_an = context;
            this.jad_bo = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (jad_dq.jad_an == null) {
                jad_dq.jad_an = jad_dq.jad_an(this.jad_an);
            }
            this.jad_bo.countDown();
        }
    }

    public static String jad_an(Context context) {
        try {
            WebView webView = new WebView(context);
            webView.getSettings().setAllowFileAccess(false);
            webView.getSettings().setSavePassword(false);
            return webView.getSettings().getUserAgentString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String jad_an(Context context, long j) {
        Looper mainLooper;
        if (jad_an == null) {
            if (context == null || (mainLooper = Looper.getMainLooper()) == null) {
                return "";
            }
            if (Thread.currentThread() == mainLooper.getThread()) {
                jad_an = jad_an(context);
            } else {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                new Handler(mainLooper).post(new jad_an(context, countDownLatch));
                try {
                    countDownLatch.await(j, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                }
            }
            if (jad_an == null) {
                jad_an = "";
            }
        }
        return jad_an;
    }
}
