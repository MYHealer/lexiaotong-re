package com.baidu.oauth.sdkbqt.auth;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class AuthInfo implements com.baidu.oauth.sdkbqt.a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1862a = "AuthInfo";
    private Context b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private FindViewDelegate i;
    private boolean j;

    public interface FindViewDelegate extends com.baidu.oauth.sdkbqt.a.e {
        int oauthResID(String str);
    }

    public String getAppKey() {
        return this.c;
    }

    public Context getContext() {
        return this.b;
    }

    public String getDeviceId() {
        return this.h;
    }

    public FindViewDelegate getFindViewDelegate() {
        return this.i;
    }

    public String getPackSign() {
        return this.g;
    }

    public String getPackageName() {
        return this.f;
    }

    public String getRedirectUrl() {
        return this.d;
    }

    public String getScope() {
        return this.e;
    }

    public boolean isUseSha1() {
        return this.j;
    }

    public void setFindViewDelegate(FindViewDelegate findViewDelegate) {
        this.i = findViewDelegate;
    }

    public void setUseSha1(boolean z) {
        this.j = z;
        if (z) {
            this.g = com.baidu.oauth.sdkbqt.a.h.b(this.b, this.f);
        } else {
            this.g = com.baidu.oauth.sdkbqt.a.h.a(this.b, this.f);
        }
    }

    public AuthInfo(Context context, String str, String str2, String str3) {
        this(context, str, str2, str3, false);
    }

    public AuthInfo(Context context, String str, String str2, String str3, String str4) {
        this(context, str, str2, str3, false, str4);
    }

    public AuthInfo(Context context, String str, String str2, String str3, boolean z) {
        this(context, str, str2, str3, z, "");
    }

    public AuthInfo(Context context, String str, String str2, String str3, boolean z, String str4) {
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.j = false;
        com.baidu.oauth.sdkbqt.a.h.a((Object) context, "AuthInfo Constructor params context is null");
        com.baidu.oauth.sdkbqt.a.h.a(str, "AuthInfo Constructor params appKey is null");
        com.baidu.oauth.sdkbqt.a.h.a(str2, "AuthInfo Constructor params redirectUrl is null");
        com.baidu.oauth.sdkbqt.a.h.a(str3, "AuthInfo Constructor params scope is null");
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.c = str;
        this.d = str2;
        this.e = str3;
        String packageName = context.getPackageName();
        this.f = packageName;
        this.h = str4;
        this.j = z;
        if (z) {
            this.g = com.baidu.oauth.sdkbqt.a.h.b(context, packageName);
        } else {
            this.g = com.baidu.oauth.sdkbqt.a.h.a(context, packageName);
        }
    }

    public AuthInfo isDebug(boolean z) {
        com.baidu.oauth.sdkbqt.a.d.b = z;
        com.baidu.oauth.sdkbqt.a.d.a("oauthAuthInfo", "packageName:" + this.f + " ,packSign= " + this.g + " ,useSha1= " + this.j);
        return this;
    }

    public AuthInfo setEnv(int i) {
        com.baidu.oauth.sdkbqt.a.c.a(i);
        return this;
    }
}
