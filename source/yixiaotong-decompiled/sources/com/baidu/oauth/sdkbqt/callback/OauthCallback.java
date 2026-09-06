package com.baidu.oauth.sdkbqt.callback;

import com.baidu.oauth.sdkbqt.result.OauthResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface OauthCallback<R extends OauthResult> {
    void onFailure(R r);

    void onFinish();

    void onStart();

    void onSuccess(R r);
}
