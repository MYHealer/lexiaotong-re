package com.baidu.oauth.sdkbqt.auth;

import com.baidu.oauth.sdkbqt.callback.QrLoginStatusCheckCallback;
import com.baidu.oauth.sdkbqt.result.QrLoginStatusCheckResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class f extends QrLoginStatusCheckCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ QrLoginStatusCheckCallback f1874a;
    final /* synthetic */ c b;

    f(c cVar, QrLoginStatusCheckCallback qrLoginStatusCheckCallback) {
        this.b = cVar;
        this.f1874a = qrLoginStatusCheckCallback;
    }

    @Override // com.baidu.oauth.sdkbqt.callback.QrLoginStatusCheckCallback
    public void onScanQrCodeDone(QrLoginStatusCheckResult qrLoginStatusCheckResult) {
        this.f1874a.onScanQrCodeDone(qrLoginStatusCheckResult);
    }

    @Override // com.baidu.oauth.sdkbqt.callback.OauthCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(QrLoginStatusCheckResult qrLoginStatusCheckResult) {
        this.f1874a.onSuccess(qrLoginStatusCheckResult);
        this.b.f1871a = null;
    }

    @Override // com.baidu.oauth.sdkbqt.callback.OauthCallback
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onFailure(QrLoginStatusCheckResult qrLoginStatusCheckResult) {
        this.f1874a.onFailure(qrLoginStatusCheckResult);
        this.b.f1871a = null;
    }

    @Override // com.baidu.oauth.sdkbqt.callback.OauthCallback
    public void onStart() {
        this.f1874a.onStart();
    }

    @Override // com.baidu.oauth.sdkbqt.callback.OauthCallback
    public void onFinish() {
        this.f1874a.onFinish();
    }
}
