package com.yfanads.android.adx.newplayer.videocache.sourcestorage;

import com.yfanads.android.adx.newplayer.videocache.SourceInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface SourceInfoStorage {
    SourceInfo get(String str);

    void put(String str, SourceInfo sourceInfo);

    void release();
}
