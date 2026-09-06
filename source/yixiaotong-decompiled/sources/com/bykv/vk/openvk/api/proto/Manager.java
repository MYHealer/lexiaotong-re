package com.bykv.vk.openvk.api.proto;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface Manager {
    Loader createLoader(Context context);

    Bridge getBridge(int i);

    ValueSet values();
}
