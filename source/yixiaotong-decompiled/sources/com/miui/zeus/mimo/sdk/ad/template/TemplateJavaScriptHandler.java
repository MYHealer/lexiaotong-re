package com.miui.zeus.mimo.sdk.ad.template;

import android.webkit.JavascriptInterface;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.miui.zeus.mimo.sdk.view.BaseJavaScriptHandler;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class TemplateJavaScriptHandler extends BaseJavaScriptHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TemplateAdWebView.d f5358a;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{83, this});
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5360a;

        public b(String str) {
            this.f5360a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{128, this});
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{84, this});
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{114, this});
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{Integer.valueOf(AppTypeIdUtil.NewDevice4GDrinkOTA_2), this});
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5364a;

        public f(int i) {
            this.f5364a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{126, this});
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{127, this});
        }
    }

    public TemplateJavaScriptHandler(TemplateAdWebView.d dVar) {
        this.f5358a = dVar;
    }

    @Override // com.miui.zeus.mimo.sdk.view.BaseJavaScriptHandler
    @JavascriptInterface
    public void cancelDownloadAppDirectly() {
        NCall.IV(new Object[]{85, this});
    }

    @Override // com.miui.zeus.mimo.sdk.view.BaseJavaScriptHandler
    @JavascriptInterface
    public boolean checkAppInstall() {
        return NCall.IZ(new Object[]{86, this});
    }

    @Override // com.miui.zeus.mimo.sdk.view.BaseJavaScriptHandler
    @JavascriptInterface
    public boolean checkAppInstall(String str) {
        return NCall.IZ(new Object[]{87, this, str});
    }

    @Override // com.miui.zeus.mimo.sdk.view.BaseJavaScriptHandler
    @JavascriptInterface
    public void clickAppIntroduction() {
        NCall.IV(new Object[]{88, this});
    }

    @Override // com.miui.zeus.mimo.sdk.view.BaseJavaScriptHandler
    @JavascriptInterface
    public void clickAppPermission() {
        NCall.IV(new Object[]{89, this});
    }

    @Override // com.miui.zeus.mimo.sdk.view.BaseJavaScriptHandler
    @JavascriptInterface
    public void clickAppPrivacy() {
        NCall.IV(new Object[]{90, this});
    }

    @Override // com.miui.zeus.mimo.sdk.view.BaseJavaScriptHandler
    @JavascriptInterface
    public void onClick(String str) {
        NCall.IV(new Object[]{91, this, str});
    }

    @Override // com.miui.zeus.mimo.sdk.view.BaseJavaScriptHandler
    @JavascriptInterface
    public void onClose() {
        NCall.IV(new Object[]{92, this});
    }

    @Override // com.miui.zeus.mimo.sdk.view.BaseJavaScriptHandler
    @JavascriptInterface
    public void onVolumeStatusChanged(int i) {
        NCall.IV(new Object[]{93, this, Integer.valueOf(i)});
    }
}
