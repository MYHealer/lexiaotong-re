package com.bykv.vk.openvk.api.proto;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface Initializer {
    Manager getManager();

    void init(Context context, ValueSet valueSet);

    boolean isInitSuccess();
}
