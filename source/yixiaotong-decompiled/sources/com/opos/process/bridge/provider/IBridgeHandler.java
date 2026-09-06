package com.opos.process.bridge.provider;

import android.content.Context;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface IBridgeHandler {

    public interface Factory {
        IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify);
    }
}
