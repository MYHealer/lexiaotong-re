package com.byazt.dna;

import android.content.Context;
import android.os.Looper;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface h {
    com.byazt.fk.sp createTTLiveVideoPlayer(Context context, boolean z, long j, JSONObject jSONObject, Looper looper);

    com.byazt.fk.sp createTTVideoPlayer(Context context, String str);

    com.byazt.fk.c createVideoCacheDir();

    com.byazt.fk.da createVideoPreload();

    int getLiveSupportCode();

    boolean isTTVideoOk();

    void openDebugLog(boolean z);

    void preloadTTVideo(Context context, String str, int i, String[] strArr, long[] jArr, boolean z);
}
