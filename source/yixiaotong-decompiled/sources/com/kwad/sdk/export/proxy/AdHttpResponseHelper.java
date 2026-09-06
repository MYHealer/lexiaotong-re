package com.kwad.sdk.export.proxy;

import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AdHttpResponseHelper {
    public static void notifyResponseStart(final AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        by.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.1
            @Override // java.lang.Runnable
            public void run() {
                adHttpResponseListener.onResponseStart();
            }
        });
    }

    public static void notifyResponseEnd(final AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        by.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.2
            @Override // java.lang.Runnable
            public void run() {
                adHttpResponseListener.onResponseEnd();
            }
        });
    }

    public static boolean notifyResponseProgress(AdHttpResponseListener adHttpResponseListener, long j, long j2) {
        if (adHttpResponseListener == null) {
            return false;
        }
        return adHttpResponseListener.onReadProgress(j, j2);
    }
}
