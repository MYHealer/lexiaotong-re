package com.byazt.zb;

import android.os.Build;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 184, 42})
public class i {
    private static void tt(com.byazt.nl.uj ujVar) {
        try {
            ujVar.removeJavascriptInterface("searchBoxJavaBridge_");
            ujVar.removeJavascriptInterface("accessibility");
            ujVar.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            sp.c("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    public static void c(com.byazt.nl.uj ujVar) {
        tt(ujVar);
        try {
            ujVar.setJavaScriptEnabled(true);
            ujVar.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            sp.c("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            ujVar.setSupportZoom(false);
        } catch (Throwable th2) {
            sp.c("WebViewSettings", "setSupportZoom error", th2);
        }
        ujVar.setLoadWithOverviewMode(true);
        ujVar.setUseWideViewPort(true);
        ujVar.setDomStorageEnabled(true);
        ujVar.setAllowFileAccess(false);
        ujVar.setBlockNetworkImage(false);
        ujVar.setDisplayZoomControls(false);
        ujVar.setAllowFileAccessFromFileURLs(false);
        ujVar.setAllowUniversalAccessFromFileURLs(false);
        ujVar.setSavePassword(false);
        boolean z = Build.VERSION.SDK_INT >= 28;
        try {
            if (!z) {
                ujVar.setLayerType(0, null);
            } else {
                if (z) {
                    ujVar.setLayerType(2, null);
                }
                ujVar.setMixedContentMode(0);
            }
        } catch (Throwable th3) {
            sp.c("WebViewSettings", "setLayerType error", th3);
        }
        ujVar.setMixedContentMode(0);
    }
}
