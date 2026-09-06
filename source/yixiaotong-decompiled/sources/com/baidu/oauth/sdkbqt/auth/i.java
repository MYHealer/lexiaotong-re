package com.baidu.oauth.sdkbqt.auth;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.ubixnow.ooooo.oOo00o00;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public final class i extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f1876a = 90000;
    private static final String b = "i";
    private static final String c = "prompt_on_cancel";
    private Map<String, a> d;
    private k e;
    private C0088i f;
    private View g;
    private View h;
    private boolean i;
    private boolean j;
    private String k;
    private ProgressBar l;
    private long m;
    private Handler n;
    private j o;
    private g p;
    private f q;
    private h r;
    private com.baidu.oauth.sdkbqt.callback.b s;
    private c t;
    private JsPromptResult u;

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f1878a;
        public String b;
    }

    public interface d {
        void a(String str);
    }

    public interface f {
        void a();
    }

    public interface g {
        void a();
    }

    public interface h {
        boolean a();
    }

    public interface k {
        void a(String str);
    }

    public long a() {
        return this.m;
    }

    public void a(long j2) {
        this.m = j2;
    }

    public void a(c cVar) {
        this.t = cVar;
    }

    public void a(f fVar) {
        this.q = fVar;
    }

    public void a(g gVar) {
        this.p = gVar;
    }

    public void a(h hVar) {
        this.r = hVar;
    }

    public void a(k kVar) {
        this.e = kVar;
    }

    public void a(com.baidu.oauth.sdkbqt.callback.b bVar) {
        this.s = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class j implements Runnable {
        private String b;

        public void a(String str) {
            this.b = str;
        }

        private j() {
        }

        /* synthetic */ j(i iVar, com.baidu.oauth.sdkbqt.auth.j jVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.this.getProgress() < 100) {
                Message message = new Message();
                message.what = 1;
                message.obj = this.b;
                i.this.n.sendMessage(message);
                i.this.n.removeCallbacks(this);
            }
        }
    }

    public i(Context context) {
        super(context);
        this.d = new HashMap();
        com.baidu.oauth.sdkbqt.auth.j jVar = null;
        this.f = new C0088i(this, jVar);
        this.n = new com.baidu.oauth.sdkbqt.auth.j(this);
        this.o = new j(this, jVar);
        e();
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new HashMap();
        com.baidu.oauth.sdkbqt.auth.j jVar = null;
        this.f = new C0088i(this, jVar);
        this.n = new com.baidu.oauth.sdkbqt.auth.j(this);
        this.o = new j(this, jVar);
        e();
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new HashMap();
        com.baidu.oauth.sdkbqt.auth.j jVar = null;
        this.f = new C0088i(this, jVar);
        this.n = new com.baidu.oauth.sdkbqt.auth.j(this);
        this.o = new j(this, jVar);
        e();
    }

    public final void a(View view) {
        if (this.g == null) {
            this.g = view;
            view.setVisibility(4);
            addView(this.g, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public final void b(View view) {
        if (this.h == null) {
            this.h = view;
            view.setVisibility(4);
            addView(this.h, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void a(ProgressBar progressBar) {
        if (this.l != null) {
            return;
        }
        this.l = progressBar;
        if (progressBar != null) {
            addView(progressBar);
        }
    }

    private void e() {
        this.m = f1876a;
        g();
        this.j = TextUtils.isEmpty(new com.baidu.oauth.sdkbqt.auth.a().a(getContext()));
        setWebViewClient(new t(this));
        setWebChromeClient(new u(this));
        f();
    }

    private void f() {
        this.d.put("sapi_action_check_method_support", new x(this));
        this.d.put("finish", new y(this));
        this.d.put(com.alipay.sdk.widget.j.j, new z(this));
        this.d.put("action_set_title", new aa(this));
        this.d.put("sapi_goBack", new ab(this));
        this.d.put("oauth_sso_hash", new ac(this));
        this.d.put("authorized_response", new com.baidu.oauth.sdkbqt.auth.k(this));
        this.d.put("oauth_call_baidu", new m(this));
    }

    public void a(String str, Map<String, String> map) {
        new com.baidu.oauth.sdkbqt.auth.c().a(new n(this, map, str));
    }

    public void a(String str) {
        this.k = str;
        new com.baidu.oauth.sdkbqt.auth.c().a(new o(this));
    }

    public void b(String str) {
        this.k = str;
        loadUrl(a((Boolean) false));
    }

    public void c(String str) {
        this.k = str;
        loadUrl(a((Boolean) true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        HashMap map = new HashMap();
        map.put("response_type", "sso_auth_code");
        map.put("display", "mobile");
        try {
            map.put("sso_hash", URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            com.baidu.oauth.sdkbqt.a.d.d(b, "Failed to encode sso_hash", e2);
            map.put("sso_hash", str);
        }
        AuthInfo authInfo = BdOauthSdk.getAuthInfo();
        if (authInfo != null) {
            try {
                map.put("redirect_uri", URLEncoder.encode(authInfo.getRedirectUrl(), "UTF-8"));
            } catch (UnsupportedEncodingException e3) {
                com.baidu.oauth.sdkbqt.a.d.d(b, "Failed to encode redirect_uri", e3);
                map.put("redirect_uri", authInfo.getRedirectUrl());
            }
            map.put("scope", authInfo.getScope());
            map.put(oOo00o00.OooO0o, authInfo.getAppKey());
            map.put("eh1_us1", authInfo.isUseSha1() ? "1" : "0");
            map.put("eh2_pg", authInfo.getPackageName());
            map.put("eh3_pgs", authInfo.getPackSign());
        }
        map.put("client", "android");
        map.put("clientfrom", "native");
        map.put("suppcheck", "1");
        map.put("state", this.k);
        return com.baidu.oauth.sdkbqt.a.c.a(com.baidu.oauth.sdkbqt.a.b.g) + "?" + com.baidu.oauth.sdkbqt.a.h.a((HashMap<String, String>) map);
    }

    private String a(Boolean bool) {
        HashMap map = new HashMap();
        if (bool.booleanValue()) {
            map.put("silentAuth", "1");
        }
        map.put("response_type", "code");
        map.put("display", "mobile");
        AuthInfo authInfo = BdOauthSdk.getAuthInfo();
        if (authInfo != null) {
            try {
                map.put("redirect_uri", URLEncoder.encode(authInfo.getRedirectUrl(), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                com.baidu.oauth.sdkbqt.a.d.d(b, "Failed to encode redirect_uri", e2);
                map.put("redirect_uri", authInfo.getRedirectUrl());
            }
            map.put("scope", authInfo.getScope());
            map.put("eh2_pg", authInfo.getPackageName());
            map.put("eh3_pgs", authInfo.getPackSign());
            map.put("eh1_us1", authInfo.isUseSha1() ? "1" : "0");
        }
        map.put("login_type", "sms");
        map.put(oOo00o00.OooO0o, authInfo.getAppKey());
        map.put("state", this.k);
        return com.baidu.oauth.sdkbqt.a.c.a(com.baidu.oauth.sdkbqt.a.b.g) + "?" + com.baidu.oauth.sdkbqt.a.h.a((HashMap<String, String>) map);
    }

    @Override // android.webkit.WebView
    public void reload() {
        if (this.f.f1880a != null) {
            loadUrl(this.f.f1880a);
        } else {
            super.reload();
        }
        this.f.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: com.baidu.oauth.sdkbqt.auth.i$i, reason: collision with other inner class name */
    class C0088i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f1880a;

        void a() {
            this.f1880a = null;
        }

        private C0088i() {
            this.f1880a = null;
        }

        /* synthetic */ C0088i(i iVar, com.baidu.oauth.sdkbqt.auth.j jVar) {
            this();
        }
    }

    private void g() {
        try {
            getSettings().setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            com.baidu.oauth.sdkbqt.a.d.a(e2);
        }
        getSettings().setUserAgentString(j());
        getSettings().setDomStorageEnabled(true);
        setScrollBarStyle(0);
        getSettings().setSaveFormData(false);
        getSettings().setSavePassword(false);
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setSavePassword(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        View view = this.g;
        if (view != null && view.getVisibility() == 0) {
            return false;
        }
        View view2 = this.h;
        if (view2 == null || view2.getVisibility() != 0) {
            return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        return false;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        View view;
        View view2 = this.g;
        if ((view2 != null && view2.getVisibility() == 0) || ((view = this.h) != null && view.getVisibility() == 0)) {
            super.scrollTo(0, 0);
        }
        super.scrollTo(i, i2);
    }

    public enum b {
        ON_RESUME("webViewWillAppear"),
        ON_PAUSE("webViewWillDisappear");

        String c;

        b(String str) {
            this.c = str;
        }
    }

    public void a(b bVar) {
        if (getSettings().getBlockNetworkLoads()) {
            return;
        }
        loadUrl(e(bVar.c));
    }

    private String e(String str) {
        return String.format("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.%s){ Pass.client.%s()}}())", str, str);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        a(str, new HashMap<>(0));
    }

    public void a(String str, HashMap<String, String> map) {
        f(str);
    }

    private void f(String str) {
        post(new p(this, str));
        if (com.baidu.oauth.sdkbqt.a.h.a(getContext()) || str.startsWith("javascript:")) {
            return;
        }
        i();
    }

    public void b() {
        View view;
        if (canGoBack()) {
            com.baidu.oauth.sdkbqt.a.h.a((Activity) getContext());
            goBack();
        } else {
            c();
        }
        View view2 = this.g;
        if ((view2 == null || view2.getVisibility() != 0) && ((view = this.h) == null || view.getVisibility() != 0)) {
            return;
        }
        c();
    }

    public void c() {
        if (this.p != null) {
            post(new q(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        stopLoading();
        post(new r(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        post(new s(this));
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        ProgressBar progressBar = this.l;
        if (progressBar != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) progressBar.getLayoutParams();
            layoutParams.x = i;
            layoutParams.y = i2;
            this.l.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    abstract class a {
        public abstract String a(e eVar);

        a() {
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1879a;
        private List<String> b = new ArrayList();
        private String c;

        public String a() {
            return this.f1879a;
        }

        public List<String> b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        e() {
        }

        public static e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str.toString());
                e eVar = new e();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("action");
                if (jSONObjectOptJSONObject != null) {
                    eVar.f1879a = jSONObjectOptJSONObject.optString("name");
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("params");
                    if (jSONArrayOptJSONArray != null) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            eVar.b.add(jSONArrayOptJSONArray.optString(i));
                        }
                    }
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("callback");
                if (jSONObjectOptJSONObject2 != null) {
                    eVar.c = jSONObjectOptJSONObject2.optString("name");
                }
                return eVar;
            } catch (JSONException e) {
                com.baidu.oauth.sdkbqt.a.d.a(e);
                return null;
            }
        }
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (NullPointerException unused) {
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.i = true;
        this.n.removeCallbacks(this.o);
    }

    private String j() {
        return getSettings().getUserAgentString() + PPSLabelView.Code + URLEncoder.encode("bdoa_2.0.6.10_Android_" + com.baidu.oauth.sdkbqt.a.h.c(getContext()) + "_" + com.baidu.oauth.sdkbqt.a.h.b(getContext()) + "_" + (!TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "") + "_" + (TextUtils.isEmpty(Build.VERSION.RELEASE) ? "" : Build.VERSION.RELEASE));
    }

    public static String a(Map<String, String> map, boolean z) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (sb.length() > 0 || z) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            if (value == null) {
                try {
                    sb.append(key).append("=");
                } catch (Exception e2) {
                    sb.append(key).append("=").append((Object) value);
                    e2.printStackTrace();
                }
            } else {
                sb.append(key).append("=").append(URLEncoder.encode(value.toString(), "UTF-8"));
            }
        }
        return sb.toString();
    }
}
