package com.baidu.oauth.sdkbqt.auth;

import android.os.Looper;
import com.baidu.oauth.sdkbqt.callback.QrCodeCallback;
import com.baidu.oauth.sdkbqt.callback.QrLoginStatusCheckCallback;
import com.baidu.oauth.sdkbqt.result.QrCodeResult;
import com.baidu.oauth.sdkbqt.result.QrLoginStatusCheckResult;
import com.baidu.passbqt.http.PassHttpClientRequest;
import com.baidu.passbqt.http.ReqPriority;
import com.cdo.oaps.ad.OapsKey;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.ubixnow.ooooo.oOo00o00;
import java.net.HttpCookie;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class c {
    private static String c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.baidu.oauth.sdkbqt.a.a.a f1871a;
    private PassHttpClientRequest b;

    c() {
    }

    void a(com.baidu.oauth.sdkbqt.callback.a aVar) {
        new b(new d(this, aVar)).execute(com.baidu.oauth.sdkbqt.a.h.b(com.baidu.oauth.sdkbqt.a.b.f));
    }

    void a(String str, QrCodeCallback qrCodeCallback) {
        com.baidu.oauth.sdkbqt.a.h.a(qrCodeCallback, "QrCodeCallback can not null");
        com.baidu.oauth.sdkbqt.a.a.g gVar = new com.baidu.oauth.sdkbqt.a.a.g();
        gVar.a("response_type", "sso_qrcode");
        AuthInfo authInfo = BdOauthSdk.getAuthInfo();
        gVar.a(oOo00o00.OooO0o, authInfo.getAppKey());
        gVar.a("redirect_uri", authInfo.getRedirectUrl());
        gVar.a("scope", authInfo.getScope());
        gVar.a("get_auth_code", "1");
        c = str;
        new com.baidu.oauth.sdkbqt.a.a.a().a(com.baidu.oauth.sdkbqt.a.c.a(com.baidu.oauth.sdkbqt.a.b.h), gVar, new e(this, Looper.getMainLooper(), qrCodeCallback, new QrCodeResult()));
    }

    void a() {
        PassHttpClientRequest passHttpClientRequest = this.b;
        if (passHttpClientRequest != null) {
            passHttpClientRequest.a();
        }
        if (this.f1871a != null) {
            this.f1871a = null;
            c = null;
        }
    }

    void a(String str, boolean z, QrLoginStatusCheckCallback qrLoginStatusCheckCallback) {
        com.baidu.oauth.sdkbqt.a.h.a(qrLoginStatusCheckCallback, "QrLoginStatusCheckCallback can not null");
        com.baidu.oauth.sdkbqt.a.h.a(str, "channelId can not null");
        f fVar = new f(this, qrLoginStatusCheckCallback);
        com.baidu.oauth.sdkbqt.a.a.g gVar = new com.baidu.oauth.sdkbqt.a.a.g();
        gVar.a("channel_id", str);
        gVar.a("tpl", "dev");
        gVar.a("callback", OapsKey.KEY_CALLBACK);
        QrLoginStatusCheckResult qrLoginStatusCheckResult = new QrLoginStatusCheckResult();
        this.f1871a = new com.baidu.oauth.sdkbqt.a.a.a();
        this.b = this.f1871a.a(com.baidu.oauth.sdkbqt.a.c.a() + com.baidu.oauth.sdkbqt.a.h.b(com.baidu.oauth.sdkbqt.a.b.i), ReqPriority.IMMEDIATE, gVar, (List<HttpCookie>) null, (String) null, MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND, new g(this, Looper.getMainLooper(), z, fVar, qrLoginStatusCheckResult, str));
    }
}
