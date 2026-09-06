package com.baidu.oauth.sdkbqt.auth;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.oauth.sdkbqt.callback.QrCodeCallback;
import com.baidu.oauth.sdkbqt.callback.QrLoginStatusCheckCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class BdOauthSdk implements com.baidu.oauth.sdkbqt.a.e {
    private static BdOauthSdk c = new BdOauthSdk();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1863a = false;
    private AuthInfo b;

    private BdOauthSdk() {
    }

    public static void init(AuthInfo authInfo) {
        if (c.f1863a) {
            return;
        }
        if (authInfo == null || TextUtils.isEmpty(authInfo.getAppKey()) || TextUtils.isEmpty(authInfo.getRedirectUrl())) {
            throw new RuntimeException("please set right app info (appKey,redirect");
        }
        BdOauthSdk bdOauthSdk = c;
        bdOauthSdk.b = authInfo;
        bdOauthSdk.f1863a = true;
    }

    public static void changeInfo(AuthInfo authInfo) {
        if (!c.f1863a) {
            throw new RuntimeException("bd sdk was not initall! please use: BdSdk.init() in your app Application or your main Activity. when you want to use bd sdk function, make sure call BdSdk.init() before this function");
        }
        if (authInfo == null || TextUtils.isEmpty(authInfo.getAppKey()) || TextUtils.isEmpty(authInfo.getRedirectUrl())) {
            throw new RuntimeException("please set right app info (appKey,redirect");
        }
        c.b = authInfo;
    }

    private static void a() {
        if (!c.f1863a) {
            throw new RuntimeException("bd sdk was not initall! please use: BdSdk.init() in your app Application or your main Activity. when you want to use bd sdk function, make sure call BdSdk.init() before this function");
        }
    }

    public static AuthInfo getAuthInfo() {
        a();
        return c.b;
    }

    public static BdOauthSdk getInstance() {
        a();
        return c;
    }

    public void getQrCode(String str, QrCodeCallback qrCodeCallback) {
        new c().a(str, qrCodeCallback);
    }

    public void stopLoginStatusCheck() {
        new c().a();
    }

    public void qrLoginStatusCheck(String str, QrLoginStatusCheckCallback qrLoginStatusCheckCallback) {
        new c().a(str, true, qrLoginStatusCheckCallback);
    }

    public boolean isQrLoginSchema(String str) {
        return com.baidu.oauth.sdkbqt.a.h.c(str);
    }

    public static void clearCookies(Context context) {
        new a().b(context, "");
        new a().d(context, "");
        new a().c(context, "");
    }
}
