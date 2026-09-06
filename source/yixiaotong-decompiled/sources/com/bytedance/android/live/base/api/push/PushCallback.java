package com.bytedance.android.live.base.api.push;

import com.bytedance.android.live.base.api.push.model.PushData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface PushCallback {
    void onFailed(Throwable th);

    void onSuccess(PushData pushData);
}
