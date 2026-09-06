package com.baidu.oauth.sdkbqt.auth;

import android.os.Looper;
import com.baidu.oauth.sdkbqt.callback.QrLoginStatusCheckCallback;
import com.baidu.oauth.sdkbqt.result.OauthResult;
import com.baidu.oauth.sdkbqt.result.QrLoginStatusCheckResult;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class g extends com.baidu.oauth.sdkbqt.a.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f1875a;
    final /* synthetic */ QrLoginStatusCheckCallback b;
    final /* synthetic */ QrLoginStatusCheckResult c;
    final /* synthetic */ String d;
    final /* synthetic */ c e;

    @Override // com.baidu.oauth.sdkbqt.a.a.f
    protected void b() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    g(c cVar, Looper looper, boolean z, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, String str) {
        super(looper);
        this.e = cVar;
        this.f1875a = z;
        this.b = qrLoginStatusCheckCallback;
        this.c = qrLoginStatusCheckResult;
        this.d = str;
    }

    @Override // com.baidu.oauth.sdkbqt.a.a.f
    protected void a() {
        if (this.f1875a) {
            this.b.onStart();
        }
    }

    @Override // com.baidu.oauth.sdkbqt.a.a.f
    protected void a(Throwable th, int i, String str) {
        this.c.setResultCode(i);
        this.b.onFailure(this.c);
        this.b.onFinish();
    }

    @Override // com.baidu.oauth.sdkbqt.a.a.f
    protected void a(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str.substring(3, str.length() - 2));
            int iOptInt = jSONObject.optInt("errno", -1);
            String strOptString = jSONObject.optString("errmsg");
            this.c.setResultCode(iOptInt);
            this.c.setResultMsg(strOptString);
            if (iOptInt == 0) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("channel_v"));
                int iOptInt2 = jSONObject2.optInt("status");
                if (iOptInt2 == 0) {
                    this.c.setCode(jSONObject2.optString("code"));
                    this.c.setState(c.c);
                    this.b.onSuccess(this.c);
                } else if (iOptInt2 == 1) {
                    this.b.onScanQrCodeDone(this.c);
                    this.e.a(this.d, false, this.b);
                } else if (iOptInt2 == 2) {
                    this.c.setResultCode(-208);
                    this.b.onFailure(this.c);
                    this.b.onFinish();
                } else {
                    this.c.setResultCode(OauthResult.ERROR_CODE_UNKNOW_ERROR);
                    this.b.onFailure(this.c);
                    this.b.onFinish();
                }
            } else if (iOptInt == 1) {
                this.e.a(this.d, false, this.b);
            } else {
                this.b.onFailure(this.c);
                this.b.onFinish();
            }
        } catch (Exception e) {
            this.c.setResultCode(OauthResult.ERROR_CODE_UNKNOW_ERROR);
            this.b.onFailure(this.c);
            this.b.onFinish();
            com.baidu.oauth.sdkbqt.a.d.a(e);
        }
    }
}
