package com.byazt.nr;

import android.os.Looper;
import android.webkit.WebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 215})
public class yp {
    public static final c c = new tt(null);

    /* JADX INFO: renamed from: com.byazt.nr.yp$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 212})
    static /* synthetic */ class AnonymousClass1 {
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 435})
    private static class c {
        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void c(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            yp.tt(new Runnable() { // from class: com.byazt.nr.yp.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 2052})
    private static class tt extends c {
        private tt() {
            super(null);
        }

        public /* synthetic */ tt(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.byazt.nr.yp.c
        public void c(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            yp.tt(new Runnable() { // from class: com.byazt.nr.yp.tt.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    if (str2 != null && str2.startsWith("javascript:")) {
                        try {
                            webView.evaluateJavascript(str, null);
                            return;
                        } catch (Throwable th) {
                            boolean z = th instanceof IllegalStateException;
                        }
                    }
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Deprecated
    public static void c(WebView webView, String str) {
        c.c(webView, str);
    }

    public static void c(com.byazt.nl.uj ujVar, String str) {
        c.c(ujVar.getWebView(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            da.tt().post(runnable);
        }
    }
}
