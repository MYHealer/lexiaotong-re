package com.miui.zeus.mimo.sdk.view;

import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.landingpage.sdk.DownloadListener;
import com.miui.zeus.landingpage.sdk.activity.WebViewActivity;
import com.miui.zeus.landingpage.sdk.js.LPJsCallee;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.RemoteInstallProxy;
import com.miui.zeus.mimo.sdk.r3;
import com.stub.StubApp;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoWebViewActivity extends WebViewActivity implements DownloadListener, LPJsCallee.AppLaunchProxy {
    public MimoAdInfo h;
    public boolean i;
    public int k;
    public int l;
    public long n;
    public r3 o;
    public RemoteInstallProxy p;
    public LPJsCallee.OnAppLaunchProxyCallBack q;
    public volatile boolean j = false;
    public int m = -1;

    public class a implements RemoteInstallProxy.b {

        /* JADX INFO: renamed from: com.miui.zeus.mimo.sdk.view.MimoWebViewActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0861a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f5680a;

            public RunnableC0861a(boolean z) {
                this.f5680a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                NCall.IV(new Object[]{492, this});
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TIMESCALE_ENABLE), this});
            }
        }

        public a() {
        }

        @Override // com.miui.zeus.mimo.sdk.click.RemoteInstallProxy.b
        public void a(Exception exc) {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME), this, exc});
        }

        @Override // com.miui.zeus.mimo.sdk.click.RemoteInstallProxy.b
        public void a(boolean z) {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME), this, Boolean.valueOf(z)});
        }
    }

    static {
        StubApp.interface11(47065);
    }

    @Override // com.miui.zeus.landingpage.sdk.activity.WebViewActivity
    public void a(Bundle bundle) {
        NCall.IV(new Object[]{470, this, bundle});
    }

    @Override // com.miui.zeus.landingpage.sdk.activity.WebViewActivity
    public void a(String str) {
        NCall.IV(new Object[]{471, this, str});
    }

    public final void a(boolean z, String str) {
        NCall.IV(new Object[]{Integer.valueOf(TTVideoEngine.PLAYER_OPTION_OUTPUT_LOG), this, Boolean.valueOf(z), str});
    }

    @Override // com.miui.zeus.landingpage.sdk.js.LPJsCallee.AppLaunchProxy
    public void appLaunchCallBack(LPJsCallee.OnAppLaunchProxyCallBack onAppLaunchProxyCallBack) {
        NCall.IV(new Object[]{473, this, onAppLaunchProxyCallBack});
    }

    public final void b(String str) {
        NCall.IV(new Object[]{474, this, str});
    }

    public final void c(String str) {
        NCall.IV(new Object[]{475, this, str});
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return NCall.IZ(new Object[]{476, this, motionEvent});
    }

    @Override // com.miui.zeus.landingpage.sdk.DownloadListener
    public void onCancelDownload(String str) {
        NCall.IV(new Object[]{477, this, str});
    }

    @Override // com.miui.zeus.landingpage.sdk.activity.WebViewActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // com.miui.zeus.landingpage.sdk.activity.WebViewActivity, android.app.Activity
    public void onDestroy() {
        NCall.IV(new Object[]{479, this});
    }

    @Override // com.miui.zeus.landingpage.sdk.DownloadListener
    public void onDownloadFailed(String str, int i) {
        NCall.IV(new Object[]{480, this, str, Integer.valueOf(i)});
    }

    @Override // com.miui.zeus.landingpage.sdk.DownloadListener
    public void onDownloadFinished(String str) {
        NCall.IV(new Object[]{481, this, str});
    }

    @Override // com.miui.zeus.landingpage.sdk.DownloadListener
    public void onDownloadPaused(String str) {
        NCall.IV(new Object[]{482, this, str});
    }

    @Override // com.miui.zeus.landingpage.sdk.DownloadListener
    public void onDownloadProgressUpdated(String str, int i) {
        NCall.IV(new Object[]{483, this, str, Integer.valueOf(i)});
    }

    @Override // com.miui.zeus.landingpage.sdk.DownloadListener
    public void onDownloadStarted(String str) {
        NCall.IV(new Object[]{484, this, str});
    }

    @Override // com.miui.zeus.landingpage.sdk.DownloadListener
    public void onInstallFailed(String str, int i) {
        NCall.IV(new Object[]{485, this, str, Integer.valueOf(i)});
    }

    @Override // com.miui.zeus.landingpage.sdk.DownloadListener
    public void onInstallStart(String str) {
        NCall.IV(new Object[]{486, this, str});
    }

    @Override // com.miui.zeus.landingpage.sdk.DownloadListener
    public void onInstallSuccess(String str) {
        NCall.IV(new Object[]{487, this, str});
    }

    @Override // com.miui.zeus.landingpage.sdk.DownloadListener
    public void onOtherOperation(String str, int i, int i2) {
        NCall.IV(new Object[]{488, this, str, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    @Override // com.miui.zeus.landingpage.sdk.activity.WebViewActivity, com.miui.zeus.landingpage.sdk.LPWebView.OnWebPageFinishedListener
    public void onWebPageError(WebView webView, String str) {
        NCall.IV(new Object[]{489, this, webView, str});
    }

    @Override // com.miui.zeus.landingpage.sdk.activity.WebViewActivity, com.miui.zeus.landingpage.sdk.LPWebView.OnWebPageFinishedListener
    public void onWebPageFinished(WebView webView, String str) {
        NCall.IV(new Object[]{490, this, webView, str});
    }

    @Override // com.miui.zeus.landingpage.sdk.activity.WebViewActivity, com.miui.zeus.landingpage.sdk.LPWebView.OnWebPageFinishedListener
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return NCall.IZ(new Object[]{491, this, webView, str});
    }
}
