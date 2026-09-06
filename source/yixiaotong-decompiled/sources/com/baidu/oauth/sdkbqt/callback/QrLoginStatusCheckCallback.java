package com.baidu.oauth.sdkbqt.callback;

import com.baidu.oauth.sdkbqt.result.QrLoginStatusCheckResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public abstract class QrLoginStatusCheckCallback implements OauthCallback<QrLoginStatusCheckResult> {
    public abstract void onScanQrCodeDone(QrLoginStatusCheckResult qrLoginStatusCheckResult);
}
