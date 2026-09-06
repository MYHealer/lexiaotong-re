package com.baidu.oauth.sdkbqt.auth;

import android.os.Looper;
import com.baidu.oauth.sdkbqt.callback.QrCodeCallback;
import com.baidu.oauth.sdkbqt.result.OauthResult;
import com.baidu.oauth.sdkbqt.result.QrCodeResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class e extends com.baidu.oauth.sdkbqt.a.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ QrCodeCallback f1873a;
    final /* synthetic */ QrCodeResult b;
    final /* synthetic */ c c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e(c cVar, Looper looper, QrCodeCallback qrCodeCallback, QrCodeResult qrCodeResult) {
        super(looper);
        this.c = cVar;
        this.f1873a = qrCodeCallback;
        this.b = qrCodeResult;
    }

    @Override // com.baidu.oauth.sdkbqt.a.a.f
    protected void a() {
        this.f1873a.onStart();
    }

    @Override // com.baidu.oauth.sdkbqt.a.a.f
    protected void b() {
        this.f1873a.onFinish();
    }

    @Override // com.baidu.oauth.sdkbqt.a.a.f
    protected void a(Throwable th, int i, String str) {
        this.b.setResultCode(i);
        this.f1873a.onFailure(this.b);
    }

    @Override // com.baidu.oauth.sdkbqt.a.a.f
    protected void a(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b.channelId = jSONObject.optString("channelid");
            this.b.url = jSONObject.optString("url");
            this.f1873a.onSuccess(this.b);
        } catch (JSONException e) {
            com.baidu.oauth.sdkbqt.a.d.a(e);
            this.b.setResultCode(OauthResult.ERROR_CODE_UNKNOW_ERROR);
            this.f1873a.onFailure(this.b);
        }
    }
}
