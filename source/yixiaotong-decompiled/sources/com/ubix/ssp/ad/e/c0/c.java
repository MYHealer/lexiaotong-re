package com.ubix.ssp.ad.e.c0;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.w.k;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ubix.ssp.ad.e.y.a.a.b f8810a;
    private long b;

    public c(Activity activity) {
        super(activity);
        this.b = 0L;
        a(activity);
    }

    public c(Context context) {
        super(context);
        this.b = 0L;
        a(context);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0L;
        a(context);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0L;
        a(context);
    }

    private void a(Context context) {
        setAnimationCacheEnabled(true);
        setDrawingCacheEnabled(true);
        setOverScrollMode(2);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        CookieManager.getInstance().setAcceptCookie(true);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setGeolocationEnabled(true);
        settings.setAllowContentAccess(false);
        settings.setSavePassword(false);
        settings.setSaveFormData(true);
        settings.setCacheMode(-1);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setBlockNetworkImage(false);
        settings.setBlockNetworkLoads(false);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setSaveFormData(true);
        settings.setMixedContentMode(0);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(int i, HashMap<String, String> map) {
        try {
            if (this.f8810a != null) {
                k.a(StubApp.getOrigApplicationContext(getContext().getApplicationContext())).a(this.f8810a, map, i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMaterial(com.ubix.ssp.ad.e.y.a.a.b bVar) {
        this.f8810a = bVar;
    }

    public void setMaterial(byte[] bArr) {
        try {
            this.b = System.currentTimeMillis();
            if (bArr == null) {
                u.b("adBytes==null");
            } else {
                this.f8810a = com.ubix.ssp.ad.e.y.a.a.a(bArr).d;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
