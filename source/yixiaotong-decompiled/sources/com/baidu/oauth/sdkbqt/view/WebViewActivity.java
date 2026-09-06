package com.baidu.oauth.sdkbqt.view;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.oauth.sdkbqt.auth.BdSsoHandler;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class WebViewActivity extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1904a = "WebViewActivity";
    private static final String b = "extra_oauth_result_json";
    private static final int c = -201;
    private static final int d = -205;
    private boolean e = false;
    private boolean f = false;

    static {
        StubApp.interface11(13557);
    }

    private void b() {
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    private void c() {
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        getWindow().getDecorView().setBackgroundColor(-657931);
    }

    @Override // com.baidu.oauth.sdkbqt.view.a
    protected void setupViews() {
        super.setupViews();
        setTitle("百度");
        String stringExtra = getIntent().getStringExtra(BdSsoHandler.EXTRA_REDIRECT_URL);
        String stringExtra2 = getIntent().getStringExtra(BdSsoHandler.EXTRA_QR_CODE_URL);
        String stringExtra3 = getIntent().getStringExtra(BdSsoHandler.EXTRA_SCOPE);
        boolean booleanExtra = getIntent().getBooleanExtra(BdSsoHandler.EXTRA_DEGRADE_H5_AUTH, false);
        boolean booleanExtra2 = getIntent().getBooleanExtra(BdSsoHandler.EXTRA_DEGRADE_EXEMPT_AUTH_PAGE, false);
        this.oauthWebView.a(new j(this));
        k kVar = new k(this, stringExtra, stringExtra2, stringExtra3);
        com.baidu.oauth.sdkbqt.auth.i.c cVar = new com.baidu.oauth.sdkbqt.auth.i.c();
        cVar.b = stringExtra;
        cVar.f1878a = kVar;
        this.oauthWebView.a(cVar);
        String stringExtra4 = getIntent().getStringExtra(BdSsoHandler.EXTRA_OAUTH_STATE);
        if (getIntent().getIntExtra(BdSsoHandler.EXTRA_GUID_TYPE, 0) == 1) {
            HashMap map = new HashMap();
            map.put("client", "android");
            map.put("clientfrom", "native");
            map.put("suppcheck", "1");
            map.put("oauth_redirect_uri", stringExtra);
            map.put("getauthorizationcode", "1");
            this.oauthWebView.a(stringExtra2, (Map<String, String>) map);
            return;
        }
        if (booleanExtra2) {
            this.oauthWebView.c(stringExtra4);
        } else if (booleanExtra) {
            this.oauthWebView.b(stringExtra4);
        } else {
            this.oauthWebView.a(stringExtra4);
        }
    }

    @Override // com.baidu.oauth.sdkbqt.view.a
    protected void onFinish() {
        setResult(0, com.baidu.oauth.sdkbqt.a.i.a(-205));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent a(int i) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            String str = "1";
            jSONObject.put("showLogin", this.e ? "1" : "0");
            if (!this.f) {
                str = "0";
            }
            jSONObject.put("finishLogin", str);
        } catch (JSONException e) {
            com.baidu.oauth.sdkbqt.a.d.a(e);
        }
        intent.putExtra("extra_oauth_result_json", jSONObject.toString());
        return intent;
    }
}
