package com.hihonor.adsdk.base.widget.web;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.j.h;
import com.hihonor.adsdk.base.widget.base.c;
import com.hihonor.adsdk.base.widget.base.f;
import com.hihonor.adsdk.base.widget.web.jsbridge.MyWebView;
import com.hihonor.adsdk.common.f.k;
import com.hihonor.adsdk.common.f.v;
import com.hihonor.adsdk.common.safe.SafeIntent;
import com.hihonor.adsdk.common.uikit.hweffect.engine.HnShadowDrawable;
import java.net.URI;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class WebCommonActivity extends c {
    private static final String j = "WebCommonActivity";
    private static final String k = "scene_source";
    private int i;

    private static class a {
        private static final int hnadsc = 0;
        private static final int hnadsd = -1001;
        private static final int hnadse = -1002;
        private static final int hnadsf = -1003;
        private static final int hnadsg = -1004;
        private static final int hnadsh = -1005;
        private static final int hnadsi = -1006;
        private static final int hnadsj = -1007;
        private final int hnadsa;
        private final String hnadsb;

        public a(int i, String str) {
            this.hnadsa = i;
            this.hnadsb = str;
        }
    }

    private static class b extends c.C0452c {
        public b(WebCommonActivity webCommonActivity) {
            super(webCommonActivity);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            com.hihonor.adsdk.common.b.b.hnadsc(WebCommonActivity.j, "shouldOverrideUrlLoading", new Object[0]);
            WebCommonActivity webCommonActivity = (WebCommonActivity) hnadsa(this.hnadsa);
            if (webCommonActivity == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(WebCommonActivity.j, "shouldOverrideUrlLoading webCommonActivity finish ", new Object[0]);
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            a aVarHnadsf = webCommonActivity.hnadsf(webResourceRequest.getUrl().toString());
            com.hihonor.adsdk.common.b.b.hnadse(WebCommonActivity.j, aVarHnadsf.hnadsb, new Object[0]);
            return aVarHnadsf.hnadsa == 0 || aVarHnadsf.hnadsa == -1004 || aVarHnadsf.hnadsa == -1007;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsd(View view) {
        hnadsf(view.getHeight());
    }

    private boolean hnadsz() {
        int promotionPurpose;
        T t = this.hnadsg;
        return t != 0 && ((promotionPurpose = ((BaseAd) t).getPromotionPurpose()) == 0 || promotionPurpose == 4) && this.g != null && ((BaseAd) this.hnadsg).getLandingPageType() == 1;
    }

    public void a() {
        final View childAt;
        FrameLayout frameLayout = this.g;
        if (frameLayout == null || frameLayout.getVisibility() != 0 || this.g.getChildCount() <= 0 || (childAt = this.g.getChildAt(0)) == null) {
            return;
        }
        childAt.post(new Runnable() { // from class: com.hihonor.adsdk.base.widget.web.WebCommonActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsd(childAt);
            }
        });
    }

    protected void hnadsa(Configuration configuration) {
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsb(String str) {
        com.hihonor.adsdk.common.b.b.hnadsa(j, (Object) ("loadPageFinished# url is " + str));
        this.hnadse.hnadsb(this.hnadsf);
        this.hnadse.hnadsc(this.hnadsf);
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsc(String str) {
        if (this.hnadsg == 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(j, "loadStart#baseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(j, "loadStart", new Object[0]);
        this.hnadsf = str;
        this.hnadse.hnadsa(str);
    }

    @Override // com.hihonor.adsdk.base.widget.base.c, com.hihonor.adsdk.base.widget.base.f
    protected f.b hnadse() {
        return new b(this);
    }

    protected void hnadsf(int i) {
        hnadse(i);
    }

    @Override // com.hihonor.adsdk.base.widget.base.c
    protected void hnadsu() {
        T t = this.hnadsg;
        if (t == 0 || !(((BaseAd) t).getPromotionPurpose() == 0 || ((BaseAd) this.hnadsg).getPromotionPurpose() == 4)) {
            findViewById(R.id.fra_web).setVisibility(0);
            this.e = (FrameLayout) findViewById(R.id.ad_common_retry_layout);
            this.f = (FrameLayout) findViewById(R.id.ad_common_web_view_layout);
        } else {
            ScrollView scrollView = (ScrollView) findViewById(R.id.ad_scroll_view);
            this.d = scrollView;
            scrollView.setVisibility(0);
            this.e = (FrameLayout) findViewById(R.id.ad_common_retry_layout_scroll);
            this.f = (FrameLayout) findViewById(R.id.ad_common_web_view_layout_scroll);
        }
    }

    @Override // com.hihonor.adsdk.base.widget.base.c
    protected void hnadsv() {
        int intExtra = new SafeIntent(getIntent()).getIntExtra(k, 0);
        this.i = intExtra;
        this.hnadse.hnadsa(intExtra);
        hnadsw();
        if (hnadsz()) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
        }
    }

    protected void hnadsw() {
        com.hihonor.adsdk.common.b.b.hnadsc(j, "displayBottomFlotView#call method", new Object[0]);
        T t = this.hnadsg;
        if (t == 0 || !(((BaseAd) t).getPromotionPurpose() == 0 || ((BaseAd) this.hnadsg).getPromotionPurpose() == 4)) {
            com.hihonor.adsdk.common.b.b.hnadsc(j, "displayBottomFlotView#unable to display flot view, layout type no match.", new Object[0]);
            return;
        }
        this.g.setVisibility(0);
        View viewHnadsy = hnadsy();
        if (viewHnadsy == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(j, "displayBottomFlotView# webBottomFlotView is null", new Object[0]);
            return;
        }
        this.g.removeAllViews();
        this.g.addView(viewHnadsy);
        Drawable drawableHnadsa = k.hnadsa(this, hnadsx());
        if (drawableHnadsa instanceof HnShadowDrawable) {
            this.g.setBackground(drawableHnadsa);
        }
        a();
    }

    protected int hnadsx() {
        return R.drawable.honor_ads_bg_shadow_top;
    }

    protected View hnadsy() {
        return com.hihonor.adsdk.base.widget.web.a.hnadsa(this, (BaseAd) this.hnadsg);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hnadsa(configuration);
        a();
    }

    @Override // com.hihonor.adsdk.base.widget.base.f, android.app.Activity
    protected void onPause() {
        super.onPause();
        com.hihonor.adsdk.common.b.b.hnadsb(j, "onPause", new Object[0]);
        MyWebView myWebView = this.hnadsj;
        if (myWebView != null) {
            myWebView.hnadsb();
        }
    }

    @Override // com.hihonor.adsdk.base.widget.base.f, android.app.Activity
    protected void onResume() {
        super.onResume();
        com.hihonor.adsdk.common.b.b.hnadsb(j, "onResume", new Object[0]);
        MyWebView myWebView = this.hnadsj;
        if (myWebView != null) {
            myWebView.hnadsb();
        }
    }

    public static void hnadsa(BaseAd baseAd, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(j, "startWebTargetPage", new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putParcelable("info", baseAd);
        bundle.putInt(k, i);
        com.hihonor.adsdk.base.bean.f fVarHnadsa = h.hnadsa(WebCommonActivity.class, bundle);
        if (fVarHnadsa.hnadsa() != 0) {
            new x(baseAd != null ? baseAd.getAdUnitId() : "", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_CODE_START_ACTIVITY_FAILED, fVarHnadsa.hnadsb()).hnadsa("code", String.valueOf(fVarHnadsa.hnadsa())).hnadsa(com.hihonor.adsdk.base.g.j.e.a.w0, String.valueOf(i)).hnadse();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a hnadsf(String str) {
        if (TextUtils.isEmpty(str)) {
            return new a(-1001, "openApp#Unable to start app,Cause by url is empty.");
        }
        if (str.startsWith("http") || str.startsWith("https")) {
            return new a(-1003, "openApp#Unable to start app,Cause by scheme is http or https");
        }
        if (!this.hnadsj.hnadsa()) {
            return new a(-1007, "openApp#Unable to start app,Cause by not click event.");
        }
        try {
            URI uriCreate = URI.create(str);
            String host = uriCreate.getHost();
            String scheme = uriCreate.getScheme();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(scheme)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (!com.hihonor.adsdk.base.j.b.hnadsa(this, intent)) {
                    return new a(-1004, "openApp#Unable to start app,Cause by uninstall.");
                }
                startActivity(intent);
                this.hnadse.hnadsa();
                com.hihonor.adsdk.common.b.b.hnadsc(j, "openApp#start app.", new Object[0]);
                return new a(0, "openApp#start app.");
            }
            return new a(AVMDLDataLoader.AVMDLErrorIsTooManyTask, "openApp#Unable to start app,Cause by host or scheme is empty.");
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(j, "openApp, start app error, Exception: " + v.hnadsb(e.getMessage()), new Object[0]);
            return new a(-1005, "openApp#Unable to start app,Cause by exception is " + e.getMessage());
        }
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    public void hnadsd(String str) {
        if (hnadsz()) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
        }
        if (this.hnadsg == 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(j, "loadSuccess#baseAd is null", new Object[0]);
            return;
        }
        this.hnadsf = str;
        com.hihonor.adsdk.common.b.b.hnadsa(j, (Object) ("loadSuccess# url is " + this.hnadsf));
        if (TextUtils.isEmpty(this.hnadsf)) {
            this.hnadse.hnadsa(ErrorCode.AD_WEB_DETAIL_URL_NULL, ErrorCode.STR_AD_WEB_DETAIL_URL_NULL);
        }
        this.hnadse.hnadsb(this.hnadsf);
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    public void hnadsa(int i, String str, String str2) {
        int promotionPurpose;
        T t = this.hnadsg;
        if (t != 0 && (((promotionPurpose = ((BaseAd) t).getPromotionPurpose()) == 0 || promotionPurpose == 4) && this.g != null)) {
            hnadsw();
        }
        com.hihonor.adsdk.common.b.b.hnadsc(j, "loadFail errorCode=%d , description=%s", Integer.valueOf(i), str);
        if (this.hnadsg == 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(j, "loadFail# mBaseAd is null", new Object[0]);
        } else {
            this.hnadsf = str2;
            this.hnadse.hnadsa(str2, Integer.valueOf(i), str);
        }
    }

    @Override // com.hihonor.adsdk.base.widget.base.b, com.hihonor.adsdk.base.widget.base.f
    protected void hnadsf() {
        super.hnadsf();
        if (this.hnadsg == 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(j, "destroy#baseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(j, "destroy", new Object[0]);
        com.hihonor.adsdk.common.b.b.hnadsc(j, "destroy and jump_times:" + this.hnadsp + ", click_times:" + this.hnadso, new Object[0]);
        this.hnadse.hnadsa(this.hnadsf, this.hnadso, this.hnadsp);
    }
}
