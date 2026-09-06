package com.miui.zeus.mimo.sdk.ad.template;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.CommonActionHandler;
import com.miui.zeus.mimo.sdk.common.CommonEventImpl;
import com.miui.zeus.mimo.sdk.download.AutoDownloadController;
import com.miui.zeus.mimo.sdk.h3;
import com.miui.zeus.mimo.sdk.n;
import com.miui.zeus.mimo.sdk.r3;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.view.component.RootICP;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class TemplateAdWebView extends RootICP implements h3 {
    public static final String j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f5354a;
    public TemplateJavaScriptHandler b;
    public TemplateUIController.a c;
    public CommonActionHandler d;
    public CommonEventImpl e;
    public AutoDownloadController f;
    public int g;
    public boolean h;
    public MimoAdInfo i;

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            NCall.IV(new Object[]{115, this, webView, str});
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            NCall.IV(new Object[]{116, this, webView, Integer.valueOf(i), str, str2});
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            NCall.IV(new Object[]{Integer.valueOf(AppTypeIdUtil.Drink4GCostControl_1), this, webView, webResourceRequest, webResourceError});
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            NCall.IV(new Object[]{118, this, webView, webResourceRequest, webResourceResponse});
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5356a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public class a implements ValueCallback<String> {
            public a(b bVar) {
            }

            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                NCall.IV(new Object[]{62, this, str});
            }
        }

        public b(int i, int i2, int i3) {
            this.f5356a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{Integer.valueOf(AppTypeIdUtil.NewDevice4GBathOTA), this});
        }
    }

    public class c implements n {
        public c() {
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onCancelDownload(String str) {
            NCall.IV(new Object[]{103, this, str});
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onDownloadFailed(String str, int i) {
            NCall.IV(new Object[]{104, this, str, Integer.valueOf(i)});
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onDownloadFinished(String str) {
            NCall.IV(new Object[]{105, this, str});
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onDownloadPaused(String str) {
            NCall.IV(new Object[]{106, this, str});
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onDownloadProgressUpdated(String str, int i) {
            NCall.IV(new Object[]{107, this, str, Integer.valueOf(i)});
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onDownloadStarted(String str) {
            NCall.IV(new Object[]{108, this, str});
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onExistDownload(String str) {
            NCall.IV(new Object[]{109, this, str});
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onInstallFailed(String str, int i) {
            NCall.IV(new Object[]{110, this, str, Integer.valueOf(i)});
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onInstallStart(String str) {
            NCall.IV(new Object[]{111, this, str});
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onInstallSuccess(String str) {
            NCall.IV(new Object[]{112, this, str});
        }
    }

    public interface d {
    }

    static {
        NCall.IV(new Object[]{129});
    }

    public TemplateAdWebView(Context context) {
        super(context);
        this.g = 0;
        this.h = true;
        a(context);
    }

    public static void a(TemplateAdWebView templateAdWebView, AdEvent adEvent, ClickAreaType clickAreaType, View view) {
        NCall.IV(new Object[]{130, templateAdWebView, adEvent, clickAreaType, view});
    }

    public static void a(TemplateAdWebView templateAdWebView, String str) {
        NCall.IV(new Object[]{131, templateAdWebView, str});
    }

    private n getDownloadListener() {
        return (n) NCall.IL(new Object[]{132, this});
    }

    public void a(int i, int i2, int i3) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START), this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void a(Context context) {
        NCall.IV(new Object[]{134, this, context});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public void destroy() {
        NCall.IV(new Object[]{135, this});
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return NCall.IZ(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH), this, motionEvent});
    }

    public int getAction() {
        return NCall.II(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME), this});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public int getRequestMinHeight() {
        return NCall.II(new Object[]{138, this});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public int getRequestMinWidth() {
        return NCall.II(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE), this});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public View getRootAdView() {
        return (View) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID), this});
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID), this});
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO), this});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public void pause() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE), this});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public void resume() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SPADE), this});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo) {
        NCall.IV(new Object[]{145, this, activity, mimoAdInfo});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public void setDownloadListener(r3 r3Var) {
        NCall.IV(new Object[]{146, this, r3Var});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public void setMute(boolean z) {
        NCall.IV(new Object[]{147, this, Boolean.valueOf(z)});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public void setTemplateUIControllerAdListener(TemplateUIController.a aVar) {
        NCall.IV(new Object[]{148, this, aVar});
    }
}
