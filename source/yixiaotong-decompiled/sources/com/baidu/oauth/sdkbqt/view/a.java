package com.baidu.oauth.sdkbqt.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.oauth.sdkbqt.R;
import com.baidu.oauth.sdkbqt.auth.AuthInfo;
import com.baidu.oauth.sdkbqt.auth.BdOauthSdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class a extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f1905a;
    private TextView b;
    private AuthInfo c;
    protected com.baidu.oauth.sdkbqt.auth.i oauthWebView;

    protected void setupViews() {
        int iOauthResID;
        int iOauthResID2;
        int iOauthResID3;
        this.oauthWebView = new com.baidu.oauth.sdkbqt.auth.i(this);
        this.oauthWebView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        AuthInfo authInfo = BdOauthSdk.getAuthInfo();
        this.c = authInfo;
        if (authInfo != null && authInfo.getFindViewDelegate() != null) {
            iOauthResID = this.c.getFindViewDelegate().oauthResID(com.baidu.mobads.sdk.internal.b.a.b.d);
            iOauthResID2 = this.c.getFindViewDelegate().oauthResID(com.baidu.mobads.sdk.internal.b.a.b.f);
            iOauthResID3 = this.c.getFindViewDelegate().oauthResID(com.baidu.mobads.sdk.internal.b.a.b.e);
        } else {
            iOauthResID = R.id.oauth_title_back;
            iOauthResID2 = R.id.oauth_title;
            iOauthResID3 = R.id.oauth_webview_container;
        }
        this.f1905a = findViewById(iOauthResID);
        this.b = (TextView) findViewById(iOauthResID2);
        LinearLayout linearLayout = (LinearLayout) findViewById(iOauthResID3);
        if (linearLayout != null) {
            linearLayout.addView(this.oauthWebView);
        }
        this.f1905a.setOnClickListener(new ViewOnClickListenerC0089a(this, null));
        a();
        b();
        c();
        this.oauthWebView.a(new b(this));
        this.oauthWebView.a(new c(this));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        onFinish();
    }

    protected void onFinish() {
        finish();
    }

    private void a() {
        int iOauthResID;
        int iOauthResID2;
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        AuthInfo authInfo = this.c;
        if (authInfo != null && authInfo.getFindViewDelegate() != null) {
            iOauthResID = this.c.getFindViewDelegate().oauthResID(com.baidu.mobads.sdk.internal.b.a.b.b);
            iOauthResID2 = this.c.getFindViewDelegate().oauthResID(com.baidu.mobads.sdk.internal.b.a.b.g);
        } else {
            iOauthResID = R.layout.layout_bd_oauth_sdk_network_unavailable;
            iOauthResID2 = R.id.btn_network_settings;
        }
        View viewInflate = layoutInflater.inflate(iOauthResID, (ViewGroup) null);
        viewInflate.findViewById(iOauthResID2).setOnClickListener(new d(this));
        this.oauthWebView.a(viewInflate);
    }

    private void b() {
        int iOauthResID;
        int iOauthResID2;
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        AuthInfo authInfo = this.c;
        if (authInfo != null && authInfo.getFindViewDelegate() != null) {
            iOauthResID = this.c.getFindViewDelegate().oauthResID(com.baidu.mobads.sdk.internal.b.a.b.c);
            iOauthResID2 = this.c.getFindViewDelegate().oauthResID(com.baidu.mobads.sdk.internal.b.a.b.h);
        } else {
            iOauthResID = R.layout.layout_bd_oauth_sdk_loading_timeout;
            iOauthResID2 = R.id.btn_retry;
        }
        View viewInflate = layoutInflater.inflate(iOauthResID, (ViewGroup) null);
        viewInflate.findViewById(iOauthResID2).setOnClickListener(new e(this, viewInflate));
        this.oauthWebView.b(viewInflate);
    }

    private void c() {
        try {
            ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, com.baidu.oauth.sdkbqt.a.i.a(this, 2.0f), 0, 0));
            this.oauthWebView.a(progressBar);
        } catch (Throwable th) {
            com.baidu.oauth.sdkbqt.a.d.a(th);
        }
    }

    /* JADX INFO: renamed from: com.baidu.oauth.sdkbqt.view.a$a, reason: collision with other inner class name */
    private class ViewOnClickListenerC0089a implements View.OnClickListener {
        private ViewOnClickListenerC0089a() {
        }

        /* synthetic */ ViewOnClickListenerC0089a(a aVar, b bVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.oauthWebView.b();
        }
    }

    public void setTitle(String str) {
        this.b.setText(str);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.oauthWebView.a(com.baidu.oauth.sdkbqt.auth.i.b.ON_RESUME);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.oauthWebView.a(com.baidu.oauth.sdkbqt.auth.i.b.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.oauthWebView.destroy();
    }
}
