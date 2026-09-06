package com.bykv.vk.component.ttvideo.medialoader;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface MediaLoaderListener {
    long getInt64Value(int i, long j);

    void onDataLoaderError(int i, String str);

    void onLogInfo(int i, String str, JSONObject jSONObject);

    void onNotify(int i, long j, long j2, String str);

    void onSwitchLoaderType(int i, String str);
}
