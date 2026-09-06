package com.miui.zeus.landingpage.sdk.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.landingpage.sdk.LPWebView;
import com.miui.zeus.mimo.sdk.R;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.m;
import com.stub.StubApp;
import ijiami_1011.s.s.s;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class WebViewActivity extends Activity implements LPWebView.OnWebPageFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LPWebView f5271a;
    public FrameLayout b;
    public TextView c;
    public View d;
    public boolean e;
    public boolean f;
    public String g;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebViewActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebViewActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(46373);
    }

    public void a() {
        try {
            setContentView(R.layout.lp_activity_webview);
            this.b = (FrameLayout) findViewById(R.id.lp_webView_container);
            ImageView imageView = (ImageView) findViewById(R.id.lp_webview_iv_back);
            ImageView imageView2 = (ImageView) findViewById(R.id.lp_webview_iv_close);
            this.c = (TextView) findViewById(R.id.lp_webview_iv_title);
            this.d = findViewById(R.id.lp_webview_action_bar_placeholder);
            b();
            imageView.setOnClickListener(new a());
            imageView2.setOnClickListener(new b());
            if (this.e) {
                findViewById(R.id.lp_webview_rl_tool_bar).setVisibility(0);
            }
            if (this.f) {
                imageView2.setVisibility(0);
            }
        } catch (Exception e) {
            m.b(s.d(new byte[]{53, 85, 90, 48, 91, 83, Ascii.SYN, 37, 5, Ascii.SYN, 88, 19, 11, 68, 65}, "b08f26"), s.d(new byte[]{101, 82, 0, 101, 93, 84, Ascii.SYN, 37, 5, Ascii.SYN, 88, 19, 91, 67, Ascii.ESC, 19, 91, 95, 34, Ascii.SYN, 3, 3, 69, 0, 8}, "27b341"), e);
            finish();
        }
    }

    public void a(Bundle bundle) {
        this.g = bundle.getString(s.d(new byte[]{9, 6, Ascii.ESC, 107, Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, 13}, "bcb4b2"));
        this.e = bundle.getBoolean(s.d(new byte[]{82, 81, 78, 57, 65, 93, 14, 19, 57, Ascii.SYN, 94, Ascii.NAK, 102, 86, 86, Ascii.DC4}, "947f25"), false);
        this.f = bundle.getBoolean(s.d(new byte[]{82, 80, Ascii.ESC, Base64.padSymbol, 74, 13, 14, 19, 57, 1, 93, 10, 74, 80, Base64.padSymbol, 0, 76, 17, Ascii.NAK, 11, 8}, "95bb9e"), false);
        if (bundle.containsKey(s.d(new byte[]{91, 1, Ascii.US, Base64.padSymbol, 86, 66, 8, 1, 8, Ascii.SYN, 80, 17, 89, 11, 8}, "0dfb90"))) {
            int i = bundle.getInt(s.d(new byte[]{91, 85, 78, 58, 95, 75, 8, 1, 8, Ascii.SYN, 80, 17, 89, 95, 89}, "007e09"), -1);
            m.a(s.d(new byte[]{50, 93, 82, 102, 94, 3, Ascii.SYN, 37, 5, Ascii.SYN, 88, 19, 12, 76, 73}, "e8007f"), s.d(new byte[]{89, 65, 90, 7, 13, 65, 0, 16, 15, 13, 95, 88}, "633bc5") + i);
            setRequestedOrientation(i);
        }
    }

    public void a(String str) {
        LPWebView lPWebView = new LPWebView(this);
        this.f5271a = lPWebView;
        lPWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LPWebView lPWebView2 = this.f5271a;
        int i = f9.f5428a;
        lPWebView2.setScrollBarSize(Math.round(getResources().getDisplayMetrics().density * 3.0f));
        this.f5271a.setScrollBarStyle(33554432);
        this.f5271a.setVerticalScrollBarEnabled(true);
        this.f5271a.setShowTitle(this.e, this.f);
        this.f5271a.setOnWebPageFinishedListener(this);
        this.b.addView(this.f5271a);
        m.a(s.d(new byte[]{110, 81, 82, 96, 88, 1, Ascii.SYN, 37, 5, Ascii.SYN, 88, 19, 80, SignedBytes.MAX_POWER_OF_TWO, 73}, "94061d"), s.d(new byte[]{66, Ascii.SYN, 89, 12}, "7d5128") + str);
        this.f5271a.loadUrl(str);
    }

    public final void b() {
        View view;
        int i;
        if (this.d == null) {
            return;
        }
        int i2 = getApplicationInfo().targetSdkVersion;
        int i3 = getResources().getConfiguration().orientation;
        if (i2 < 35 || Build.VERSION.SDK_INT < 35 || i3 != 1) {
            view = this.d;
            i = 8;
        } else {
            view = this.d;
            i = 0;
        }
        view.setVisibility(i);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LPWebView lPWebView = this.f5271a;
        if (lPWebView != null) {
            lPWebView.destroy();
        }
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        LPWebView lPWebView = this.f5271a;
        if (lPWebView == null || !lPWebView.canGoBack()) {
            finish();
            return true;
        }
        this.f5271a.goBack();
        return true;
    }

    @Override // com.miui.zeus.landingpage.sdk.LPWebView.OnWebPageFinishedListener
    public void onReceivedTitle(WebView webView, String str) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.miui.zeus.landingpage.sdk.LPWebView.OnWebPageFinishedListener
    public void onWebPageError(WebView webView, String str) {
    }

    @Override // com.miui.zeus.landingpage.sdk.LPWebView.OnWebPageFinishedListener
    public void onWebPageFinished(WebView webView, String str) {
    }

    @Override // com.miui.zeus.landingpage.sdk.LPWebView.OnWebPageFinishedListener
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }
}
